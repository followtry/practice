package com.example.test;

import java.util.HashMap;
import java.util.Map;

import yonyou.esn.openapi.palmyy.testFunc.SimulationYonYouReg;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{
	
	private Button reg = null;
	
	Handler handler = new Handler() {  
	    @Override  
	    public void handleMessage(Message msg) {  
	        super.handleMessage(msg);  
	        Bundle data = msg.getData();  
	        String resultText = data.getString("resultText");  
	        Log.i("mylog", "请求结果为-->" + resultText);  
	        // TODO  
	        // UI界面的更新等相关操作  
	        Toast.makeText(MainActivity.this,resultText , Toast.LENGTH_LONG).show();
	    }  
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg = (Button)findViewById(R.id.register);
        reg.setOnClickListener(new OnClickListener() {
        	
			
			@Override
			public void onClick(View arg0) {
				
				new Thread(loginAndRegYonYouOffice).start();
					
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void regeditOffice(View v){
    	
    	System.out.println("签到");
    }
    
    Runnable loginAndRegYonYouOffice = new Runnable() {
		public void run() {
			Map<String, Object> initParams = new HashMap<String,Object>();
			
			//登录
			String result;
			try {
				result = SimulationYonYouReg.login(initParams);
			} catch (Exception e1) {
				result = null;
			}
			System.out.println(result);
			if (result == null) {
				Message msg = new Message();  
		        Bundle data = new Bundle();  
		        data.putString("resultText", "登录失败");  
		        msg.setData(data);  
		        handler.sendMessage(msg);
			}
			//登录后考勤 read(json, "$.store.book[*].author") 
			String random;
			try {
//				random = JsonPath.read(result, "$.response.random");
				int startIndex = result.indexOf("random") + 9;
				random = result.substring(startIndex, startIndex + 14);
				System.out.println(random);
			} catch (Exception e1) {
				random = null;
				e1.printStackTrace();
			}
				
			//签到
			String regResult ;
			try {
				regResult = SimulationYonYouReg.reg(initParams, random);
			} catch (Exception e) {
				regResult = null;
			}
			
			if (regResult != null) {
//				Integer flag = (Integer)JsonPath.read(regResult, "$.flag");
				
				int startIndex = regResult.indexOf("flag") + 7;
				Integer flag = Integer.valueOf(regResult.substring(startIndex, startIndex + 1));
				String resultText;
				if (flag == 0) {
					startIndex = regResult.indexOf("feedback") + 11;
					resultText = regResult.substring(startIndex, regResult.length() - 3);
//					resultText = (String)JsonPath.read(regResult, "$.response.feedback");
				}else{
					
					startIndex = regResult.indexOf("errormsg") + 11;
					resultText = regResult.substring(startIndex, regResult.length() - 3);
//					resultText = (String)JsonPath.read(regResult, "$.error.errormsg");
				}
				
				
				
				Message msg = new Message();  
		        Bundle data = new Bundle();  
		        data.putString("resultText", resultText);  
		        msg.setData(data);  
		        handler.sendMessage(msg);
			}
			
			//获取签到地点
//			getOfficeList(initParams, random);
		}
	};

	public static void main(String[] args) {
		MainActivity mainActivity = new MainActivity();
		new Thread(mainActivity.loginAndRegYonYouOffice).start();
	}

    
}
