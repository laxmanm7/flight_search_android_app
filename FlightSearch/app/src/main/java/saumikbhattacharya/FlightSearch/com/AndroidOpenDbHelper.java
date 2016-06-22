package saumikbhattacharya.FlightSearch.com;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class AndroidOpenDbHelper extends SQLiteOpenHelper implements BaseColumns{

    public static final String DB_NAME = "FlightSearch_Detail_DB";
    public static final int DB_VERSION = 2;
    public static final String TABLE_NAME_FLIGHTSEARCH_DTL = "FlightSearch_Detail_Table";
    public static final String COLUMN_NAME_ORIGIN = "Origin";
    public static final String COLUMN_NAME_DESTINATION = "Destination";
    public static final String COLUMN_NAME_START_DATE = "Start_Date";
    public static final String COLUMN_NAME_NUM_ADLT = "Num_Adult";
    public static final String COLUMN_NAME_NUM_INFANT = "Num_Infant";
    public static final String COLUMN_NAME_CURRENT_DATE = "Current_Date";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE "+AndroidOpenDbHelper.TABLE_NAME_FLIGHTSEARCH_DTL+" ("+AndroidOpenDbHelper._ID+" INTEGER PRIMARY KEY"+COMMA_SEP+AndroidOpenDbHelper.COLUMN_NAME_ORIGIN+TEXT_TYPE+COMMA_SEP+AndroidOpenDbHelper.COLUMN_NAME_DESTINATION+TEXT_TYPE+COMMA_SEP+AndroidOpenDbHelper.COLUMN_NAME_START_DATE+TEXT_TYPE+COMMA_SEP+AndroidOpenDbHelper.COLUMN_NAME_NUM_ADLT+TEXT_TYPE+COMMA_SEP+AndroidOpenDbHelper.COLUMN_NAME_NUM_INFANT+TEXT_TYPE+COMMA_SEP+AndroidOpenDbHelper.COLUMN_NAME_CURRENT_DATE+TEXT_TYPE+")";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS "+AndroidOpenDbHelper.TABLE_NAME_FLIGHTSEARCH_DTL;

    public AndroidOpenDbHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion)
    {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
}
