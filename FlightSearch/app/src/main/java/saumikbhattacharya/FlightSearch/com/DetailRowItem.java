package saumikbhattacharya.FlightSearch.com;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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

import java.io.Serializable;
import java.util.ArrayList;


public class DetailRowItem extends AppCompatActivity implements Serializable{

    String item_position;
    ArrayList<ListRowItem> listitem = new ArrayList<>();
    ListRowItem currentlistitem;
    int position;
    Button OK_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        item_position = extras.getString(DisplayFlightsActivity.CRRNT_ROW_NUMBER);
        listitem = (ArrayList<ListRowItem>)extras.getSerializable(DisplayFlightsActivity.LISTITEM);

        position = Integer.parseInt(item_position);
        currentlistitem = listitem.get(position);

        String str_carrier = currentlistitem.getCarrier();
        String str_number = currentlistitem.getNumber();
        String str_arrivaltime = currentlistitem.getArrival();
        String str_departuretime = currentlistitem.getDeparture();
        String str_saletotal = currentlistitem.getSaletotal();
        String origin = currentlistitem.getOrigin();
        String destination = currentlistitem.getDestination();
        String str_arrival_date = currentlistitem.getArrivalDate();
        String str_dep_date = currentlistitem.getDepartureDate();
        String str_base_fare = currentlistitem.getBaseFare();
        String str_total_fare = currentlistitem.getSaleFare();
        String str_total_tax = currentlistitem.getTotalTax();

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setStretchAllColumns(true);
        tableLayout.setGravity(Gravity.CENTER_VERTICAL);
        tableLayout.setBackgroundResource(R.drawable.androidbckgrnd1);

        TableRow TRH_Title = new TableRow(this);
        TRH_Title.setPadding(0, 0, 0, 40);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 2;

        TextView Title = new TextView(this);
        Title.setText("Detail Flight Information");
        Title.setTextSize(25);
        Title.setTypeface(Typeface.DEFAULT_BOLD);
        Title.setGravity(Gravity.CENTER_HORIZONTAL);

        TRH_Title.addView(Title, params);

        tableLayout.addView(TRH_Title);

        TableRow TRH_Flight = new TableRow(this);
        TRH_Flight.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Flight = new TextView(this);
        Label_Flight.setText("Flight :");
        Label_Flight.setTextSize(20);
        Label_Flight.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Flight.setGravity(Gravity.END);

        TextView Val_Flight = new TextView(this);
        Val_Flight.setText(str_carrier+" "+str_number);
        Val_Flight.setTextSize(20);
        Val_Flight.setGravity(Gravity.START);

        TRH_Flight.addView(Label_Flight);
        TRH_Flight.addView(Val_Flight);

        tableLayout.addView(TRH_Flight);

        TableRow TRH_Origin = new TableRow(this);
        TRH_Origin.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Origin = new TextView(this);
        Label_Origin.setText("Origin :");
        Label_Origin.setTextSize(20);
        Label_Origin.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Origin.setGravity(Gravity.END);

        TextView Value_Origin = new TextView(this);
        Value_Origin.setText(origin);
        Value_Origin.setTextSize(20);
        Value_Origin.setGravity(Gravity.START);

        TRH_Origin.addView(Label_Origin);
        TRH_Origin.addView(Value_Origin);

        tableLayout.addView(TRH_Origin);

        TableRow TRH_Destination = new TableRow(this);
        TRH_Destination.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Destination = new TextView(this);
        Label_Destination.setText("Destination :");
        Label_Destination.setTextSize(20);
        Label_Destination.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Destination.setGravity(Gravity.END);

        TextView Value_Destination = new TextView(this);
        Value_Destination.setText(destination);
        Value_Destination.setTextSize(20);
        Value_Destination.setGravity(Gravity.START);

        TRH_Destination.addView(Label_Destination);
        TRH_Destination.addView(Value_Destination);

        tableLayout.addView(TRH_Destination);

        TableRow TRH_Departure_Time = new TableRow(this);
        TRH_Departure_Time.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Dep_Time = new TextView(this);
        Label_Dep_Time.setText("Departure Time :");
        Label_Dep_Time.setTextSize(20);
        Label_Dep_Time.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Dep_Time.setGravity(Gravity.END);

        TextView Value_Dep_Time = new TextView(this);
        Value_Dep_Time.setText(str_departuretime + " HRS");
        Value_Dep_Time.setTextSize(20);
        Value_Dep_Time.setGravity(Gravity.START);

        TRH_Departure_Time.addView(Label_Dep_Time);
        TRH_Departure_Time.addView(Value_Dep_Time);

        tableLayout.addView(TRH_Departure_Time);

        TableRow TRH_Start_Time = new TableRow(this);
        TRH_Start_Time.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Start_Time = new TextView(this);
        Label_Start_Time.setText("Arrival Time :");
        Label_Start_Time.setTextSize(20);
        Label_Start_Time.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Start_Time.setGravity(Gravity.END);

        TextView Value_Start_Time = new TextView(this);
        Value_Start_Time.setText(str_arrivaltime + " HRS");
        Value_Start_Time.setTextSize(20);
        Value_Start_Time.setGravity(Gravity.START);

        TRH_Start_Time.addView(Label_Start_Time);
        TRH_Start_Time.addView(Value_Start_Time);

        tableLayout.addView(TRH_Start_Time);

        TableRow TRH_Start_Date = new TableRow(this);
        TRH_Start_Date.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Start_Date = new TextView(this);
        Label_Start_Date.setText("Departure Date :");
        Label_Start_Date.setTextSize(20);
        Label_Start_Date.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Start_Date.setGravity(Gravity.END);

        TextView Val_Start_Date = new TextView(this);
        Val_Start_Date.setText(str_dep_date);
        Val_Start_Date.setTextSize(20);
        Val_Start_Date.setGravity(Gravity.START);

        TRH_Start_Date.addView(Label_Start_Date);
        TRH_Start_Date.addView(Val_Start_Date);

        tableLayout.addView(TRH_Start_Date);

        TableRow TRH_Dep_Date = new TableRow(this);
        TRH_Dep_Date.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Dep_Date = new TextView(this);
        Label_Dep_Date.setText("Arrival Date :");
        Label_Dep_Date.setTextSize(20);
        Label_Dep_Date.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Dep_Date.setGravity(Gravity.END);

        TextView Val_Dep_Date = new TextView(this);
        Val_Dep_Date.setText(str_arrival_date);
        Val_Dep_Date.setTextSize(20);
        Val_Dep_Date.setGravity(Gravity.START);

        TRH_Dep_Date.addView(Label_Dep_Date);
        TRH_Dep_Date.addView(Val_Dep_Date);

        tableLayout.addView(TRH_Dep_Date);

        TableRow TRH_Base_Fare = new TableRow(this);
        TRH_Base_Fare.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Base_Fare = new TextView(this);
        Label_Base_Fare.setText("Base Fare :");
        Label_Base_Fare.setTextSize(20);
        Label_Base_Fare.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Base_Fare.setGravity(Gravity.END);

        TextView Val_Base_Fare = new TextView(this);
        Val_Base_Fare.setText(str_base_fare);
        Val_Base_Fare.setTextSize(20);
        Val_Base_Fare.setGravity(Gravity.START);

        TRH_Base_Fare.addView(Label_Base_Fare);
        TRH_Base_Fare.addView(Val_Base_Fare);

        tableLayout.addView(TRH_Base_Fare);

        TableRow TRH_Sale_Fare = new TableRow(this);
        TRH_Sale_Fare.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Sale_Fare = new TextView(this);
        Label_Sale_Fare.setText("Sale Fare :");
        Label_Sale_Fare.setTextSize(20);
        Label_Sale_Fare.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Sale_Fare.setGravity(Gravity.END);

        TextView Val_Sale_Fare = new TextView(this);
        Val_Sale_Fare.setText(str_total_fare);
        Val_Sale_Fare.setTextSize(20);
        Val_Sale_Fare.setGravity(Gravity.START);

        TRH_Sale_Fare.addView(Label_Sale_Fare);
        TRH_Sale_Fare.addView(Val_Sale_Fare);

        tableLayout.addView(TRH_Sale_Fare);

        TableRow TRH_Total_Tax = new TableRow(this);
        TRH_Total_Tax.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Total_Tax = new TextView(this);
        Label_Total_Tax.setText("Total Tax :");
        Label_Total_Tax.setTextSize(20);
        Label_Total_Tax.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Total_Tax.setGravity(Gravity.END);

        TextView Val_Total_Tax = new TextView(this);
        Val_Total_Tax.setText(str_total_tax);
        Val_Total_Tax.setTextSize(20);
        Val_Total_Tax.setGravity(Gravity.START);

        TRH_Total_Tax.addView(Label_Total_Tax);
        TRH_Total_Tax.addView(Val_Total_Tax);

        tableLayout.addView(TRH_Total_Tax);

        TableRow TRH_Total_Fare = new TableRow(this);
        TRH_Total_Fare.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView Label_Total_Fare = new TextView(this);
        Label_Total_Fare.setText("Total Fare :");
        Label_Total_Fare.setTextSize(20);
        Label_Total_Fare.setTypeface(Typeface.DEFAULT_BOLD);
        Label_Total_Fare.setGravity(Gravity.END);

        TextView Val_Total_Fare = new TextView(this);
        Val_Total_Fare.setText(str_saletotal);
        Val_Total_Fare.setTextSize(20);
        Val_Total_Fare.setGravity(Gravity.START);

        TRH_Total_Fare.addView(Label_Total_Fare);
        TRH_Total_Fare.addView(Val_Total_Fare);

        tableLayout.addView(TRH_Total_Fare);

        TableRow TRH_Button = new TableRow(this);
        TableRow.LayoutParams params1 = new TableRow.LayoutParams();
        TRH_Button.setPadding(30, 40, 30, 0);
        params1.span = 2;

        OK_Button = new Button(this);
        OK_Button.setGravity(Gravity.CENTER_HORIZONTAL);
        OK_Button.setText("Got It!");
        OK_Button.setTextColor(Color.parseColor("#FFFF00"));
        OK_Button.setBackgroundColor(Color.parseColor("#0000FF"));
        OK_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TRH_Button.addView(OK_Button, params1);
        tableLayout.addView(TRH_Button);

        setTitle("Detail Flight Page");

        setContentView(tableLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_row_item, menu);
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
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
