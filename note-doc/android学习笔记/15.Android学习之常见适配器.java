/**********--- ���������� ---**************/
arrayAdapter ������

private static String[] names={"����1","����2","����3","����4","����5","����2","����3","����4","����5","����2","����3","����4","����5"};

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	lvShow=(ListView)findViewById(R.id.lv_show);
	lvShow.setAdapter(new ArrayAdapter<String>(this, R.layout.list_view, R.id.tv_item, names));
}

list_view.xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
	android:orientation="horizontal"
	>
	<ImageView 
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    android:src="@drawable/ic_launcher"
	    />
    
    
    <TextView
        android:id="@+id/tv_item"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
	></TextView>
</LinearLayout>

sampleAdapter ������
private ListView lvItems;
	
private static List<Map<String, Object>> data=new ArrayList<Map<String,Object>>();

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Map<String, Object> map1=new HashMap<String, Object>();
	map1.put("name", "���ǵ�һ������");
	map1.put("iconid", R.drawable.ic_menu_allfriends);
	Map<String, Object> map2=new HashMap<String, Object>();
	map2.put("name", "���ǵ���������");
	map2.put("iconid", R.drawable.ic_menu_agenda);
	Map<String, Object> map3=new HashMap<String, Object>();
	map3.put("name", "���ǵ��ĸ�����");
	map3.put("iconid", R.drawable.ic_menu_always_landscape_portrait);
	
	data.add(map1);
	data.add(map2);
	data.add(map3);
	data.add(map4);
	data.add(map5);
	data.add(map6);
	String[] from={"iconid","name"};//map�ж�Ӧ��kay
	int[] to={R.id.imgv_item,R.id.tv_item};//map�����󶨵Ĳ����ļ��еĿؼ�����
	lvItems=(ListView)findViewById(R.id.lv_items);
	lvItems.setAdapter(new SimpleAdapter(this, data, R.layout.list_item, from, to));
}


