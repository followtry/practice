/************-- ��ת����һ��activity --*************/
���½���̳�activity��OtherScreenActivity
�½������ļ���activity_two.xml
�������ļ�AndroidManifest.xml��ע���activity��
ͨ��Intent ʵ��activity֮�����ת
Intent intent=new Intent()
intent.setCLassName(this,"����.����");
startActivity(intent);

activity�е� ����Androidͼ������ã�����activityһ�㲻����
<intent-filter>
	<action android:name="android.intent.action.MAIN" />
	<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>

�޸�application�����ֺ�ͼ�꣬activity�����ֺ�ͼ��
������activity�����ֺ�ͼ��ʱ������������ʾ����activity�����ֺ�ͼ�������
application��ͼ������֣�ÿ��activity�����ֺ�ͼ������Զ�������
��Androidmanifest.xml�ļ���

/*********************************************/
2.��ʾ��ͼ����ϵͳӦ��
Intent intent = new Intent();
intent.setClassName("com.android.gallery3d", "com.android.gallery3d.app.Gallery");
startActivity(intent);
����ͨ��logcat�д�ӡ��activityManager��cmp��İ�������������
cmp=com.android.gallery3d/.app.Gallery

/******************** ����û������� *************/
ConnectivityManager  systemService = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo networkInfo = systemService.getActiveNetworkInfo();
if (networkInfo!=null&&networkInfo.isConnected()) {
	Toast.makeText(this, "�������", Toast.LENGTH_SHORT).show();
}else {
	Toast.makeText(this, "���粻���ã���ת����������", Toast.LENGTH_SHORT).show();
	Intent intent = new Intent();
	intent.setClassName("com.android.settings", "com.android.settings.HWSettings");
	startActivity(intent);
}

/***********-- ��ʽ��ͼ	����activity --****************/
��ʽ��ͼ���������
public void btClick(View view){
	Intent intent = new Intent();
	intent.setAction(Intent.ACTION_VIEW);
	intent.setData(Uri.parse("http://3g.qq.com"));
	startActivity(intent);
	
}

/***************  activity����ʽ���� ********************/
��ͼ����������������
<intent-filter>
	<action android:name="android.intent.action.MAIN" />
	<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>

ͬһ��Ӧ�ó����У��Լ������Լ��Ķ������Ƽ�ʹ����ʽ��ͼ��Ч�ʸ�

������˵�Ӧ�û��߲�ͬӦ�ü䣬����ϣ���Լ���ĳ��ҳ�汻���˼���Ƽ�ʹ����ʽ��ͼ
1.�鿴ϵͳ�������activity�����Ƿ�������������activity
2.�У��ж��м�����һ����֮��������������б���ʽѡ��
3.���û�У�Ӧ�ó����쳣��ֹ��activity not found Exception

