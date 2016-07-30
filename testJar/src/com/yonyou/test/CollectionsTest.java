package com.yonyou.test;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Random;
import java.util.SortedMap;
	
public class CollectionsTest {

	public static void main(String[] args) {
		Collection<? super Object> c=null;
		Object elements=null;
		
		/**
		 * 调用集合c的add方法将elements中每个元素添加到集合c中。
		 * 该便利方法的行为和c.addAll(Arrays.adList(o))相同，但是该方法在大多数实现下运行更快
		 */
		Collections.addAll(c, elements);
		
		Deque<Object> deque=null;
		/**
		 * 将deque转换为后进先出(Lifo)的双端队列deque；
		 * add -> push;
		 * remove -> pop;
		 * 在你请求一个deque，但是你需要该队列后进先出的顺序时，该视野是很有帮助的。
		 * 内部会实例化 new AsLIFOQueue<>(deque)对象。
		 */
		Collections.asLifoQueue(deque);
		
		List<? extends Comparable<? super Object>> list=null;
		Object key=null;
		/**
		 * 折半查找,如果list是快速随机访问或者list大小小于临界值5000.
		 * 就调用Collections.indexedBinarySearch(list, key)索引方式去操作，
		 * 否则调用list迭代器方式Collections.iteratorBinarySearch(list, key);去操作。
		 */
		Collections.binarySearch(list, key);
		
		Comparator<? super Object> c2=null;
		
		/**		
			使用二分查找算法在指定的list中搜索对象key，该list必须被comparator升序排序，比如使用方法sort(list,comparator)；
			优先使用该调用，如果没有被排序，结果就没被定义。
			如果list包含多个元素等于key，此处不确定哪一个将会被首先找到。
			该方法是为随机访问列表使用，运行时间为log(n)（近乎恒定时间的位置访问）。
			如果list没有是吸纳RandomAccess接口，并且非常大的话，该方法将会基于迭代器查询，执行时间(O(n)),元素比较O(log n)

		 */
		Collections.binarySearch(list, key, c2);
		
		Class<Object> type=null;
		/**Dynamically typesafe collection wrappers
		 * 动态类型安全集合封装器
		 * 
		 * 检查集合c和类型type不为空
		 */
		Collections.checkedCollection(c, type);
		
		List<Object> list2=null;
		/**
		 * 除了添加了list属性外，其他的赋值，调用，检查与checkedCollection相同
		 */
		Collections.checkedList(list2, type);
		
		Class<Object> keyType=null;
		Class<Object> valueType=null;
		Map<Object, Object> m=null;
		/**
		 *
		 * 与检查collection和list类似，都是使用 Objects.requireNonNull(valueType)检查后将值赋给相应属性
		 */
		Collections.checkedMap(m, keyType, valueType);
		
		NavigableMap<Object, Object> m2=null;
		/**
		 * 除了m2赋值给内部属性，其他同checkedMap相同
		 */
		Collections.checkedNavigableMap(m2, keyType, valueType);
		
		NavigableSet<Object> s=null;
		Collections.checkedNavigableSet(s, type);
		
		Queue<Object> queue=null;
		Collections.checkedQueue(queue, type);
		
		Collections.checkedSet(s, type);
		
		SortedMap<Object, Object> m3=null;
		Collections.checkedSortedMap(m3, keyType, valueType);
		
		Collections.checkedSortedSet(s, type);
		
		Collection<?> c1=null;
		Collection<?> c3=null;
		Collections.disjoint(c1, c3);
		
		Collections.emptyEnumeration();
		
		Collections.emptyIterator();
		
		Collections.emptyList();
		
		Collections.emptyListIterator();
		
		Collections.emptyMap();
		
		Collections.emptyNavigableMap();
		
		Collections.emptyNavigableSet();
		
		Collections.emptySet();
		
		Collections.emptySortedMap();
		
		Collections.emptySortedSet();
		
		Collections.EMPTY_LIST.size();
		
		Collections.EMPTY_MAP.size();
		
		Collections.EMPTY_SET.size();
		
		Object obj=null;
		List<? super Object> list3=null;
		Collections.fill(list3, obj);
		
		Object o=null;
		Collections.frequency(c3, o);
		
		List<?> target=null;
		List<?> source=null;
		Collections.indexOfSubList(source, target);
		
		Collections.lastIndexOfSubList(source, target);
		
		Enumeration<Object> e=null;
		Collections.list(e);
		
		List<String> coll=null;
		Collections.max(coll);
		
		Comparator<? super Object> comp=null;
		Collections.max(coll, comp);
		
		Collections.min(coll);
		
		Collections.min(coll, comp);
		
		int n = 0;
		Collections.nCopies(n, o);
		
		Map<Object, Boolean> map=null;
		Collections.newSetFromMap(map);
		
		Object oldVal=null;
		Object newVal=null;
		List<Object> list4=null;
		Collections.replaceAll(list4, oldVal, newVal);
		
		Collections.reverse(list4);
		
		Collections.reverseOrder();
		
		Comparator<Object> cmp=null;
		Collections.reverseOrder(cmp);
		
		int distance = 0;
		Collections.rotate(list4, distance);
		
		Collections.shuffle(list4);
		
		Random rnd = null;
		Collections.shuffle(list4, rnd);
		
		Collections.singleton(o);
		
		Collections.singletonList(o);
		
		Object value = null;
		Collections.singletonMap(key, value);
		
		Collections.sort(list);
		
		Comparator<Object> c4=null;
		Collections.sort(list4, c4);
		
		int i = 0;
		int j = 0;
		Collections.swap(list4, i, j);
		
		Collections.synchronizedCollection(c);
		
		Collections.synchronizedList(list);
		
		Collections.synchronizedMap(m);
		
		Collections.synchronizedNavigableMap(m2);
		
		Collections.synchronizedNavigableSet(s);
		
		Collections.synchronizedSet(s);
		
		Collections.synchronizedSortedMap(m2);
		
		Collections.synchronizedSortedSet(s);
		
		
		Collections.unmodifiableCollection(c);
		
		Collections.unmodifiableList(list);
		
		Collections.unmodifiableMap(m);
		
		Collections.unmodifiableNavigableMap(m2);
		
		Collections.unmodifiableNavigableSet(s);
		
		Collections.unmodifiableSet(s);
		
		Collections.unmodifiableSortedMap(m2);
		
		Collections.unmodifiableSortedSet(s);
	}

}
