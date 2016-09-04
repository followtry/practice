package com.yonyou.test;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

public class ConCurrentHashMapTest {
	public static <U> void main(String[] args) throws InterruptedException {
		/**
		 * 实现目标： 1.保持hashTable的并发读(典型方法是get，以及迭代器和其他相关方法)的同时最小化更新争夺
		 * 2.保持与HashMap一样或者更好的空间消耗，和在多线程下高速的空表初始化插入速率
		 * 
		 * 该Map通常是分级(桶)的Hashtable。每个k-v映射被存在一个Node节点中。大部分节点是基本Node类（含有hash,key,
		 * value,next成员域）的实例 然而 在各种子类中的存在：
		 * 树节点（TreeNode）是被设计在平衡术中，不是列表，二叉树存储着树节点（TreeNode）集合的根
		 * 转发节点(ForwardingNodes) 占位节点(ReservationNodes)
		 * 转发节点(ForwardingNodes),占位节点(ReservationNodes)不会存储正常的用户key，value或者hash，
		 * 在搜索中容易辨别
		 * 
		 * 存储结构table仍然是依赖第一次插入的2倍指数懒加载增长方式。table中的每一个bin一般保存一个节点列表(
		 * 多数情况下，列表(list)只有一个或者没有Node对象) 表访问需要不稳定/原子读写和CAS(compare and
		 * set[设置值之前先比较])。因为在没有添加进一步间接寻址的条件下，我们用内联函数操作不能提供其他方式处理这对象
		 * 
		 * 缺点: 每个桶加锁的缺点是在桶内列表的其他节点上的其他更新操作被相同的锁保护而阻塞。比如，当使用equals或者映射方法将会花费很长时间。
		 * 然而，从统计上说，在随机的hash码下，这不是一个常见的问题
		 * 。虽然因为重设大小的粒度会有很大的差异，但是理想状态下，桶中节点的频率遵从泊松分布，限制因素平均为0.5，
		 * 给出重设大小极限值为0.75。忽略方差时，list的预期大小是(exp(-0.5) * pow(0.5, k) /
		 * factorial(k))。
		 * 
		 * * 0: 0.60653066 1: 0.30326533 2: 0.07581633 3: 0.01263606 4:
		 * 0.00157952 5: 0.00015795 6: 0.00001316 7: 0.00000094 8: 0.00000006
		 * more: 在1千万容量下，小于1 在随机hash情况下，两个线程进入不同元素的锁的争夺的可能性大约为1/(8 *
		 * elements),也就是说元素越多，这种争夺的可能性越小
		 * 
		 * 
		 * 
		 * 
		 * 注：
		 * 最大容量： 1 << 30【1073741824】。 
		 * 默认容量：16 
		 * 最大数组带下： 2147483639
		 * 默认并发级别：16 即最大允许16个线程同时操作该类对象
		 * 默认树模型的极限值：8
		 * 默认非树模型的极限值：6
		 * 最小的树模型极限值：64
		 * 最小转换步长：16
		 * 调整游标位置：16 在32位数组下至少是6；RESIZE_STAMP_BITS
		 * 可以调整大小的最大线程数量： (1 << (32 - RESIZE_STAMP_BITS)) - 1;
		 * 
		 * Node的hash域编码
		 *  static final int MOVED     = -1; // hash for forwarding nodes
		    static final int TREEBIN   = -2; // hash for roots of trees
		    static final int RESERVED  = -3; // hash for transient reservations
		    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
		 */
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
		
		map = new ConcurrentHashMap<String, Object>(0);
		
		int concurrencyLevel = 16;
		float loadFactor = 0.75f;
		map = new ConcurrentHashMap<String, Object>(0, loadFactor, concurrencyLevel);
		
		map = new ConcurrentHashMap<>(map);
		
		int initialCapacity = 10;
		map = new ConcurrentHashMap<>(initialCapacity , loadFactor);
		
		String key = null;
		/**
		 * 内部调用get方法判断获取的元素是否为null
		 */
		map.containsKey(key);

		map.clear();

		Object value = null;
		map.containsValue(value);

		map.contains(value);

		BiFunction<? super String, ? super Object, ? extends Object> remappingFunction = null;
		map.compute(key, remappingFunction);

		Function<? super String, ? extends Object> mappingFunction = null;
		map.computeIfAbsent(key, mappingFunction);

		map.computeIfPresent(key, remappingFunction);

		map.elements();

		map.entrySet();

		map.equals(map);

		BiConsumer<? super String, ? super Object> action = null;
		map.forEach(action);

		long parallelismThreshold = 16;
		map.forEach(parallelismThreshold, action);

		BiFunction transformer = null;
		Consumer action3 = null;
		map.forEach(parallelismThreshold, transformer, action3);

		Consumer<? super Entry<String, Object>> action2 = null;
		map.forEachEntry(parallelismThreshold, action2);

		Function transformer2 = null;
		map.forEachEntry(parallelismThreshold, transformer2, action3);

		map.forEachKey(parallelismThreshold, action3);

		map.forEachKey(parallelismThreshold, transformer2, action3);

		map.forEachKey(parallelismThreshold, transformer2, action3);

		Consumer<? super Object> action4 = null;
		map.forEachValue(parallelismThreshold, action4);

		map.forEachValue(parallelismThreshold, transformer2, action3);

		map.get(key);

		map.getClass();

		Object defaultValue = null;
		map.getOrDefault(key, defaultValue);

		map.hashCode();

		map.isEmpty();

		map.keys();

		map.keySet();

		Object mappedValue = null;
		map.keySet(mappedValue);

		map.mappingCount();

		BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction3 = null;
		map.merge(key, mappedValue, remappingFunction3);

		map.notify();

		map.notifyAll();

		map.newKeySet();

		map.newKeySet(initialCapacity);

		map.putIfAbsent(key, mappedValue);

		map.put(key, mappedValue);

		map.putAll(map);

		map.remove(key);

		BiFunction reducer = null;
		map.reduce(parallelismThreshold, transformer, reducer);

		map.reduceEntries(parallelismThreshold, reducer);

		map.reduceEntries(parallelismThreshold, transformer2, reducer);

		double basis = 0;
		ToDoubleFunction<Entry<String, Object>> transformer3 = null;
		DoubleBinaryOperator reducer2 = null;
		map.reduceEntriesToDouble(parallelismThreshold, transformer3, basis, reducer2);

		IntBinaryOperator reducer3 = null;
		ToIntFunction<Entry<String, Object>> transformer4 = null;
		int basis2 = 0;
		map.reduceEntriesToInt(parallelismThreshold, transformer4, basis2, reducer3);

		long basis3 = 0;
		ToLongFunction<Entry<String, Object>> transformer5 = null;
		LongBinaryOperator reducer4 = null;
		map.reduceEntriesToLong(parallelismThreshold, transformer5, basis3, reducer4);

		map.reduceKeys(parallelismThreshold, reducer);

		BiFunction reducer5 = null;
		map.reduceKeys(parallelismThreshold, transformer2, reducer5);

		ToDoubleFunction<? super String> transformer6 = null;
		DoubleBinaryOperator reducer6 = null;
		map.reduceKeysToDouble(parallelismThreshold, transformer6, basis, reducer6);

		ToIntFunction<? super String> transformer7 = null;
		map.reduceKeysToInt(parallelismThreshold, transformer7, basis2, reducer3);

		ToLongFunction<? super String> transformer8 = null;
		map.reduceKeysToLong(parallelismThreshold, transformer8, basis3, reducer4);

		ToDoubleBiFunction<? super String, ? super Object> transformer9 = null;
		map.reduceToDouble(parallelismThreshold, transformer9, basis3, reducer6);

		ToIntBiFunction<? super String, ? super Object> transformer10 = null;
		map.reduceToInt(parallelismThreshold, transformer10, basis2, reducer3);

		ToLongBiFunction<? super String, ? super Object> transformer11 = null;
		map.reduceToLong(parallelismThreshold, transformer11, basis3, reducer4);

		map.reduceValues(parallelismThreshold, reducer5);

		map.reduceValues(parallelismThreshold, transformer2, reducer5);

		ToDoubleFunction<? super Object> transformer12 = null;
		map.reduceValuesToDouble(parallelismThreshold, transformer12, basis3, reducer6);

		ToIntFunction<? super Object> transformer13 = null;
		map.reduceValuesToInt(parallelismThreshold, transformer13, basis2, reducer3);

		ToLongFunction<? super Object> transformer14 = null;
		map.reduceValuesToLong(parallelismThreshold, transformer14, basis2, reducer4);

		map.remove(key, value);

		map.replace(key, value);

		Object oldValue = null;
		Object newValue = null;
		map.replace(key, oldValue, newValue);

		BiFunction<? super String, ? super Object, ? extends Object> function = null;
		map.replaceAll(function);

		map.size();

		BiFunction searchFunction = null;
		map.search(parallelismThreshold, searchFunction);

		Function searchFunction2 = null;
		map.searchEntries(parallelismThreshold, searchFunction2);

		map.searchKeys(parallelismThreshold, searchFunction2);

		map.searchValues(parallelismThreshold, searchFunction2);

		map.toString();

		map.values();

		map.wait();

		long timeout = 0;
		map.wait(timeout);

		int nanos = 0;
		map.wait(timeout, nanos);
	}
}
