package com.yonyou.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class HashMapTest {
	public static void main(String[] args) throws InterruptedException {

		/**
		 * HashTable基于map接口实现，该实现应用了map操作的所有选择，并且允许插入null值和null键。
		 * HashMap类粗略的可以等同于HashTable，除了它不是同步的和允许null。
		 * 该类不保证map的顺序，特别是它不保证顺序会一直不变。
		 * 
		 * 假设hash算法能恰当的将所有元素分散在桶中，那么该实现类提供了在基本操作(get和put)上的恒定时间性能。
		 * 集合视角上的迭代需要的时间和HashMap实例的容量(桶的数量)加上其size(k-v映射的数量)成正比。
		 * 因此，如果迭代性能是个很重要方面的话，不把初始容量设置的太高或者负载因子设置的太低就显得尤为重要了。
		 * 
		 * 初始容量和负载因子是影响HashMap性能的两个重要参数。该容量是hash table中桶的数量。简单说，初始化容量是hash
		 * table创建时的容量。 负载因子是hash table何时被允许自动增长容量的衡量限值。
		 * 当hashtable中实体的数量超过当前容量和负载因子乘积时，hashtable就会被重新做hash处理（内部数据结构重建），
		 * 因此hashtable 近似是桶的数量的两倍。
		 * 
		 * 一般情况下，默认负载因子(0.75)在时间和空间消耗上提供了很好的平衡，更大的值会降低空间消耗，但同时也增加了检索时间(
		 * 影响了包括get和set操作在内的HashMap大部分操作)。
		 * map中实体(k-v)的期望值和他的负载因子应该在设置初始化容量时被考虑在内，以便最小化重新hash操作的次数。
		 * 如果吃实话容量比最大的实体数量出以负载因子还大，重新hash操作就永远不会发生。
		 * 
		 * 如果虚火映射被存储在HashMap实例中，
		 * 那么创建该实例时指定足够大的容量容纳映射存储将比让HashMap在需要增长table时执行自动rehash更高效。
		 * 
		 * 注意：很多的键使用相同的hashCode方法是必然要降低任何一个hashtable性能的。为了降低影响，当keys是Comparable时
		 * ，该类可以使用在key上使用比较指令来帮助打破ties；
		 * 注意：该实现不是同步的，如果多线程并发访问同一个HashMap，并且至少一个线程修改map的结构(结构修改指增删一个或多个映射，
		 * 仅仅改变与实例中的key有关系的值不是结构修改)，该map必须是同步的。
		 * 这通常是通过同步一些天然封装在map中的对象，如果这样的对象不存在，则map应该被使用Collections.
		 * synchronizedMap方法封装，最好在创建时做，可以避免临时的非同步访问map。 Map m =
		 * Collections.synchronizedMap(new HashMap(...));
		 * 该类的集合视角的方法返回的迭代器是快速失败的；如果map在迭代器创建后的任何时候结构被修改，除非是通过迭代器自己的额remove方法，
		 * 否则迭代器将会抛出ConcurrentModificationException(并发修改异常)，
		 * 
		 * 因此，面对并发修改，相对于在未来一个不确定时间的不确定行为的武断风险而言，迭代器的失败是快速和干净利索的。
		 * 
		 * 注意：一般而言，迭代器的快速失败行为不能被保证，因为不可能在面对非同步并发修改时设置任何的硬性保证。
		 * 
		 * 快速失败迭代器在最大努力的基础上抛出ConcurrentModificationException，
		 * 因此编程时依赖该异常检测其正确性是错误的：迭代器的快速失败行为应该只被用于检测hug。
		 * 
		 * 该类是java集合框架的一部分。
		 * 
		 * 
		 * 注：map的最大容量为2的30次方(1073741824)， Node<K,V>[] table 实际存储k-v的Node数组
		 * map内部存储实质上存在链表关系的Node对象数组。
		 * threshold :map下一次扩容的临界值(容量*负载因子)
		 * 
		 */
		HashMap<String, Object> map;

		// 无参构造方法只是设置负载因子为默认0.75，其他默认(包括初始化容量为16)
		map = new HashMap<String, Object>();
		int initialCapacity = 0;

		// 指定map的初始容量大小，同时使用默认的负载因子0.75
		map = new HashMap<String, Object>(initialCapacity);
		map = new HashMap<String, Object>(map);
		float loadFactor = 0.75f;

		// 由指定的初始化容量大小和负载因子大小实例化空的map,并计算出下一次自动扩容的大小
		map = new HashMap<String, Object>(0, loadFactor);

		/***************************************************************
		 * map 中批量复制map数据的算法 putMapEntries方法 1.计算map中table是否存在并计算临界值threshold
		 * 2.循环遍历map2中的k-v并通过putVal方法将k-v存入map中
		 ***************************************************************/

		String key = "123";
		String value = "456";
		Object defaultValue = "789";

		/**
		 * 判断map中是否包含该key 调用getNode方法，并判断返回值是否为null来返回Boolean；
		 * 
		 * 逻辑：1. 在map的table(k-v存储结构)存在且length不为0，
		 * 并且table中对应位置(key的hash位置)不为空时继续操作。 2.
		 * map中指定hash的first节点的hash值是否等于指定的hash(hash(key)),
		 * 并检查first节点中的key是否和指定的key相等。相等直接返回，不相等则判断是否first节点还有next节点 3.
		 * 如果有next节点，调用getTreeNode方法或者直接遍历next判断是否存在该key
		 */
		map.containsKey(key);

		/**
		 * 当table的大小不为0时，for循环将table数组的每一个Node对象置为null；
		 */
		map.clear();

		/**
		 * 返回的是浅克隆的当前map的实例。
		 * 逻辑：实例化空的HashMap对象result，重新初始化后将当前map的值通过内部putMapEntries方法赋值给新的HashMap
		 * ，并返回result实例
		 */
		map.clone();

		BiFunction<? super String, ? super Object, ? extends Object> remappingFunction = null;
		/**
		 * map在jdk1.8之后添加的方法， 使用例子如下(函数式编程)： map.compute(key, (k, v) -> (v ==
		 * null) ? msg : v.concat(msg))
		 */
		map.compute(key, remappingFunction);

		Function<? super String, ? extends Object> mappingFunction = null;
		map.computeIfAbsent(key, mappingFunction);

		map.computeIfPresent(key, remappingFunction);

		/**
		 * 判断是否存在指定值value。
		 * 
		 * 逻辑：没有什么好办法，只能通过生成map的key迭代器，
		 * 父类AbstractMap中遍历是否存在指定的value，value=null和value!= null时分别计算。
		 * HashMap中table结构的特殊性决定了需要for循环table数组中每个Node对象，
		 * 然后判断Node对象的值或者其next内的值是否等于value
		 * 
		 */
		map.containsValue(value);

		/**
		 * Set<Map.Entry<K,V>> entrySet;
		 * 当entrySet不为null是返回entrySet，否则返回空的EntrySet
		 */
		Set<Entry<String, Object>> entrySet = map.entrySet();

		Object obj = null;
		/**
		 * 判断obj是否等于map
		 * 
		 * 父类AbstractMap中的方法
		 * 逻辑。： 
		 * 1.obj 是自身，返回true； 
		 * 2.obj不是map类型，返回false；
		 * 3.obj和map的size不相等，返回false；
		 * 4.迭代器遍历map中的key和value是否与obj中的相等，只要有一个不等就返回false
		 * 4.1 如果value为null,判断key对应的值是否为null,并且key是否存在。
		 * 4.2 如果value不为null，判断两个判断的Node节点的value是否相等
		 */
		map.equals(obj);

		BiConsumer<? super String, ? super Object> action = null;
		/**
		 * TODO jdk1.8中的方法，暂时不关注
		 */
		map.forEach(action);

		/**
		 * 检索key对应Node对象逻辑与containsKey方法相同，
		 * 区别：是当获取的Node对象不为null时，返回Node对象的value，
		 * 而containsKey根据是否为null返回Boolean值
		 */
		map.get(key);
		
		/**
		 *  获取一个运行时map对象
		 */
		map.getClass();
		
		/**
		 * 检索key对应Node对象逻辑与get方法相同，
		 * 区别：当Node节点为null时，get方法返回null，而getOrDefault返回设置的默认值defaultValue
		 */
		map.getOrDefault(key, defaultValue);
		
		/**
		 * 
		 */
		map.hashCode();

		/**
		 * 判断map是否为null就是判断其size是否等于0
		 */
		map.isEmpty();
		
		/**
		 * transient volatile Set<K>        keySet;
		 * 如果keySet不为null，返回keySet，否则返回KeySet空对象
		 * 该keySet的contains方法作用与map的containsKey相同
		 */
		map.keySet();

		BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction2 = null;
		/**
		 * jdk1.8 添加的方法
		 */
		map.merge(key, defaultValue, remappingFunction2);
		
		/**
		 * 
		 */
		map.notify();

		map.notifyAll();
		
		/**
		 * resize 方法 ：
		 * 1.threshold扩容
		 * 2.newCap 扩容
		 * 3.将原map中table数组的每个元素都重新赋值到新的table数组中，同一个索引下的连接元素也要以同样的方式存储
		 * 
		 *不管是在list还是map中，占用resize方法是最消耗内存和性能的方法。在明确集合容量大小的情况下，尽量制定容量而不是自动扩容 
		 */
		
		
		/**
		 * putVal方法逻辑：
		 * 1.如果table为null或者length==0，重新设置大小
		 * 2.如果(n - 1) & hash位置为null，创建一个新的Node节点
		 * 3.如果(n - 1) & hash位置不为null
		 * 3.1 如果key能和给定的key匹配，捕获该Node节点p，继续向下执行
		 * 3.2 如果p节点是TreeNode类型，调用TreeNode的putTreeVal方法继续获取Node节点p
		 * 3.3 循环如果Node的next为null时为找到对应的key，创建新的Node节点
		 * 3. 如果节点不为null，onlyIfAbsent == false或者null时，将新的value赋给该节点并返回原来的值
		 * 		否则不操作
		 * 4.如果当前map中Node节点数量超过临界值，扩容
		 */
		
		/**
		 * 添加k-v数据
		 * 内部调用putVal方法实现
		 * 
		 */
		map.put(key, value);

		Map<? extends String, ? extends Object> m = null;
		/**
		 * 调用putMapEntries方法，与构造方法相同(除了不设置负载因子)
		 */
		map.putAll(m);  
		
		/**
		 * 与put的不同是，在put中不管key对应的值存在则将原值覆盖，putIfAbsent中只有在key对应的值不存在时赋值。
		 * key对应的值也有可能是null，同样不会被覆盖
		 * 
		 */
		map.putIfAbsent(key, value);

		map.remove(key);

		map.remove(key, defaultValue);

		map.replace(key, defaultValue);

		Object oldValue = null;
		Object newValue = null;
		map.replace(key, oldValue, newValue);

		map.size();

		map.toString();

		Collection<Object> values = map.values();

		map.wait();

		long timeout = 0;
		map.wait(timeout);

		int nanos = 0;
		map.wait(timeout, nanos);

	}
}
