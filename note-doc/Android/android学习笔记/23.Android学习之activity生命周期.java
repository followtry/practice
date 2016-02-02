/***********-- activity���������� --***********/
�����������ڵķ�����ϵͳ�Զ����õ�
@Override
protected void onCreate(Bundle savedInstanceState) {
	//�����������ڵĿ�ʼ���������Ԥ��д����
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
}

@Override
protected void onStart() {
	//�����������ڵĿ�ʼ��UI����ɼ�ʱ���ã�������ˢ�½���
	//���磬�ж������Ƿ����ӿ���ʱ�������������ж�
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

}

@Override
protected void onResume() {
	//ǰ̨�������ڵĿ�ʼ����ý���ʱ����

}

@Override
protected void  onPause()  {
	//ǰ̨�������ڵĽ�����ʧȥ����ʱ����

}
@Override
protected void onStop() {
	//�����������ڵĽ�����UI���治�ɼ�ʱ����

}
@Override
protected void onDestroy() {
	//�����������ڵĽ�����������ӱ��湦��

}

/*********-- �����Ի��� --**************/
����xml�����ļ�
 <activity
	android:theme="@android:style/Theme.Dialog"
	android:name="com.skd.activity.ThirdActivity"
	>
</activity>

�����е��ø��������Ӧ����


/********-- ������ʾ�� --**********/
//�����Ի���Ĺ�����
AlertDialog.Builder  builder=new Builder(MainActivity.this);
builder.setTitle("��ʾ:");
builder.setMessage("��ǰ���粻����");

builder.setPositiveButton("ȷ��", new OnClickListener() {
	@Override
	public void onClick(DialogInterface dialog, int which) {
		Intent intent = new Intent();
		intent.setClassName("com.android.settings", "com.android.settings.HWSettings");
		startActivity(intent);
	}
});
builder.create().show();


