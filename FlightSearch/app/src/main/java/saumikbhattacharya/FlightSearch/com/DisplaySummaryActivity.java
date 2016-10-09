package saumikbhattacharya.FlightSearch.com;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class DisplaySummaryActivity extends AppCompatActivity {

    String Origin,Destination,Start_Date,Num_Adult,Num_Infant,str_jsonresponse;
    Button Search_Button;
    String respFlg = null;
    Boolean isInternetConnected = false;
    ConnectionDetector cd;
    JSONArray l2_jsonarray = null;
    public final static String STR_JSONRESPONSE = "saumikbhattacharya.FlightSearch.com.STR_JSONRESPONSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Origin = extras.getString(MainActivity.ORIGIN);
        Destination = extras.getString(MainActivity.DESTINATION);
        Start_Date = extras.getString(MainActivity.START_DATE);
        Num_Adult = extras.getString(MainActivity.ADULT);
        Num_Infant = extras.getString(MainActivity.INFANT);

        cd = new ConnectionDetector(getApplicationContext());

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setStretchAllColumns(true);
        tableLayout.setGravity(Gravity.CENTER_VERTICAL);
        tableLayout.setBackgroundResource(R.drawable.androidbckgrnd1);
        tableLayout.setVerticalScrollBarEnabled(true);

        TableRow TRH_Title = new TableRow(this);
        TRH_Title.setPadding(0, 0, 0, 40);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 2;

        TextView Title = new TextView(this);
        Title.setText("Search Summary");
        Title.setTextSize(25);
        Title.setTypeface(Typeface.DEFAULT_BOLD);
        Title.setGravity(Gravity.CENTER_HORIZONTAL);

        TRH_Title.addView(Title, params);

        tableLayout.addView(TRH_Title);

        TableRow TRH_Origin = new TableRow(this);

        TextView Label_Origin = new TextView(this);
        Label_Origin.setText("Origin :");
        Label_Origin.setTextSize(20);
        Label_Origin.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Origin.setGravity(Gravity.END);

        TextView Value_Origin = new TextView(this);
        Value_Origin.setText(Origin);
        Value_Origin.setTextSize(20);
        Value_Origin.setGravity(Gravity.START);

        TRH_Origin.addView(Label_Origin);
        TRH_Origin.addView(Value_Origin);

        tableLayout.addView(TRH_Origin);

        TableRow TRH_Destination = new TableRow(this);

        TextView Label_Destination = new TextView(this);
        Label_Destination.setText("Destination :");
        Label_Destination.setTextSize(20);
        Label_Destination.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Destination.setGravity(Gravity.END);

        TextView Value_Destination = new TextView(this);
        Value_Destination.setText(Destination);
        Value_Destination.setTextSize(20);
        Value_Destination.setGravity(Gravity.START);

        TRH_Destination.addView(Label_Destination);
        TRH_Destination.addView(Value_Destination);

        tableLayout.addView(TRH_Destination);

        TableRow TRH_Start_Date = new TableRow(this);

        TextView Label_Start_Date = new TextView(this);
        Label_Start_Date.setText("Start Date :");
        Label_Start_Date.setTextSize(20);
        Label_Start_Date.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Start_Date.setGravity(Gravity.END);

        TextView Value_Start_Date = new TextView(this);
        Value_Start_Date.setText(Start_Date);
        Value_Start_Date.setTextSize(20);
        Value_Start_Date.setGravity(Gravity.START);

        TRH_Start_Date.addView(Label_Start_Date);
        TRH_Start_Date.addView(Value_Start_Date);

        tableLayout.addView(TRH_Start_Date);

        TableRow TRH_Adult = new TableRow(this);

        TextView Label_Adult = new TextView(this);
        Label_Adult.setText("Adult :");
        Label_Adult.setTextSize(20);
        Label_Adult.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Adult.setGravity(Gravity.END);

        TextView Value_Adult = new TextView(this);
        Value_Adult.setText(Num_Adult);
        Value_Adult.setTextSize(20);
        Value_Adult.setGravity(Gravity.START);

        TRH_Adult.addView(Label_Adult);
        TRH_Adult.addView(Value_Adult);

        tableLayout.addView(TRH_Adult);

        TableRow TRH_Infant = new TableRow(this);

        TextView Label_Infant = new TextView(this);
        Label_Infant.setText("Infant :");
        Label_Infant.setTextSize(20);
        Label_Infant.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Infant.setGravity(Gravity.END);

        TextView Value_Infant = new TextView(this);
        Value_Infant.setText(Num_Infant);
        Value_Infant.setTextSize(20);
        Value_Infant.setGravity(Gravity.START);

        TRH_Infant.addView(Label_Infant);
        TRH_Infant.addView(Value_Infant);

        tableLayout.addView(TRH_Infant);

        TableRow TRH_Button = new TableRow(this);
        TableRow.LayoutParams params1 = new TableRow.LayoutParams();
        TRH_Button.setPadding(30, 40, 30, 0);
        params1.span = 2;

        Search_Button = new Button(this);
        Search_Button.setGravity(Gravity.CENTER_HORIZONTAL);
        Search_Button.setText("Search");
        Search_Button.setTextColor(Color.parseColor("#FFFF00"));
        Search_Button.setBackgroundColor(Color.parseColor("#0000FF"));
        Search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int Origin_Sbracket = Origin.indexOf("(");
                    int Origin_Ebracket = Origin.indexOf(")");
                    int Dest_Sbracket = Destination.indexOf("(");
                    int Dest_Ebracket = Destination.indexOf(")");
                    Origin = Origin.substring(Origin_Sbracket + 1, Origin_Ebracket);
                    Destination = Destination.substring(Dest_Sbracket + 1, Dest_Ebracket);

                    isInternetConnected = cd.isConnectingToInternet();

                    if (!isInternetConnected) {
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
                    } else {
                        MakeRequestTask client = new MakeRequestTask();
                        client.execute();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        TRH_Button.addView(Search_Button, params1);
        tableLayout.addView(TRH_Button);

        setTitle("Summary Page");
        setContentView(tableLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_summary, menu);
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
            Search_Button.setClickable(true);
            Intent intent = new Intent(getApplicationContext(),DisplayFlightsActivity.class);
            Bundle extras = new Bundle();

            if("N".equals(respFlg))
            {
                Toast.makeText(DisplaySummaryActivity.this,
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
            Toast.makeText(DisplaySummaryActivity.this,
                    "Please wait..while we bring you the flight details", Toast.LENGTH_LONG).show();
            Search_Button.setClickable(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub

            try{
                /*KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                String algorithm = TrustManagerFactory.getDefaultAlgorithm();
                TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
                tmf.init(keyStore);

                SSLContext context = SSLContext.getInstance("TLS");
                context.init(null, tmf.getTrustManagers(), null);*/

                HttpURLConnection connection = null;
                //Amadeus wala https://api.myjson.com/bins/3fcxu
                URL url = new URL("http://api.myjson.com/bins/1evd4");
                connection = (HttpURLConnection)url.openConnection();
                //connection.setSSLSocketFactory(context.getSocketFactory());
              /*  connection.setDoOutput(true);
                //connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setUseCaches(false);
                connection.setConnectTimeout(7200000);
                connection.setReadTimeout(720000);
                //connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                //connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                */
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

                /*OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
                //output.write(String.valueOf(request_hdr.toString().getBytes("UTF-8")));
                output.write(request_hdr.toString());
                output.flush();
                output.close();*/

                int HttpResult = connection.getResponseCode();

                if(HttpResult == 400){
                    Toast.makeText(DisplaySummaryActivity.this,
                            "Something went wrong here!", Toast.LENGTH_LONG).show();
                }
                else if(HttpResult == 403){
                    Toast.makeText(DisplaySummaryActivity.this,
                            "Not authorized! Might have exceeded maximum number of requests per day!", Toast.LENGTH_LONG).show();
                }
                else if(HttpResult == 200) {
                    StringBuilder jsonresponse = new StringBuilder();
                    //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
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
