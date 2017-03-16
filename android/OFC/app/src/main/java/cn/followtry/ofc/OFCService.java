package cn.followtry.ofc;

import android.content.Context;

import java.util.List;

/**
 * 对于车号和密码的读写操作
 * Created by followtry on 2017/3/14.
 */

public class OFCService {

    private OFCDao ofcDao;

    public OFCService(Context context){
        ofcDao = new OFCDao(context);
    }

    public void save(BikeEntiry entiry) {
        BikeEntiry one = findOne(entiry.getCode());
        if (one == null){
            ofcDao.addRecord(entiry);
        }else{
            ofcDao.updateRecord(entiry);
        }

    }


    public BikeEntiry findOne(String bikeCode) {
        BikeEntiry record = ofcDao.findRecord(bikeCode);
        return record;
    }

    public List<BikeEntiry> findAll() {
        List<BikeEntiry> allBike = ofcDao.findAll();
        return allBike;
    }
}
