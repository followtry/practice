/*******--- sqlite���ݿ� ---******/
sqlite���ݿ� ==>�ƶ�ƽ̨��Ƕ��ʽ���ݿ�

sqlite���ݿ���Ϊ��Ƕ��ʽ���ݿ⣬��������ͱȽ��٣��ڵײ�洢ʱ
������string���ʹ洢�ģ���дsql���ʱ�Գ��ȵ����������ѳ���Ա�ģ�
����sqlite���ݿ�洢��û�����Ƶ� 

Ҫ�̳�SQLiteOpenHelper
public class PersonSqliteOPenHelper extends SQLiteOpenHelper {
	
	private static String DBName="person.db";
	
	/**
	 * ���ݿ�Ĺ��췽�� �������ݿ�����Ƽ����ݿ��ѯ�Ľ���� ���ݿ�汾
	 * @param context
	 */
	public PersonSqliteOPenHelper (Context context) {
		super(context, DBName, null, 1);
	}

	/**
	 * ���ݿ��һ�α�����ʱ���õķ���
	 * @param db �����������ݿ�
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="create table person (id integer  primary key autoincrement ,name varchar(20) ,phone varchar(11))";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}

/*************sql �������ݿ� *****************/
public class PersonDao {
	
	private PersonSqliteOPenHelper dHelper;
	
	private SQLiteDatabase db;
	
	public PersonDao(Context context){
		dHelper=new PersonSqliteOPenHelper(context);
	}
	
	/**
	 * ���name��phone
	 * @param name
	 * @param phone
	 */
	public void add(String name,String phone){
		db=dHelper.getWritableDatabase();
		String sql="insert into person(name,phone) values(?,?)";
		db.execSQL(sql, new Object[]{name,phone});
		db.close();
	}
	
	/**
	 * ����name���Ҽ�¼�Ƿ����
	 * @param name
	 * @return
	 */
	public boolean find(String name){
		db=dHelper.getReadableDatabase();
		String sql="select * from person where name=?";
		Cursor rawQuery = db.rawQuery(sql, new String[]{name});
		boolean result = rawQuery.moveToNext();
		rawQuery.close();
		db.close();
		return result;
		
	}
	
	/**
	 *  ����name�˵��ֻ���
	 * @param name
	 * @param newPhone
	 */
	public  void update(String name,String newPhone){
		db=dHelper.getWritableDatabase();
		String sql="update person set phone = ? where name = ?";
		String[] bindArgs={newPhone,name};
 		db.execSQL(sql, bindArgs);
 		db.close();
		
	}
	
	/**
	 * ����nameɾ��һ����¼
	 * @param name
	 */
	public void delete(String name){
		db=dHelper.getWritableDatabase();
		String sql="delete from person where name = ?";
		String[] bindArgs={name};
		db.execSQL(sql, bindArgs);
		db.close();
	}
	
	/** 
	 * ��ѯ���м�¼
	 * @return
	 */
	public List<Person> findAll(){
		db=dHelper.getReadableDatabase();
		String sql="select * from person";
		Cursor rawQuery = db.rawQuery(sql, null);
		Person person=null;
		List<Person> persons=new ArrayList<Person>();
		while (rawQuery.moveToNext()) {
			String name =rawQuery.getString(rawQuery.getColumnIndex("name"));
			String phone =  rawQuery.getString(rawQuery.getColumnIndex("phone"));
			
			person=new Person();
			person.setName(name);
			person.setPhone(phone);
			persons.add(person);
		}
		rawQuery.close();
		db.close();
		return persons;
	}
}


