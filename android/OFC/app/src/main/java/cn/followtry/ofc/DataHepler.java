package cn.followtry.ofc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by followtry on 2017/3/15.
 */

public class DataHepler extends SQLiteOpenHelper {

    private static final String DB_NAME ="ofc.db";

    public DataHepler(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table bike_code (id integer  primary key autoincrement ,code varchar(20) ,pwd varchar(11))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
