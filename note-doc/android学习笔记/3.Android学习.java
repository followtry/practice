/****************************************/
android �������裺
1.��res/layout/activity_main.xmlд������޸�Ĭ�ϵĿռ����
2.��mainactivity�е�onCreate��������ӿռ���ӵ���¼�
3.�޸�Ӧ������Ҫ��Ȩ��
/****************************************/
��������¼������ַ�ʽ��
	1."�����ڲ���"
	2."�����ڲ���"
	3.�õ��õ��࣬��mainactivityʵ��OnClickListener�ӿ�(����)
	button.onClickListenre(this);
	Ȼ����onClicklistener��view v�����ж����ĸ��ؼ��ĵ���¼�
	4.�ڲ����ļ��а󶨵�������������������Զ���

/***********---���������÷�����---**************/

private void callPhone(){
		String phoneNumber = et_num_local.getText().toString().trim();
		if (TextUtils.isEmpty(phoneNumber)) {
			/**
			 * ��˾��������js��alert
			 */
			Toast toast = Toast.makeText(MainActivity.this, "���벻��Ϊ��", Toast.LENGTH_LONG);
			/**
			 * ��ʾ����
			 */
			toast.show();
		}
		/**
		 * ��ͼ������Ҫ��ʲô��
		 */
		Intent intent=new Intent();
		intent.setAction(intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:"+phoneNumber));
		startActivity(intent);
	}

/************---���ŷ��������÷�����---************/

String phone = phoneNum.getText().toString().trim();
		String msgContent = content.getText().toString().trim();
		
		SmsManager smsManager=SmsManager.getDefault();
		//sentIntent ��������Ƿ��ͳ�ȥ
		//deliveryIntent ��������Ƿ��ʹ�
		smsManager.sendTextMessage(phone, null, msgContent, null, null);
}

/*********---������ʾ---********/

/**
 * ��˾��������js��alert
 */
Toast toast = Toast.makeText(MainActivity.this, "���벻��Ϊ��", Toast.LENGTH_LONG);
/**
 * ��ʾ����
 */
toast.show();

/****************************************/

/****************************************/

/****************************************/

/****************************************/

/****************************************/

/****************************************/

