/********** -- �����µ�activity����÷��ؽ�� --****************/
mainactivityҳ��
ѡ����ϵ��
public void selectPeople(View view){
	//Toast.makeText(this, "selectPeople", Toast.LENGTH_LONG).show();
	Intent intent=new Intent(this, ContactSelectACtivity.class);
	//���ǹؼ���Ҫʹ�ÿ��з���ֵ�ķ���
	startActivityForResult(intent, requestCode);
	//startActivity(intent);
}

//��д onActivityResult����������ȡ�������ݷ���ؼ���
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	if (data!=null) {
		String contact = data.getStringExtra("contact");
		etContact.setText(contact+etContact.getText().toString());
	}
}

ѡ����ϵ�˽���
listView�ؼ�ͨ�����������lvContacts.setAdapter(new ContactAdapter());
��ȡ��service�е����ݣ�
����item�ĵ���¼�����ʵ�ָýӿڵķ���
lvContacts.setOnItemClickListener(new ItemListener());
private class ItemListener implements OnItemClickListener{

	//�÷����Ϳ��Ի�ȡ��listView�ĵ���ؼ�
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		System.out.println("ContactSelectACtivity.ItemListener.onItemClick()");
		ContactInfo contactInfo = contactInfos.get(position);
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(contactInfo.getName());
		sBuffer.append("<");
		sBuffer.append(contactInfo.getPhone());
		sBuffer.append(">,");
		
		//���ɷ��ص����ݣ���ʹ��setResult����д�뷵��ֵ�У�
		//�˴�intentʹ�õı�����putExtra����
		//finish����ǰ����Ľ���رգ����ص�֮ǰ��ҳ�棬������֮ǰҳ���
		//onActivityResult��������ɷ���ֵ�Ļ�ȡ
		Intent data=new Intent();
		data.putExtra("contact", sBuffer.toString());
		setResult(0, data);
		finish();
	}
	
}

/****************-- ������ͽ��������� --*************/
requestCode ��Ҫ����������������
��startActivityForResult����������requestCode��ֵ
�� onActivityResult���ж�
if (requestCode==1) {
	//һ��startActivityForResult(intent, 1);
}else if (requestCode==2) {
	//��һ��startActivityForResult(intent, 2);
}

resultCode �ڵ��ҳ������	
Intent data=new Intent();
data.putExtra("contact", sBuffer.toString());
setResult(resultCode, data);
finish();
�� onActivityResult���ж�
if (resultCode==1) {
}else if (resultCode==2) {
}

