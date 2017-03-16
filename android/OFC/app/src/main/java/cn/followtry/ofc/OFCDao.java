package cn.followtry.ofc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by followtry on 2017/3/15.
 */

public class OFCDao {

    private DataHepler dataHepler;

    private SQLiteDatabase db;

    public OFCDao(Context context) {
        dataHepler = new DataHepler(context);
    }

    public void addRecord(BikeEntiry bike) {

        db = dataHepler.getWritableDatabase();
        String sql = "insert into bike_code(code,pwd) values(?,?)";
        Object[] values = {bike.getCode(), bike.getPwd()};
        db.execSQL(sql, values);
        close();
    }

    public void updateRecord(BikeEntiry bike) {
        db = dataHepler.getWritableDatabase();
        String sql = "update bike_code set pwd = ? where code = ?";
        Object[] values = {bike.getPwd(), bike.getCode()};
        db.execSQL(sql, values);
        close();
    }

    public BikeEntiry findRecord(String code){
        db=dataHepler.getReadableDatabase();
        BikeEntiry bike = null;
        String sql="select * from bike_code where code=?";
        Cursor rawQuery = db.rawQuery(sql, new String[]{code});
        if (rawQuery != null){
            boolean first = rawQuery.moveToFirst();
            if (first){
                String bikeCode = rawQuery.getString(rawQuery.getColumnIndex("code"));
                String bikePwd = rawQuery.getString(rawQuery.getColumnIndex("pwd"));
                if (bikePwd != null){
                    bike = new BikeEntiry();
                    bike.setCode(bikeCode);
                    bike.setPwd(bikePwd);
                }
            }
        }
        rawQuery.close();
        close();
        return bike;

    }


    public List<BikeEntiry> findAll(){
        db=dataHepler.getReadableDatabase();
        BikeEntiry bike = null;
        String sql="select * from bike_code order by code desc";
        Cursor rawQuery = db.rawQuery(sql,null);
        List<BikeEntiry> bikeList = new ArrayList<>();
        if (rawQuery != null){
            while (rawQuery.moveToNext()){
                String bikeCode = rawQuery.getString(rawQuery.getColumnIndex("code"));
                String bikePwd = rawQuery.getString(rawQuery.getColumnIndex("pwd"));
                if (bikePwd != null){
                    bike = new BikeEntiry();
                    bike.setCode(bikeCode);
                    bike.setPwd(bikePwd);
                    bikeList.add(bike);
                }
            }
        }
        rawQuery.close();
        close();
        return bikeList;

    }


    public void close() {
        if (db != null) {
            db.close();
        }
    }

}
