/***********---����---***************/
���ݲ����Ƿ�֪��Դ���룺�ںв���(��֪��Դ���룬ֻ���Ĺ��̺ͽ��)��
�׺в��ԣ�����Դ����д��������	
--���ݲ��Ե����ȣ�
	�������ԣ�function test
	��Ԫ���ԣ�unit test
	���ɲ��ԣ�intergration test
--���ݲ��ԵĴ�����
	ð�̲��ԣ�smoke test��Android ����	��
		cmd#monkey 5000 ����5000�ε��
	ѹ�����ԣ�press test
/***********---��������---***************/
1.������Ҫ�̳�AndroidTestCase
	public class TestCalcServer extends AndroidTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public void testAdd(){
		CalcServer calcServer=new CalcServer();
		int result = calcServer.add(3, 4);
		assertEquals(7, result);
		
	
	}

}
2.��mainfest�������
//targetPackage Ҫ���Եİ���
<instrumentation 
        android:name="android.test.InstrumentationTestRunner"
        android:targetPackage="com.skd.junittest" 
        ></instrumentation>
<application >
	 <uses-library android:name="android.test.runner"/>
</applicaion>


/***********------***************/

/***********------***************/

/***********------***************/

/***********------***************/

