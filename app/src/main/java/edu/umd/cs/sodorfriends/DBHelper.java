package edu.umd.cs.sodorfriends;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vibha on 4/5/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "sodor.db";
    public static final String TB_NAME = "traintable2";
    public static final String TB_COL1 = "one";
    public static final String TB_COL2 = "two";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE traintable2(one varchar(10), two smallint");
    }

    public void onUpgrade(SQLiteDatabase db, int older, int newer) {
        //tbd
    }

    public void insertData(String name, int num) {
        //tbd
    }

    public void onDowngrade(SQLiteDatabase db, int older, int newer) {
        //tbd
    }

}
