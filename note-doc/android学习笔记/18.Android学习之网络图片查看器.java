/************-- ����ͼƬ�鿴�� ---*************/

��Ҫ����û�Ȩ�� android.permission.INTERNET
android.os.NetworkOnMainThreadException 2.3��4.x�������������
��4.x��������������������߳���

ANR  ���̣߳�UI�̣߳�
��������߳��еȴ����õ�ʱ�䣬Ӧ�ó���ͻ�����Ӧ
Ϊ�˱��⣬Ҫ�����߳�������

ֻ�����̲߳��ܸ���view����

1.���߳�����handler����һ����Ϣ��
��Ϣ���������̵߳���Ϣ������

2.���߳����looper��Ϣ����ѯ��
3.�����ѯ���������µ���Ϣ������handlermessage�ķ���������Ϣ

/***********-- Android����Ϣ���� --*****************/
�����߳���Ҫ��ʵ��Handler(),����д handleMessage(Message msg)����
/*--ToastҲ�����̵߳�UI�����Ҳֻ�������̵߳��ã����߳̽���Ϣ���͸����߳�--*/
//���̴߳�����Ϣ����Ⱥ
private  Handler handler=new Handler(){
	public void handleMessage(Message msg) {
		if (CHANGE_UI == msg.what) {
			imgShow.setImageBitmap((Bitmap)msg.obj);
		}else if (TOASTMSG == msg.what) {
			Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
		}
		
	};
};

�����߳���ָ��msg.what��msg.obj ������
/************--  ��������������������߳� --***********/
new Thread(){
	public void run() {
		
		URL url;
		try {
			url = new URL(path);
		
			//����URl����get����
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			//conn.setReadTimeout(5000);//�Ѿ�����������
			conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/4.0)");
			
			int responseCode = conn.getResponseCode();
			if (responseCode==200) {
				InputStream is = conn.getInputStream();
				Bitmap bitmap = BitmapFactory.decodeStream(is);
			//	imgShow.setImageBitmap(bitmap);
				//TODO �������߳�Ҫ�޸���UI��ֵΪbitmap
				Message msg=new Message();
				msg.what=CHANGE_UI;
				msg.obj=bitmap;
				handler.sendMessage(msg);
			}else {
				String error="��ʾͼƬʧ��";
				Message msg=new Message();
				msg.what=TOASTMSG;
				msg.obj=error;
				handler.sendMessage(msg);
			}
		}catch (Exception e) {
			String error="��ȡͼƬʧ��";
			Message msg=new Message();
			msg.what=TOASTMSG;
			msg.obj=error;
			handler.sendMessage(msg);
			e.printStackTrace();
		}
	};
	
}.start();
	