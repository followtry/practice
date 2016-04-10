package xyz.jingzztech.learn_util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jingzz
 * @date 2016��3��26�� ����11:33:48
 * @name learn-src/xyz.jingzztech.learn_util.MapLearn
 */
public class MapLearn {
	public static void main(String[] args) {
		/*
		 * Map�ǽ�keyӳ�䵽value�ϵĶ���һ��map�����ܰ����ظ��ļ���ÿ�������ֻ��ӳ��һ��ֵ
		 * 
		 * �ýӿ������Dictionary�ࣨ��ȫ�ĳ�������ǽӿڣ���
		 * 
		 * Map�ӿ��ṩ������������ͼ��ʹ��map���ݿ�����Ϊkey��set��ʾ��ֵ�ļ��ϻ�����k-vӳ�䡣
		 * map����Ĵ�����Ϊmap�ϼ�����ʾ����Ԫ�ص�˳��
		 * Map��ʵ�����б���TreeMapʹ��ָ����ʽ����֤���ǵĴ��򣬶���HashMapȴû�С�
		 * 
		 * ע��:��ʹ�ÿɱ������Ϊmap��keyʹ��ʱ��Ҫ�ǳ�С�ĵ�ʹ�á�
		 * ������ֵ����Ϊmap��key���ı�ʱ��map����ָ����
		 * 
		 * ����Ľ�ֹ�ǲ�����map������Ϊ���Լ���һ��key������map��Ϊ�����һ��ֵʱҪ����С�ġ�equal��hashCode���������ñ������ˡ�
		 * 
		 * ���е�һ����;mapʵ���඼Ӧ���ṩ���ֱ�׼�Ĺ��췽�����޲ι��췽���ͺ��е�һ��������ΪMap�ķ�����
		 * ��ʵ�ϣ����߹��췽�������û������κ�map������������ͬ����map���ý����ǿ�Ƶĵ����е�һ����;��mapʵ�����Ѿ���JDK��ʵ���ˡ�
		 * 
		 * һЩmapʵ��������ǰ�����key��value�����ơ�
		 * ���磺
		 * 	һЩʵ�����ֹnull��Ϊkey��value��
		 * 	һЩ����key�����͡�
		 * ������벻�ϸ��key����value���׳� unchecked�쳣�����͵���NullPointerException��ClassCastException
		 * ������Բ�ѯ�Ƿ�key����value�Ĵ����Ի��׳��쳣�����߼򵥷���false��
		 * һЩʵ�����չ��ǰ����Ϊ������һЩչʾ������Ϊ
		 * 
		 * ��༯�Ͽ�ܽӿڵķ�������Object��equal����������containsKey��obj��������
		 * 
		 * һЩmap����ִ��map�ĵݹ��������ʧ�ܻ���Ϊֱ�ӻ��߼�ӵİ��������쳣������ clone(), equals(), hashCode() and toString()
		 * ʵ�����Ϲؿ��ܻ����⴦�������÷�����Ȼ���󲿷ֵ�ǰʵ���в�����Щ�� 
		 * 
		 */
		Map<Object, Object> fMap = new HashMap<Object, Object>();
		
		/**
		 * ����map��k-vӳ����������������ӳ����������Integer.MAX_VALUE����ֻ��ʾInteger.MAX_VALUE
		 */
		fMap.size();
		
		/**
		 * ���map������k-vӳ�䣬����true��
		 */
		fMap.isEmpty();
		
		Object key = null;
		/**
		 * ���map���Ƿ����ָ���ļ�key���ж��߼�(key==null ? k==null : key.equals(k))
		 */
		fMap.containsKey(key);
		
		Object value = null;
		/**
		 * ���map���Ƿ����ָ����ֵvalue��ֻҪ��һ��k-v������ֵvalue��ֱ�ӷ���true��
		 * 
		 * �ж��߼���(value==null ? v==null : value.equals(v))
		 */
		fMap.containsValue(value );
		
		/**
		 * ��ȡkey����Ӧ��ֵ�����������key������null
		 * 
		 * HashMap���ж��߼�Ϊ��(e = getNode(hash(key), key)) == null ? null : e.value
		 */
		fMap.get(key);
		
		/**
		 * ����k-vӳ�䣬�������key�����滻����ǰ��ֵ������ǰ��ֵ���أ����򷵻�null
		 */
		fMap.put(key, value);
		
	}
}
