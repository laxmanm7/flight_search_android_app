package saumikbhattacharya.FlightSearch.com;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;


public class DisplayFlightsActivity extends AppCompatActivity implements Serializable{

    String str_jsonresponse="";
    String str_arrivaltime,str_departuretime,str_arrival_date,str_departure_date;
    String[] fare = new String[30];
    String[] carrier = new String[30];
    String[] number = new String[30];
    String[] arrivaltime = new String[30];
    String[] departuretime = new String[30];
    String[] origin = new String[30];
    String[] destination = new String[30];
    String[] arrival_date = new String[30];
    String[] departure_date = new String[30];
    String[] basefaretotal = new String[30];
    String[] salefaretotal = new String[30];
    String[] saletaxtotal = new String[30];

    ArrayList<ListRowItem> listitem = new ArrayList<>();
    Context context = DisplayFlightsActivity.this;
    public final static String CRRNT_ROW_NUMBER = "saumikbhattacharya.FlightSearch.com.CRRNT_ROW_NUMBER";
    public final static String LISTITEM = "saumikbhattacharya.FlightSearch.com.LISTITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ListView listView;
        MyBaseAdapter baseAdapter;
        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        str_jsonresponse = extras.getString(DisplaySummaryActivity.STR_JSONRESPONSE);

        try{
            JSONObject root_jsonresponse = new JSONObject(str_jsonresponse);
            JSONObject l1_jsonobject = root_jsonresponse.optJSONObject("trips");
            JSONArray l2_jsonarray = l1_jsonobject.optJSONArray("tripOption");
            for (int i=0;i < l2_jsonarray.length();i++)
            {
                JSONObject l21_jsonobject = l2_jsonarray.getJSONObject(i);
                fare[i] = l21_jsonobject.getString("saleTotal");
                JSONArray l3_jsonarray = l21_jsonobject.optJSONArray("slice");
                for (int j=0;j < l3_jsonarray.length();j++)
                {
                    JSONObject l4_jsonobject = l3_jsonarray.getJSONObject(j);
                    JSONArray l5_jsonarray = l4_jsonobject.optJSONArray("segment");
                    for(int k=0;k < l5_jsonarray.length();k++)
                    {
                        JSONObject l6_jsonobject = l5_jsonarray.getJSONObject(k);
                        JSONObject l7_jsonobject = l6_jsonobject.optJSONObject("flight");
                        carrier[i] = l7_jsonobject.getString("carrier");
                        number[i] = l7_jsonobject.getString("number");
                        JSONArray l8_jsonarray = l6_jsonobject.optJSONArray("leg");
                        for(int m=0;m < l8_jsonarray.length(); m++)
                        {
                            JSONObject l9_jsonobject = l8_jsonarray.getJSONObject(m);
                            str_arrivaltime = l9_jsonobject.getString("arrivalTime");
                            str_departuretime = l9_jsonobject.getString("departureTime");
                            origin[i] = l9_jsonobject.getString("origin");
                            destination[i] = l9_jsonobject.getString("destination");
                        }
                    }
                }
                JSONArray l31_jsonarray = l21_jsonobject.optJSONArray("pricing");
                for (int n=0;n < l31_jsonarray.length();n++)
                {
                    JSONObject l91_jsonobject = l31_jsonarray.getJSONObject(n);
                    basefaretotal[i] = l91_jsonobject.getString("baseFareTotal");
                    salefaretotal[i] = l91_jsonobject.getString("saleFareTotal");
                    saletaxtotal[i] = l91_jsonobject.getString("saleTaxTotal");
                }
                int arrivaltime_start = str_arrivaltime.indexOf("T");
                int arrivaltime_end = str_arrivaltime.indexOf("+");
                int departuretime_start = str_departuretime.indexOf("T");
                int departuretime_end = str_departuretime.indexOf("+");
                str_arrival_date = str_arrivaltime.substring(0,arrivaltime_start);
                str_departure_date = str_departuretime.substring(0,departuretime_start);
                str_arrivaltime = str_arrivaltime.substring(arrivaltime_start + 1, arrivaltime_end);
                str_departuretime = str_departuretime.substring(departuretime_start + 1, departuretime_end);
                arrivaltime[i] = str_arrivaltime;
                arrival_date[i] = str_arrival_date;
                departuretime[i] = str_departuretime;
                departure_date[i] = str_departure_date;

                ListRowItem lr = new ListRowItem();
                lr.setSaletotal(fare[i]);
                lr.setCarrier(carrier[i]);
                lr.setNumber(number[i]);
                lr.setArrival(arrivaltime[i]);
                lr.setDeparture(departuretime[i]);
                lr.setOrigin(origin[i]);
                lr.setDestination(destination[i]);
                lr.setArrivalDate(arrival_date[i]);
                lr.setDepartureDate(departure_date[i]);
                lr.setBaseFare(basefaretotal[i]);
                lr.setSaleFare(salefaretotal[i]);
                lr.setTotalTax(saletaxtotal[i]);

                listitem.add(lr);
            }
            baseAdapter = new MyBaseAdapter(context,listitem);

            setTitle("Results Page");
            setContentView(R.layout.activity_display_flights);
            listView = (ListView) findViewById(R.id.list_view);
            listView.setBackgroundResource(R.drawable.androidbckgrnd1);
            listView.setAdapter(baseAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    String item_position = String.valueOf(position);
                    ArrayList<ListRowItem> full_listitem = listitem;
                    Intent intent = new Intent(context,DetailRowItem.class);
                    Bundle extras = new Bundle();
                    extras.putString(CRRNT_ROW_NUMBER, item_position);
                    extras.putSerializable(LISTITEM, full_listitem);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            });
        }
        catch(JSONException JE){
            JE.printStackTrace();
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_flights, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ((id == R.id.home)|| (id == 16908332)){
            Intent tohome_actionbar = new Intent(this, MainActivity.class);
            tohome_actionbar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(tohome_actionbar);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        Intent tohome_actionbar = new Intent(this, MainActivity.class);
        tohome_actionbar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(tohome_actionbar);
        finish();
    }
}
