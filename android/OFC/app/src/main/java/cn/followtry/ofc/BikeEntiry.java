package cn.followtry.ofc;

/**
 * Created by followtry on 2017/3/15.
 */

public class BikeEntiry {

    private String code;

    private String pwd;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "BikeEntiry{" +
                "code=" + code +
                ", pwd=" + pwd +
                '}';
    }
}
