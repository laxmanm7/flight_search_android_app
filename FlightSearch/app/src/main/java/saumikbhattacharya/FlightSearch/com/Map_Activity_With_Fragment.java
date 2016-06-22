package saumikbhattacharya.FlightSearch.com;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class Map_Activity_With_Fragment extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    String Origin, Destination, Start_Date, Num_Adult, Num_Infant, Origin_Map, Destination_Map, str_jsonresponse;
    Context context;
    List<Address> Addr_Origin, Addr_Dest;
    double latitude_origin, longitude_origin, latitude_destination, longitude_destination;
    Boolean isInternetConnected = false;
    JSONArray l2_jsonarray = null;
    String respFlg = null;
    public final static String STR_JSONRESPONSE = "saumikbhattacharya.FlightSearch.com.STR_JSONRESPONSE";
    ConnectionDetector cd;
    Button Search_Button;

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
        context = Map_Activity_With_Fragment.this;
        cd = new ConnectionDetector(getApplicationContext());
        setTitle("Location Map");
        setContentView(R.layout.activity_map__with__fragment);

        try
        {
            initializeMap();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_map__with__fragment, menu);
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

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        AddMarkers(googleMap);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initializeMap();
        AddMarkers(googleMap);
    }

    private void initializeMap()
    {
        if (googleMap == null) {
            MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
    }

    private void AddMarkers(GoogleMap googleMap)
    {
        try {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            Geocoder geocoder = new Geocoder(context);
            Origin_Map = extras.getString(MainActivity.ORIGIN_MAP);
            Destination_Map = extras.getString(MainActivity.DESTINATION_MAP);
            Addr_Origin = geocoder.getFromLocationName(Origin_Map, 1);
            Addr_Dest = geocoder.getFromLocationName(Destination_Map, 1);
            if (Addr_Origin.size() > 0) {
                latitude_origin = Addr_Origin.get(0).getLatitude();
                longitude_origin = Addr_Origin.get(0).getLongitude();
            }
            if (Addr_Dest.size() > 0) {
                latitude_destination = Addr_Dest.get(0).getLatitude();
                longitude_destination = Addr_Dest.get(0).getLongitude();
            }
            Marker m1 = googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude_origin, longitude_origin)).title(Origin_Map).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            Marker m2 = googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude_destination, longitude_destination)).title(Destination_Map).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            PolylineOptions flightpath = new PolylineOptions().add(new LatLng(latitude_origin, longitude_origin)).add(new LatLng(latitude_destination, longitude_destination));
            Polyline flightpath_polyline = googleMap.addPolyline(flightpath.width(5).color(Color.BLUE).geodesic(true));

            CameraUpdate center= CameraUpdateFactory.newLatLng(new LatLng(latitude_origin, longitude_origin));
            CameraUpdate zoom = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude_origin, longitude_origin),3);
            googleMap.animateCamera(center);
            googleMap.animateCamera(zoom);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onButtonClicked(View view)
    {
        isInternetConnected = cd.isConnectingToInternet();
        Search_Button = (Button)findViewById(R.id.button_search);

        int Origin_Sbracket = Origin.indexOf("(");
        int Origin_Ebracket = Origin.indexOf(")");
        int Dest_Sbracket = Destination.indexOf("(");
        int Dest_Ebracket = Destination.indexOf(")");
        Origin = Origin.substring(Origin_Sbracket + 1, Origin_Ebracket);
        Destination = Destination.substring(Dest_Sbracket + 1, Dest_Ebracket);

        if(!isInternetConnected)
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

    public class MakeRequestTask extends AsyncTask<Void, Integer, Void>
    {
            @Override
            protected void onPostExecute (Void result){
            // TODO Auto-generated method stub
            Search_Button.setClickable(true);
            Intent intent = new Intent(context, DisplayFlightsActivity.class);
            Bundle extras = new Bundle();

            if ("N".equals(respFlg)) {
                Toast.makeText(Map_Activity_With_Fragment.this,
                        "No Direct Flights found at this time! Please modify your search!", Toast.LENGTH_LONG).show();
            } else {
                extras.putString(STR_JSONRESPONSE, str_jsonresponse);
                intent.putExtras(extras);
                startActivity(intent);
            }
        }

            @Override
            protected void onPreExecute () {
            // TODO Auto-generated method stub
            Toast.makeText(Map_Activity_With_Fragment.this,
                    "Please wait..while we bring you the flight details", Toast.LENGTH_LONG).show();
            Search_Button.setClickable(false);
        }

            @Override
            protected Void doInBackground (Void...params){
            // TODO Auto-generated method stub

            try {
                HttpsURLConnection connection = null;

                URL url = new URL("https://www.googleapis.com/qpxExpress/v1/trips/search?key=AIzaSyDbg1n8mdY3xAWYBy05ixrPtvRdc4R3Mys");
                connection = (HttpsURLConnection) url.openConnection();
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

                if (HttpResult == 400) {
                    Toast.makeText(Map_Activity_With_Fragment.this,
                            "Something went wrong here!", Toast.LENGTH_LONG).show();
                } else if (HttpResult == 403) {
                    Toast.makeText(Map_Activity_With_Fragment.this,
                            "Not authorized! Might have exceeded maximum number of requests per day!", Toast.LENGTH_LONG).show();
                } else if (HttpResult == 200) {
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

                    if (l2_jsonarray == null) {
                        respFlg = "N";
                    }

                    bufferedReader.close();
                }

                connection.disconnect();
            } catch (JSONException JE) {
                JE.printStackTrace();
            } catch (Exception err) {
                err.printStackTrace();
            }
            return null;
        }
    }
}