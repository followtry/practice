/**********-- ���ù㲥ʵ��IP���� --*****************/
��ȡ���õ�IP���ź���
private SharedPreferences sp;
sp = getSharedPreferences("config",MODE_PRIVATE);
sp.getString(SPKEY, DEFAULT_KEY_VALUE)

����IP���ŵĺ���
String number = etPhone.getText().toString().trim();
Editor edit = sp.edit();
edit.putString(SPKEY, number);
edit.commit();


//��д��̳й㲥����
package com.skd.ipdail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutCallReceiver extends BroadcastReceiver {

	private SharedPreferences sp;

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("OutCallReceiver.onReceive()  �Ⲧ�绰");
		String resultData = getResultData();
		
		sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		String ipNum = sp.getString("config", "");
		String phoneNumber=ipNum+resultData;
		setResultData(phoneNumber);
		System.out.println("����ip���ź���:"+phoneNumber);
	}

}

//���ù㲥����
AndroidManifest.xml
<!-- �����˹㲥�����ߣ�new��һ��������������action���൱�������˼�����Ƶ�� -->
<receiver 
	android:name="com.skd.ipdail.OutCallReceiver"
	>
	<intent-filter >
		<action android:name="android.intent.action.NEW_OUTGOING_CALL" 	 />
	</intent-filter>
</receiver>

��ӹ㲥����Ȩ��
<uses-permission android:name="android.permission.PROCESS_OUTGOING_CALLS"/>


