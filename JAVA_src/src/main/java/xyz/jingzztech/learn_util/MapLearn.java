package xyz.jingzztech.learn_util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jingzz
 * @date 2016年3月26日 下午11:33:48
 * @name learn-src/xyz.jingzztech.learn_util.MapLearn
 */
public class MapLearn {
	public static void main(String[] args) {
		/*
		 * Map是将key映射到value上的对象。一个map对象不能包含重复的键；每个键最多只能映射一个值
		 * 
		 * 该接口替代了Dictionary类（完全的抽象类而非接口）。
		 * 
		 * Map接口提供了三个集合视图，使得map内容可以作为key的set显示，值的集合或者是k-v映射。
		 * map定义的次序作为map上集合显示返回元素的顺序。
		 * Map的实现类中比如TreeMap使用指定方式来保证他们的次序，而像HashMap却没有。
		 * 
		 * 注意:当使用可变对象作为map的key使用时，要非常小心的使用。
		 * 当对象值在作为map的key被改变时，map不会指定。
		 * 
		 * 特殊的禁止是不允许将map本身作为他自己的一个key，当将map作为自身的一个值时要格外小心。equal和hashCode方法将不好被定义了。
		 * 
		 * 所有的一般用途map实现类都应该提供两种标准的构造方法：无参构造方法和含有单一参数类型为Map的方法。
		 * 事实上，后者构造方法允许用户复制任何map。产生期望类同样的map。该建议非强制的但所有的一般用途的map实现类已经在JDK中实现了。
		 * 
		 * 一些map实现类对他们包含的key和value有限制。
		 * 例如：
		 * 	一些实现类禁止null作为key和value。
		 * 	一些限制key的类型。
		 * 如果插入不合格的key或者value会抛出 unchecked异常，典型的是NullPointerException和ClassCastException
		 * 如果尝试查询非法key或者value的存在性会抛出异常，或者简单返回false；
		 * 一些实现类会展现前者行为而其他一些展示后者行为
		 * 
		 * 许多集合框架接口的方法依照Object的equal方法。比如containsKey（obj）方法。
		 * 
		 * 一些map操作执行map的递归操作可能失败会因为直接或者间接的包含自身异常。方法 clone(), equals(), hashCode() and toString()
		 * 实现镇南关可能会随意处理自引用方案，然而大部分当前实现中不做这些。 
		 * 
		 */
		Map<Object, Object> fMap = new HashMap<Object, Object>();
		
		/**
		 * 返回map中k-v映射的数量，如果包含映射数量大于Integer.MAX_VALUE，则只显示Integer.MAX_VALUE
		 */
		fMap.size();
		
		/**
		 * 如果map不包含k-v映射，返回true。
		 */
		fMap.isEmpty();
		
		Object key = null;
		/**
		 * 检查map中是否包含指定的键key，判断逻辑(key==null ? k==null : key.equals(k))
		 */
		fMap.containsKey(key);
		
		Object value = null;
		/**
		 * 检查map中是否包含指定的值value，只要有一个k-v包含该值value，直接返回true。
		 * 
		 * 判断逻辑：(value==null ? v==null : value.equals(v))
		 */
		fMap.containsValue(value );
		
		/**
		 * 获取key所对应的值，如果不存在key，返回null
		 * 
		 * HashMap中判断逻辑为：(e = getNode(hash(key), key)) == null ? null : e.value
		 */
		fMap.get(key);
		
		/**
		 * 设置k-v映射，如果存在key，则替换掉以前的值，将以前的值返回，否则返回null
		 */
		fMap.put(key, value);
		
	}
}
