package saumikbhattacharya.FlightSearch.com;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class About_Activity extends AppCompatActivity {

    TextView about_app,about_dev;
    String versionName;
    int versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About");
        setContentView(R.layout.activity_about);

        try
        {
            about_app = (TextView)findViewById(R.id.about_app);
            about_dev = (TextView)findViewById(R.id.about_dev);

            PackageInfo pInfo = getPackageManager().getPackageInfo(this.getPackageName(), 0);
            versionName = pInfo.versionName;
            versionCode = pInfo.versionCode;
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        about_app.setText("FlightSearch "+versionName+" is an app for searching direct flights between locations chosen by the user."+"\n"+"It allows user to go through the list of flights and allows him/her even to check the details about each flight."+"\n"+"It doesn't have flight booking facility."+"\n"+"It also allows user to check his/her destination location in a map and then go ahead with searching the flight.");

        about_dev.setText("This application has been built by SAUMIK BHATTACHARYA."+"\n"+"Saumik is new to Android Programming. He has great interest in learning this technology."+"\n"+"He is always on his toes when it comes to developing Android Application."+"\n"+"Contact No.: +91 9741028770"+"\n"+"Email Address: saumikbhattacharya89@gmail.com"+"\n"+"Location: Bangalore.");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_activity, menu);
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
}
