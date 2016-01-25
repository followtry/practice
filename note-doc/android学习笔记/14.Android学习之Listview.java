/************--- ListView ---************/
��ҳ��Ĳ����ļ��ж���listview�����ں�̨��ȡ��
��ȡ��service�е����ݺ�
PersonDao dao=new PersonDao(this);
persons = dao.findAll();	//��ȡ�������б�
listView=(ListView)findViewById(R.id.lv_show); //��ȡ��listview
listView.setAdapter(new MyAdapter());  //�̳�BaseAdapter���������������ݷ���listview��
listView.setOnItemClickListener(new onItemClick()); //����listview��item����¼�

private class MyAdapter extends BaseAdapter {
	//��ȡȡ�����ݵ�����
	@Override
	public int getCount() {
		return persons.size();
	}

	
	@Override
	public Object getItem(int position) {
		Log.i(TAG, "����view����λ�ã�"+position);
		TextView tView=(TextView)listView.getItemAtPosition(position);
		return tView;
	}

	@Override
	public long getItemId(int position) {
		
		return 0;
	}
	//����ÿ��item��view�����ظ�listview��������
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i(TAG, "����view����λ�ã�"+position);
		Person person=persons.get(position);
		
		View view=View.inflate(MainActivity.this, R.layout.list_view, null);
		
		TextView tView=(TextView)view.findViewById(R.id.tv_id);
		//��������е�������int���͵ģ�ϵͳ�ᵱ����R�е�idȥ���ң�����Ҫ��int����תΪString
		tView.setText(""+person.getId());
		
		tView=(TextView)view.findViewById(R.id.tv_name);
		tView.setText("����:"+person.getName());
		
		tView=(TextView)view.findViewById(R.id.tv_phone);
		tView.setText("�ֻ���:"+person.getPhone());
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StringBuffer sBuffer=new StringBuffer(); 
				TextView view=(TextView)v.findViewById(R.id.tv_name);
				sBuffer.append(view.getText()+"\n");
				view=(TextView)v.findViewById(R.id.tv_phone);
				sBuffer.append(view.getText()+"\n");
				Toast.makeText(MainActivity.this, sBuffer.toString(), Toast.LENGTH_SHORT).show();	
				
			}
		});
		
		
		
		return view;
	}
	
}