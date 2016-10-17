package saumikbhattacharya.FlightSearch.com;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import saumikbhattacharya.FlightSearch.com.FlightPackage.RecommendationPlusMaps;


public class DisplayFlightsActivity extends AppCompatActivity implements Serializable {

    String str_jsonresponse = "";
    String str_arrivaltime, str_departuretime, str_arrival_date, str_departure_date;
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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ListView listView;
        MyBaseAdapter baseAdapter;
        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        str_jsonresponse = extras.getString(DisplaySummaryActivity.STR_JSONRESPONSE);

        str_jsonresponse = "{\n" +
                "\t\"recommendationList\": [{\n" +
                "\t\t\"seq\": 1,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"RA\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"R\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"RA\",\n" +
                "\t\t\t\t\t\"fltno\": \"205\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"0800\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0940\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 0,\n" +
                "\t\t\t\t\"duration\": \"0155\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 9045,\n" +
                "\t\t\t\t\"cp\": 9045,\n" +
                "\t\t\t\t\"cpa\": 9045.00,\n" +
                "\t\t\t\t\"spu\": 9317.00,\n" +
                "\t\t\t\t\"tx\": 6046,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 2,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"S\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"214\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1030\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1145\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 0,\n" +
                "\t\t\t\t\"duration\": \"0130\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 10227,\n" +
                "\t\t\t\t\"cp\": 10003,\n" +
                "\t\t\t\t\"cpa\": 10003.00,\n" +
                "\t\t\t\t\"spu\": 10304.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 3,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"S\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"216\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1745\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 0,\n" +
                "\t\t\t\t\"duration\": \"0155\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 10227,\n" +
                "\t\t\t\t\"cp\": 10003,\n" +
                "\t\t\t\t\"cpa\": 10003.00,\n" +
                "\t\t\t\t\"spu\": 10304.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 4,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"9W\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"K\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"9W\",\n" +
                "\t\t\t\t\t\"fltno\": \"263\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"0950\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1120\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 0,\n" +
                "\t\t\t\t\"duration\": \"0145\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 15528,\n" +
                "\t\t\t\t\"cp\": 14880,\n" +
                "\t\t\t\t\"cpa\": 14880.00,\n" +
                "\t\t\t\t\"spu\": 15327.00,\n" +
                "\t\t\t\t\"tx\": 6262,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 5,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"9W\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"K\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"9W\",\n" +
                "\t\t\t\t\t\"fltno\": \"259\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1645\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1815\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 0,\n" +
                "\t\t\t\t\"duration\": \"0145\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 15528,\n" +
                "\t\t\t\t\"cp\": 14880,\n" +
                "\t\t\t\t\"cpa\": 14880.00,\n" +
                "\t\t\t\t\"spu\": 15327.00,\n" +
                "\t\t\t\t\"tx\": 6262,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 6,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"S\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"5\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"711\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1145\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"AJL\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1300\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"711\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"AJL\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1340\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"IMF\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1430\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"890\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"IMF\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1515\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"GAU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1610\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"890\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"GAU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1655\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1950\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2800\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 21507,\n" +
                "\t\t\t\t\"cp\": 20493,\n" +
                "\t\t\t\t\"cpa\": 20493.00,\n" +
                "\t\t\t\t\"spu\": 21108.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 7,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"23\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2015\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2230\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"0640\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 22906,\n" +
                "\t\t\t\t\"cp\": 21794,\n" +
                "\t\t\t\t\"cpa\": 21794.00,\n" +
                "\t\t\t\t\"spu\": 22448.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 8,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"763\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0645\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0910\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1720\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 22906,\n" +
                "\t\t\t\t\"cp\": 21794,\n" +
                "\t\t\t\t\"cpa\": 21794.00,\n" +
                "\t\t\t\t\"spu\": 22448.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 9,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"21\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1000\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1205\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"2015\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 22906,\n" +
                "\t\t\t\t\"cp\": 21794,\n" +
                "\t\t\t\t\"cpa\": 21794.00,\n" +
                "\t\t\t\t\"spu\": 22448.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 10,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"729\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0950\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"GAU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1100\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"890\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"GAU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1655\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1950\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2800\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26106,\n" +
                "\t\t\t\t\"cp\": 24770,\n" +
                "\t\t\t\t\"cpa\": 24770.00,\n" +
                "\t\t\t\t\"spu\": 25514.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 11,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"9739\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0550\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"GAU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"0725\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"890\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"GAU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1655\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1950\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2800\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26106,\n" +
                "\t\t\t\t\"cp\": 24770,\n" +
                "\t\t\t\t\"cpa\": 24770.00,\n" +
                "\t\t\t\t\"spu\": 25514.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 12,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"676\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0945\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1235\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"687\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1600\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1815\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2625\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 13,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"676\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0945\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1235\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"660\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1700\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"1915\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2725\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 14,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"676\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0945\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1235\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"658\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1800\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2020\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2830\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 15,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"676\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0945\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1235\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"888\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1900\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2115\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"2925\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 16,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"676\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0945\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1235\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"314\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"2000\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2155\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"3005\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 17,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"676\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0945\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1235\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"605\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"2100\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2310\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"3120\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 18,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"AI\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"248\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1605\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1710\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"773\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"CCU\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1700\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"1940\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"U\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"605\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"BOM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"2100\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2310\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 2,\n" +
                "\t\t\t\t\"duration\": \"3120\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 26426,\n" +
                "\t\t\t\t\"cp\": 25068,\n" +
                "\t\t\t\t\"cpa\": 25068.00,\n" +
                "\t\t\t\t\"spu\": 25821.00,\n" +
                "\t\t\t\t\"tx\": 7017,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 19,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"QR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"N\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"651\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"2130\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2330\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"570\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"0225\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0835\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1120\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 78161,\n" +
                "\t\t\t\t\"cp\": 78161,\n" +
                "\t\t\t\t\"cpa\": 78161.00,\n" +
                "\t\t\t\t\"spu\": 80506.00,\n" +
                "\t\t\t\t\"tx\": 17982,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 20,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"QR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"N\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"653\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1040\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1240\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"570\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"0225\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0835\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"2210\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 78551,\n" +
                "\t\t\t\t\"cp\": 78551,\n" +
                "\t\t\t\t\"cpa\": 78551.00,\n" +
                "\t\t\t\t\"spu\": 80908.00,\n" +
                "\t\t\t\t\"tx\": 18372,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 21,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"QR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"N\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"651\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"2130\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2330\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"578\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2055\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"020716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0300\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"2945\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 78551,\n" +
                "\t\t\t\t\"cp\": 78551,\n" +
                "\t\t\t\t\"cpa\": 78551.00,\n" +
                "\t\t\t\t\"spu\": 80908.00,\n" +
                "\t\t\t\t\"tx\": 18372,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 22,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"QR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"647\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1735\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1935\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"578\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2055\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0300\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"0940\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 83128,\n" +
                "\t\t\t\t\"cp\": 83128,\n" +
                "\t\t\t\t\"cpa\": 83128.00,\n" +
                "\t\t\t\t\"spu\": 85622.00,\n" +
                "\t\t\t\t\"tx\": 17982,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 23,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"QR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"647\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1735\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1935\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"570\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"0225\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0835\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1515\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 83128,\n" +
                "\t\t\t\t\"cp\": 83128,\n" +
                "\t\t\t\t\"cpa\": 83128.00,\n" +
                "\t\t\t\t\"spu\": 85622.00,\n" +
                "\t\t\t\t\"tx\": 17982,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 24,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"QR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"V\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"653\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1040\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1240\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"QR\",\n" +
                "\t\t\t\t\t\"fltno\": \"578\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DOH\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2055\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0300\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1635\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 83128,\n" +
                "\t\t\t\t\"cp\": 83128,\n" +
                "\t\t\t\t\"cpa\": 83128.00,\n" +
                "\t\t\t\t\"spu\": 85622.00,\n" +
                "\t\t\t\t\"tx\": 17982,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 25,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"MH\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"MH\",\n" +
                "\t\t\t\t\t\"fltno\": \"115\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"2330\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"KUL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"M\",\n" +
                "\t\t\t\t\t\t\"time\": \"0625\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"MH\",\n" +
                "\t\t\t\t\t\"fltno\": \"190\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"KUL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"M\",\n" +
                "\t\t\t\t\t\t\"time\": \"1825\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2125\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"2210\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 107330,\n" +
                "\t\t\t\t\"cp\": 107330,\n" +
                "\t\t\t\t\"cpa\": 107330.00,\n" +
                "\t\t\t\t\"spu\": 110550.00,\n" +
                "\t\t\t\t\"tx\": 29580,\n" +
                "\t\t\t\t\"rf\": false\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 26,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"EY\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"EY\",\n" +
                "\t\t\t\t\t\"fltno\": \"293\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2130\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"AUH\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"0045\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"EY\",\n" +
                "\t\t\t\t\t\"fltno\": \"228\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"AUH\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"0255\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0810\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"7\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1055\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 142205,\n" +
                "\t\t\t\t\"cp\": 142205,\n" +
                "\t\t\t\t\"cpa\": 142205.00,\n" +
                "\t\t\t\t\"spu\": 146472.00,\n" +
                "\t\t\t\t\"tx\": 3374,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 27,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"EY\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"L\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"EY\",\n" +
                "\t\t\t\t\t\"fltno\": \"291\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1855\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"AUH\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"2210\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"EY\",\n" +
                "\t\t\t\t\t\"fltno\": \"228\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"AUH\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"0255\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0810\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"7\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1330\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 142205,\n" +
                "\t\t\t\t\"cp\": 142205,\n" +
                "\t\t\t\t\"cpa\": 142205.00,\n" +
                "\t\t\t\t\"spu\": 146472.00,\n" +
                "\t\t\t\t\"tx\": 3374,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 28,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"TG\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"TG\",\n" +
                "\t\t\t\t\t\"fltno\": \"320\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1330\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"BKK\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"1815\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"TG\",\n" +
                "\t\t\t\t\t\"fltno\": \"331\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"BKK\",\n" +
                "\t\t\t\t\t\t\"terminal\": null,\n" +
                "\t\t\t\t\t\t\"time\": \"2315\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0215\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1300\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 165970,\n" +
                "\t\t\t\t\"cp\": 155521,\n" +
                "\t\t\t\t\"cpa\": 155521.00,\n" +
                "\t\t\t\t\"spu\": 160187.00,\n" +
                "\t\t\t\t\"tx\": 16688,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 7.00,\n" +
                "\t\t\t\"apc\": 7.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 29,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"RA\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"M\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"RA\",\n" +
                "\t\t\t\t\t\"fltno\": \"409\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"1135\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"HKG\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"1805\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"CX\",\n" +
                "\t\t\t\t\t\"fltno\": \"697\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"HKG\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"2010\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"2350\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"1230\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 241673,\n" +
                "\t\t\t\t\"cp\": 241673,\n" +
                "\t\t\t\t\"cpa\": 241673.00,\n" +
                "\t\t\t\t\"spu\": 248924.00,\n" +
                "\t\t\t\t\"tx\": 7679,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"seq\": 30,\n" +
                "\t\t\"provider\": \"AMADEUS\",\n" +
                "\t\t\"itinerary\": {\n" +
                "\t\t\t\"carrier\": \"HR\",\n" +
                "\t\t\t\"refundable\": false,\n" +
                "\t\t\t\"dept\": {\n" +
                "\t\t\t\t\"flightList\": [{\n" +
                "\t\t\t\t\t\"cls\": \"I\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"FZ\",\n" +
                "\t\t\t\t\t\"fltno\": \"574\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"300616\",\n" +
                "\t\t\t\t\t\t\"code\": \"KTM\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"I\",\n" +
                "\t\t\t\t\t\t\"time\": \"2300\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"010716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DXB\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"2\",\n" +
                "\t\t\t\t\t\t\"time\": \"0200\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"4\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"cls\": \"Y\",\n" +
                "\t\t\t\t\t\"eqp\": null,\n" +
                "\t\t\t\t\t\"flag\": \"AI\",\n" +
                "\t\t\t\t\t\"fltno\": \"996\",\n" +
                "\t\t\t\t\t\"from\": {\n" +
                "\t\t\t\t\t\t\"date\": \"020716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DXB\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"1\",\n" +
                "\t\t\t\t\t\t\"time\": \"0005\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"to\": {\n" +
                "\t\t\t\t\t\t\"date\": \"020716\",\n" +
                "\t\t\t\t\t\t\"code\": \"DEL\",\n" +
                "\t\t\t\t\t\t\"terminal\": \"3\",\n" +
                "\t\t\t\t\t\t\"time\": \"0445\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"seatAvl\": \"9\"\n" +
                "\t\t\t\t}],\n" +
                "\t\t\t\t\"stops\": 1,\n" +
                "\t\t\t\t\"duration\": \"3000\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ret\": null\n" +
                "\t\t},\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"adultFare\": {\n" +
                "\t\t\t\t\"apif\": 262344,\n" +
                "\t\t\t\t\"cp\": 262344,\n" +
                "\t\t\t\t\"cpa\": 262344.00,\n" +
                "\t\t\t\t\"spu\": 270215.00,\n" +
                "\t\t\t\t\"tx\": 14480,\n" +
                "\t\t\t\t\"rf\": true\n" +
                "\t\t\t},\n" +
                "\t\t\t\"childFare\": null,\n" +
                "\t\t\t\"infantFare\": null\n" +
                "\t\t},\n" +
                "\t\t\"extras\": {\n" +
                "\t\t\t\"acc\": 0.00,\n" +
                "\t\t\t\"apc\": 0.00,\n" +
                "\t\t\t\"b2bm\": 0.00,\n" +
                "\t\t\t\"b2cm\": 3.00\n" +
                "\t\t}\n" +
                "\t}],\n" +
                "\t\"airlineCodeToName\": {\n" +
                "\t\t\"QR\": \"Qatar Airways\",\n" +
                "\t\t\"TG\": \"Thai Airways International\",\n" +
                "\t\t\"EY\": \"Etihad Airways\",\n" +
                "\t\t\"FZ\": \"Fly Dubai\",\n" +
                "\t\t\"CX\": \"Cathay Pacific\",\n" +
                "\t\t\"AI\": \"Air India Limited\",\n" +
                "\t\t\"MH\": \"Malaysia Airlines\",\n" +
                "\t\t\"9W\": \"Jet Airways\",\n" +
                "\t\t\"RA\": \"Nepal Airlines\"\n" +
                "\t},\n" +
                "\t\"cityCodeToName\": {\n" +
                "\t\t\"BOM\": \"Mumbai, India - (BOM)\",\n" +
                "\t\t\"AJL\": \"Aizawl, India - (AJL)\",\n" +
                "\t\t\"IMF\": \"Imphal, India - (IMF)\",\n" +
                "\t\t\"KUL\": \"Kuala Lumpur, Malaysia - (KUL)\",\n" +
                "\t\t\"BKK\": \"Bangkok, Thailand - (BKK)\",\n" +
                "\t\t\"KTM\": \"Kathmandu, Nepal - (KTM)\",\n" +
                "\t\t\"HKG\": \"Hong Kong, Hong Kong - (HKG)\",\n" +
                "\t\t\"DEL\": \"Delhi, India - (DEL)\",\n" +
                "\t\t\"DXB\": \"Dubai, UAE - (DXB)\",\n" +
                "\t\t\"CCU\": \"Kolkata, India - (CCU)\",\n" +
                "\t\t\"AUH\": \"Abu Dhabi, UAE - (AUH)\",\n" +
                "\t\t\"GAU\": \"Gawahati, India - (GAU)\",\n" +
                "\t\t\"DOH\": \"Doha, Qatar - (DOH)\"\n" +
                "\t},\n" +
                "\t\"filterMaps\": {\n" +
                "\t\t\"fare\": {\n" +
                "\t\t\t\"min\": \"9317.00\",\n" +
                "\t\t\t\"max\": \"270215.00\"\n" +
                "\t\t},\n" +
                "\t\t\"outDeptTime\": {\n" +
                "\t\t\t\"min\": \"1467252900000\",\n" +
                "\t\t\t\"max\": \"1467308700000\"\n" +
                "\t\t},\n" +
                "\t\t\"inDeptTime\": {},\n" +
                "\t\t\"outArrTime\": {\n" +
                "\t\t\t\"min\": \"1467258900000\",\n" +
                "\t\t\t\"max\": \"1467414000000\"\n" +
                "\t\t},\n" +
                "\t\t\"inArrTime\": {},\n" +
                "\t\t\"outDuration\": {\n" +
                "\t\t\t\"min\": \"0130\",\n" +
                "\t\t\t\"max\": \"3120\"\n" +
                "\t\t},\n" +
                "\t\t\"inDuration\": {},\n" +
                "\t\t\"cheapest\": {\n" +
                "\t\t\t\"RA\": 9317.00,\n" +
                "\t\t\t\"AI\": 10304.00,\n" +
                "\t\t\t\"9W\": 15327.00,\n" +
                "\t\t\t\"QR\": 80506.00,\n" +
                "\t\t\t\"MH\": 110550.00,\n" +
                "\t\t\t\"EY\": 146472.00,\n" +
                "\t\t\t\"TG\": 160187.00,\n" +
                "\t\t\t\"HR\": 270215.00\n" +
                "\t\t},\n" +
                "\t\t\"fastest\": {\n" +
                "\t\t\t\"AI\": \"0130\",\n" +
                "\t\t\t\"9W\": \"0145\",\n" +
                "\t\t\t\"RA\": \"0155\",\n" +
                "\t\t\t\"QR\": \"0940\",\n" +
                "\t\t\t\"EY\": \"1055\",\n" +
                "\t\t\t\"TG\": \"1300\",\n" +
                "\t\t\t\"MH\": \"2210\",\n" +
                "\t\t\t\"HR\": \"3000\"\n" +
                "\t\t},\n" +
                "\t\t\"inTransits\": null,\n" +
                "\t\t\"outTransits\": [\"KTM\", \"CCU\", \"AJL\", \"IMF\", \"GAU\", \"DEL\", \"BOM\", \"DOH\", \"KUL\", \"AUH\", \"BKK\", \"HKG\", \"DXB\"]\n" +
                "\t},\n" +
                "\t\"makebooking\": true,\n" +
                "\t\"holdbooking\": true\n" +
                "}";

        str_jsonresponse = extras.getString(DisplaySummaryActivity.STR_JSONRESPONSE);

        try {

            ObjectMapper ob = new ObjectMapper();
            RecommendationPlusMaps selectedRecommendation =
                    ob.readValue(str_jsonresponse, RecommendationPlusMaps.class);
            //=================================================================
            JSONObject root_jsonresponse = new JSONObject(str_jsonresponse);
            JSONObject l1_jsonobject = root_jsonresponse.optJSONObject("trips");
            JSONArray l2_jsonarray = l1_jsonobject.optJSONArray("tripOption");
            for (int i = 0; i < l2_jsonarray.length(); i++) {
                JSONObject l21_jsonobject = l2_jsonarray.getJSONObject(i);
                fare[i] = l21_jsonobject.getString("saleTotal");
                JSONArray l3_jsonarray = l21_jsonobject.optJSONArray("slice");
                for (int j = 0; j < l3_jsonarray.length(); j++) {
                    JSONObject l4_jsonobject = l3_jsonarray.getJSONObject(j);
                    JSONArray l5_jsonarray = l4_jsonobject.optJSONArray("segment");
                    for (int k = 0; k < l5_jsonarray.length(); k++) {
                        JSONObject l6_jsonobject = l5_jsonarray.getJSONObject(k);
                        JSONObject l7_jsonobject = l6_jsonobject.optJSONObject("flight");
                        carrier[i] = l7_jsonobject.getString("carrier");
                        number[i] = l7_jsonobject.getString("number");
                        JSONArray l8_jsonarray = l6_jsonobject.optJSONArray("leg");
                        for (int m = 0; m < l8_jsonarray.length(); m++) {
                            JSONObject l9_jsonobject = l8_jsonarray.getJSONObject(m);
                            str_arrivaltime = l9_jsonobject.getString("arrivalTime");
                            str_departuretime = l9_jsonobject.getString("departureTime");
                            origin[i] = l9_jsonobject.getString("origin");
                            destination[i] = l9_jsonobject.getString("destination");
                        }
                    }
                }
                JSONArray l31_jsonarray = l21_jsonobject.optJSONArray("pricing");
                for (int n = 0; n < l31_jsonarray.length(); n++) {
                    JSONObject l91_jsonobject = l31_jsonarray.getJSONObject(n);
                    basefaretotal[i] = l91_jsonobject.getString("baseFareTotal");
                    salefaretotal[i] = l91_jsonobject.getString("saleFareTotal");
                    saletaxtotal[i] = l91_jsonobject.getString("saleTaxTotal");
                }
                int arrivaltime_start = str_arrivaltime.indexOf("T");
                int arrivaltime_end = str_arrivaltime.indexOf("+");
                int departuretime_start = str_departuretime.indexOf("T");
                int departuretime_end = str_departuretime.indexOf("+");
                str_arrival_date = str_arrivaltime.substring(0, arrivaltime_start);
                str_departure_date = str_departuretime.substring(0, departuretime_start);
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
            //baseAdapter = new MyBaseAdapter(context, listitem); //paila ko
            baseAdapter = new MyBaseAdapter(context, listitem);

            setTitle("Results Page");
            setContentView(R.layout.activity_display_flights);
            listView = (ListView) findViewById(R.id.list_view);
            //listView.setBackgroundResource(R.drawable.androidbckgrnd1);
            listView.setAdapter(baseAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String item_position = String.valueOf(position);
                    ArrayList<ListRowItem> full_listitem = listitem;
                    Intent intent = new Intent(context, DetailRowItem.class);
                    Bundle extras = new Bundle();
                    extras.putString(CRRNT_ROW_NUMBER, item_position);
                    extras.putSerializable(LISTITEM, full_listitem);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            });
        } catch (JSONException JE) {
            JE.printStackTrace();
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            //donothing for now

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        if ((id == R.id.home) || (id == 16908332)) {
            Intent tohome_actionbar = new Intent(this, MainActivity.class);
            tohome_actionbar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(tohome_actionbar);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        Intent tohome_actionbar = new Intent(this, MainActivity.class);
        tohome_actionbar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(tohome_actionbar);
        finish();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("DisplayFlights Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
