package cn.followtry.ofc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 操作csv文件
 * Created by followtry on 2017/3/13.
 */
public class CSVFileOper {

    private static Random random = new Random();

    public static void writeFile(String fileName, List<BikeEntiry> allBike) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        for (BikeEntiry bike : allBike) {
            writer.write(System.getProperty("line.separator"));
            writer.write(bike.getCode() + "," + bike.getPwd());
        }
        writer.close();
    }

    /**
     * 读取csv格式文件
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<BikeEntiry> readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String line = null;
        List<BikeEntiry> allBike = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length == 2) {
                System.out.println("单车编号：【" + values[0] + "】,密码：【" + values[1] + "]");
                BikeEntiry bike = new BikeEntiry();
                bike.setCode(values[0]);
                bike.setPwd(values[1]);

                allBike.add(bike);
            }
        }
        reader.close();
        return allBike;
    }

}
