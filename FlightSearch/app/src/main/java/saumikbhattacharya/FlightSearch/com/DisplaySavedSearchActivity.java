package saumikbhattacharya.FlightSearch.com;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class DisplaySavedSearchActivity extends AppCompatActivity {

    public static final String SQL_SELECT_QUERY = "SELECT * FROM "+AndroidOpenDbHelper.TABLE_NAME_FLIGHTSEARCH_DTL+" ORDER BY "+AndroidOpenDbHelper._ID+" DESC";
    ArrayList<ListRowItem> listItems = new ArrayList<>();
    Context context = DisplaySavedSearchActivity.this;
    ListView listView;
    ListRowItem currentListItem;
    String Origin,Destination,Start_Date,Num_Adult,Num_Infant,str_jsonresponse,Current_Date;
    String respFlg = null;
    Boolean isInternetConnected = false;
    ConnectionDetector cd;
    JSONArray l2_jsonarray = null;
    public final static String STR_JSONRESPONSE = "saumikbhattacharya.FlightSearch.com.STR_JSONRESPONSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("All Saved Search");
        setContentView(R.layout.activity_display_saved_search);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setBackgroundResource(R.drawable.androidbckgrnd1);

        cd = new ConnectionDetector(context);

        try
        {
            AndroidOpenDbHelper queryDbHelperObj = new AndroidOpenDbHelper(this);
            SQLiteDatabase sqLiteDatabase = queryDbHelperObj.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(SQL_SELECT_QUERY,null);

            if(cursor != null)
            {
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String OriginDB = cursor.getString(cursor.getColumnIndex("Origin"));
                        String DestinationDB = cursor.getString(cursor.getColumnIndex("Destination"));
                        String StartDateDB = cursor.getString(cursor.getColumnIndex("Start_Date"));
                        String Num_Adlt_DB = cursor.getString(cursor.getColumnIndex("Num_Adult"));
                        String Num_Infant_DB = cursor.getString(cursor.getColumnIndex("Num_Infant"));
                        String CurrentDateDB = cursor.getString(cursor.getColumnIndex("Current_Date"));

                        ListRowItem lr = new ListRowItem();
                        lr.setOrigin(OriginDB);
                        lr.setDestination(DestinationDB);
                        lr.setDepartureDate(StartDateDB);
                        lr.setAdult(Num_Adlt_DB);
                        lr.setInfant(Num_Infant_DB);
                        lr.setCurrentDate(CurrentDateDB);

                        listItems.add(lr);

                    }while(cursor.moveToNext());
                }
            }
            MyBaseAdapterDB baseAdapter = new MyBaseAdapterDB(context,listItems);
            listView.setAdapter(baseAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    currentListItem = listItems.get(position);
                    Origin = currentListItem.getOrigin();
                    Destination = currentListItem.getDestination();
                    Start_Date = currentListItem.getDepartureDate();
                    Num_Adult = currentListItem.getAdult();
                    Num_Infant = currentListItem.getInfant();
                    Current_Date = currentListItem.getCurrentdate();

                    int Origin_Sbracket = Origin.indexOf("(");
                    int Origin_Ebracket = Origin.indexOf(")");
                    int Dest_Sbracket = Destination.indexOf("(");
                    int Dest_Ebracket = Destination.indexOf(")");
                    Origin = Origin.substring(Origin_Sbracket + 1, Origin_Ebracket);
                    Destination = Destination.substring(Dest_Sbracket + 1, Dest_Ebracket);

                    isInternetConnected = cd.isConnectingToInternet();

                    if(Start_Date.compareTo(Current_Date)<0)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Start Date cannot be before Today!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    else if(!isInternetConnected)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage("You are not connected to the Internet!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    else {
                        MakeRequestTask client = new MakeRequestTask();
                        client.execute();
                    }
                }
            });
        }catch(Exception err)
        {
            err.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_saved_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public class MakeRequestTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            listView.setClickable(true);
            Intent intent = new Intent(context,DisplayFlightsActivity.class);
            Bundle extras = new Bundle();

            if("N".equals(respFlg))
            {
                Toast.makeText(DisplaySavedSearchActivity.this,
                        "No Direct Flights found at this time! Please modify your search!", Toast.LENGTH_LONG).show();
            }
            else
            {
                extras.putString(STR_JSONRESPONSE, str_jsonresponse);
                intent.putExtras(extras);
                startActivity(intent);
            }
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            Toast.makeText(DisplaySavedSearchActivity.this,
                    "Please wait..while we bring you the flight details", Toast.LENGTH_LONG).show();
            listView.setClickable(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub

            try{
                HttpsURLConnection connection = null;

                URL url = new URL("https://www.googleapis.com/qpxExpress/v1/trips/search?key=AIzaSyDbg1n8mdY3xAWYBy05ixrPtvRdc4R3Mys");
                connection = (HttpsURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setUseCaches(false);
                connection.setConnectTimeout(7200000);
                connection.setReadTimeout(720000);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.connect();

                JSONObject request_hdr = new JSONObject();
                JSONObject request = new JSONObject();
                JSONArray slice = new JSONArray();
                JSONObject data = new JSONObject();

                request.put("solutions", 20);
                request.put("refundable", "false");

                JSONObject addl_info = new JSONObject();
                addl_info.put("adultCount", Num_Adult);
                addl_info.put("infantInLapCount", Num_Infant);
                addl_info.put("infantInSeatCount", 0);
                addl_info.put("childCount", 0);
                addl_info.put("seniorCount", 0);
                request.put("passengers", addl_info);

                data.put("origin", Origin);
                data.put("destination", Destination);
                data.put("date", Start_Date);
                data.put("maxStops", 0);
                slice.put(data);
                request.put("slice", slice);

                request_hdr.put("request", request);

                OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
                output.write(request_hdr.toString());
                output.flush();
                output.close();

                int HttpResult = connection.getResponseCode();

                if(HttpResult == 400){
                    Toast.makeText(DisplaySavedSearchActivity.this,
                            "Something went wrong here!", Toast.LENGTH_LONG).show();
                }
                else if(HttpResult == 403){
                    Toast.makeText(DisplaySavedSearchActivity.this,
                            "Not authorized! Might have exceeded maximum number of requests per day!", Toast.LENGTH_LONG).show();
                }
                else if(HttpResult == 200) {
                    StringBuilder jsonresponse = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String receiveString = null;

                    while ((receiveString = bufferedReader.readLine()) != null) {
                        jsonresponse.append(receiveString);
                    }

                    str_jsonresponse = jsonresponse.toString();

                    JSONObject root_jsonresponse = new JSONObject(str_jsonresponse);
                    JSONObject l1_jsonobject = root_jsonresponse.optJSONObject("trips");
                    l2_jsonarray = l1_jsonobject.optJSONArray("tripOption");

                    if(l2_jsonarray == null)
                    {
                        respFlg = "N";
                    }

                    bufferedReader.close();
                }

                connection.disconnect();
            }catch(JSONException JE){
                JE.printStackTrace();
            }
            catch (Exception err){
                err.printStackTrace();
            }
            return null;
        }
    }
}
