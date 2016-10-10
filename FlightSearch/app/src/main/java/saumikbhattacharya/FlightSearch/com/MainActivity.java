package saumikbhattacharya.FlightSearch.com;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements
            View.OnClickListener {

    Button goingDatePicker, returnDatePicker;
    EditText returnTextDate, goingTextDate;
    private int mYear, mMonth, mDay, mHour, mMinute;

    private AutoCompleteTextView originAutoComplete;
    private AutoCompleteTextView destAutoComplete;

    public final static String ORIGIN = "saumikbhattacharya.FlightSearch.com.ORIGIN";
    public final static String DESTINATION = "saumikbhattacharya.FlightSearch.com.DESTINATION";
    public final static String START_DATE = "saumikbhattacharya.FlightSearch.com.START_DATE";
    public final static String ADULT = "saumikbhattacharya.FlightSearch.com.ADULT";
    public final static String INFANT = "saumikbhattacharya.FlightSearch.com.INFANT";
    public final static String ORIGIN_MAP = "saumikbhattacharya.FlightSearch.com.ORIGIN_MAP";
    public final static String DESTINATION_MAP = "saumikbhattacharya.FlightSearch.com.DESTINATION_MAP";
    public static final String SQL_DLT_OLD_ENTRIES = "DELETE FROM "+AndroidOpenDbHelper.TABLE_NAME_FLIGHTSEARCH_DTL+" WHERE "+AndroidOpenDbHelper._ID+" NOT IN (SELECT "+AndroidOpenDbHelper._ID+" FROM "+AndroidOpenDbHelper.TABLE_NAME_FLIGHTSEARCH_DTL+" ORDER BY "+AndroidOpenDbHelper.COLUMN_NAME_CURRENT_DATE+" DESC LIMIT 30)";
    String Start_Date,S_Date,Origin_Map,Destination_Map,Origin,Destination,Num_Adult,Num_Infant,CurrentDate;
    Date start_date_object,current_date_object;
    DatePicker datePicker;
    Boolean isInternetConnected = false;
    ConnectionDetector cd;
    CheckBox showMap,saveSearch;
    Button Search_Button;
    TextView adlt,infnt;
    ArrayAdapter adapter_src,adapter_dest;
    Spinner spinner_src,spinner_dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
        {
            onRestoreInstanceState(savedInstanceState);
        }
        setTitle("Home Page");
        setContentView(R.layout.activity_main);

        //================

        String[] cities = getResources().getStringArray(R.array.testArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities);

        originAutoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        originAutoComplete.setAdapter(adapter);

        destAutoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        destAutoComplete.setAdapter(adapter);

        goingDatePicker=(Button)findViewById(R.id.btn_date);
        goingTextDate=(EditText)findViewById(R.id.txt_in_date);

        goingDatePicker.setOnClickListener(this);

        returnDatePicker=(Button)findViewById(R.id.btn_return_date);
        returnTextDate=(EditText)findViewById(R.id.txt_return_date);

        returnDatePicker.setOnClickListener(this);

        //=============================

        //datePicker = (DatePicker) findViewById(R.id.datepicker);

       /* spinner_src = (Spinner) findViewById(R.id.pick_src);
        adapter_src = ArrayAdapter.createFromResource(this,R.array.edit_src,android.R.layout.simple_spinner_item);
        adapter_src.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_src.setAdapter(adapter_src);

        spinner_dest = (Spinner) findViewById(R.id.pick_dest);
        adapter_dest = ArrayAdapter.createFromResource(this,R.array.edit_dest,android.R.layout.simple_spinner_item);
        adapter_dest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_dest.setAdapter(adapter_dest);*/

        cd = new ConnectionDetector(getApplicationContext());

        Search_Button = (Button)findViewById(R.id.search_button);
    }

    @Override
    public void onClick(View v) {

        if (v == goingDatePicker ) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            goingTextDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if( v == returnDatePicker){
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            returnTextDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ((id == R.id.about)||(id == 2131427494))
        {
            Intent gotoabout = new Intent(this,About_Activity.class);
            startActivity(gotoabout);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClicked(View view){
        Intent intent = new Intent(this,DisplaySummaryActivity.class);
        Bundle extras = new Bundle();

        Intent intent1 = new Intent(this,Map_Activity_With_Fragment.class);
        Bundle extras1 = new Bundle();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date flightDate = null;
        try {
             flightDate = fmt.parse(goingTextDate.toString());
        }
        catch(ParseException pe) {

        }
        int day = flightDate.getDay();
        int month = flightDate.getMonth() + 1;
        int year = flightDate.getYear();

        /*int day = flightDate.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
*/
        S_Date = year+"-"+month+"-"+day;

        /*Spinner Org = (Spinner)findViewById(R.id.pick_src);
        Origin = Org.getSelectedItem().toString();*/

      /*  Spinner Dest = (Spinner)findViewById(R.id.pick_dest);
        Destination = Dest.getSelectedItem().toString();*/

        AutoCompleteTextView Org = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        Origin = Org.getText().toString();

        AutoCompleteTextView Dest = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        Destination = Dest.getText().toString();

        try{
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            start_date_object = formatter.parse(S_Date);
            Start_Date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(start_date_object);

            CurrentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
            current_date_object = formatter.parse(CurrentDate);
        }
        catch(java.text.ParseException e) {
            e.printStackTrace();
        }

        adlt = (TextView) findViewById(R.id.enter_adult1);
        Num_Adult = adlt.getText().toString();

        infnt = (TextView) findViewById(R.id.enter_infant1);
        Num_Infant = infnt.getText().toString();

        showMap = (CheckBox)findViewById(R.id.show_map_ans);
        saveSearch = (CheckBox)findViewById(R.id.save_search_ans);

        if(("Select".equals(Origin)) || ("Select".equals(Destination)) || ("".equals(Num_Adult)) || ("0".equals(Num_Adult))){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Required fields are missing!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(((!"Select".equals(Origin)) || (!"Select".equals(Destination))) && (Origin.equals(Destination))){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Origin and Destination are same!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(start_date_object.compareTo(current_date_object)<0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
        else if(showMap.isChecked())
        {
            isInternetConnected = cd.isConnectingToInternet();

            if(!isInternetConnected)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
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

                if (saveSearch.isChecked())
                {
                    insertIntoDB();
                }
                int Origin_Sbracket = Origin.indexOf("(");
                int Dest_Sbracket = Destination.indexOf("(");
                Origin_Map = Origin.substring(0, Origin_Sbracket-1);
                Destination_Map = Destination.substring(0, Dest_Sbracket-1);

                extras1.putString(ORIGIN, Origin);
                extras1.putString(DESTINATION, Destination);
                extras1.putString(START_DATE,Start_Date);
                extras1.putString(ADULT, Num_Adult);
                extras1.putString(INFANT, Num_Infant);
                extras1.putString(ORIGIN_MAP, Origin_Map);
                extras1.putString(DESTINATION_MAP, Destination_Map);

                intent1.putExtras(extras1);
                startActivity(intent1);
            }
        }
        else{

            if(saveSearch.isChecked())
            {
                insertIntoDB();
            }
            extras.putString(ORIGIN, Origin);
            extras.putString(DESTINATION, Destination);
            extras.putString(START_DATE,Start_Date);
            extras.putString(ADULT, Num_Adult);
            extras.putString(INFANT, Num_Infant);

            isInternetConnected = cd.isConnectingToInternet();

            if(!isInternetConnected)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
                intent.putExtras(extras);
                startActivity(intent);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Origin", Origin);
        savedInstanceState.putString("Destination", Destination);
        savedInstanceState.putString("Start Date", Start_Date);
        savedInstanceState.putString("Adult", Num_Adult);
        savedInstanceState.putString("Infant", Num_Infant);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Origin = savedInstanceState.getString("Origin");
        Destination = savedInstanceState.getString("Destination");
        Start_Date = savedInstanceState.getString("Start Date");
        adlt.setText(savedInstanceState.getString("Adult"));
        infnt.setText(savedInstanceState.getString("Infant"));
    }

    public void insertIntoDB()
    {
        try
        {
            AndroidOpenDbHelper openDbHelperObj = new AndroidOpenDbHelper(this);
            SQLiteDatabase sqLiteDatabase = openDbHelperObj.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_ORIGIN,Origin);
            contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_DESTINATION,Destination);
            contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_START_DATE,Start_Date);
            contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_NUM_ADLT,Num_Adult);
            contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_NUM_INFANT,Num_Infant);
            contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_CURRENT_DATE,CurrentDate);

            sqLiteDatabase.execSQL(SQL_DLT_OLD_ENTRIES);
            long affectedRowId = sqLiteDatabase.insert(AndroidOpenDbHelper.TABLE_NAME_FLIGHTSEARCH_DTL,null,contentValues);

            sqLiteDatabase.close();

            Toast.makeText(this, "Your search is saved! Id is: "+affectedRowId, Toast.LENGTH_SHORT).show();

        }catch(Exception err)
        {
            err.printStackTrace();
        }
    }

    public void onShowSavedSearchButtonClicked(View view)
    {
        Intent intent = new Intent(this,DisplaySavedSearchActivity.class);
        startActivity(intent);
    }
}
