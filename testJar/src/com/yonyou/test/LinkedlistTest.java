/**
 * 
 */
package com.yonyou.test;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Administrator
 *
 */
public class LinkedlistTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 LinkedList<String> list = new LinkedList<String>();
		 
		 String e=null;
		list.add(e);
		list.size();
		String[] a={"2323","234234","243ds"};
		/**
		 * 通过反射获得a的类型并将list中的item赋值给新生成的Object[]数组对象
		 */
		list.toArray(a);
		list.addAll(list);
		/**
		 * //最多查询一般的元素，位于前半部分从前往后查，位于后半部分从后往前查
		 * 因此，位于中间的元素是查询时间最长的
		 */
		list.get(0);
		
		/**
		 * 生成新的new ListItr(index); index=0;
		 */
		list.iterator();
		/**
		 * 取出item元素作为返回值；获取fist的next节点，将
		 * fist.next=null;
		 * first=next; 
		 * next.prev=null;
		 * 修改元素数量size和修改次数
		 */
		list.removeFirst();
		/**
		 * 调用indexOf从前到后循环对比。元素为null也可以
		 */
		list.contains(e);
		/**
		 * 实例化该元素节点newNode，f=first;
		 * newNode.next=f;
		 * first=newNode;
		 * f.prev=newNode;
		 * 
		 */
		list.addFirst(e);
		
		/**
		 * 如果index=size，调用linkLast在最后添加元素，否则调用linkBefore在中间插入元素
		 * 先查找index位置的元素succ，获得该元素的前一节点pred,使用元素e实例化新的节点newNode，
		 * newNode.next=succ;
		 * succ.prev=newNode;
		 * pred.next=newNode;
		 * 占领原来元素的位置，原来的元素相应的向后移动一位。
		 */
		list.add(1, e);
		/**
		 * stringBuffer 通过for循环遍历添加元素 
		 */
		list.toString();
		
		/**
		 * for循环遍历节点，并将节点内的元素item依次赋值给Object[] 并返回该数组；
		 */
		list.toArray();
		
		int fromIndex=0;
		int toIndex=1;
		/**
		 * 存储fromIndex和toIndex作为标记，并以两者之差作为size，
		 * 元素存储和前后元素节点都是借调父类中的结构。
		 */
		list.subList(fromIndex, toIndex);
		
		String element=null;;
		int index=1;
		/**
		 * 使用note(index)搜索到元素所在位置，
		 * 将element赋值给该节点的item，并将原来的值返回。
		 * 该方法的实现还是很简单的。
		 */
		list.set(index, element);
		
		Collection<? extends String> c=null;
		/**
		 * 将集合c中的元素转化为数组后Object[] a;
		 * 根据index获取节点succ，pred=succ.prev;
		 * foreach 循环遍历数组a，将每个元素实例化note对象，并使得第一个对象的prev为pred;
		 * 依次将遍历新生成的对象链接在一起，并将最后一个元素的next=succ;
		 */
		list.addAll(index, c);
		
		/**
		 * 调用linkLast方法在list的最后添加上元素
		 */
		list.addLast(e);
		
		/**
		 * for循环所有的note节点的prev，next和item置为null;
		 * 并且将first和last节点也置为null
		 * 虽然这不是必须的，但这样做有利于GC释放垃圾内存。
		 */
		list.clear();
		
		/**
		 * 通过superClone获得LinkedList对象clone，并对其进行初始化，
		 * for循环取得每个note的item并通过list的add方法将其加入到新创建的clone中
		 * 将clone返回。
		 */
		list.clone();
		
		/**
		 * foreach循环遍历c的每个元素并调用contains方法检测元素是偶在list中，只要有一个不存在其中就返回false；
		 * 只有在集合c中的元素都存在list中才返回true；
		 */
		list.containsAll(c);
		
		/**
		 * 实例化Linkedlist的内部私有类new DescendingIterator();而该类属性为ListItr itr是从最后一个节点开始向前遍历。
		 * 虽然赋值的变量调用的hasNext和next,但内部的itr却是调用的hasPrevious()和previous();通过这种方式实现该方法名称
		 * 的倒序迭代遍历。
		 */
		list.descendingIterator();
		
		/**
		 * 通过调用getFirst();获取list的第一个节点的item值
		 */
		list.element();
		
		/**
		 * 参数虽然指定的是Object类型，但如果传入的对象不是List类型，则会直接返回false;
		 * 否则会将list与参数e都迭代化，通过while循环，对比每一个节点和节点的元素值，只要有一个不相等就返回false；
		 * 当两个比较的节点都为null时，当前比较为true，进行下一元素比较，否则比较两个元素的值是否相等，不相等就直接返回false;
		 * 如果在while循环阶段都能相等，最后当一个lis中再无元素时，判断另一个元素有元素返回false，也无元素返回true；
		 */
		list.equals(e);
		
		/**
		 * 将集合list迭代化，while循环list中的每个元素是否存在于集合c中，如果存在则保留，如果不存在则删除；
		 * 需要注意的是：该方法是保留集合list和集合c的交集元素。
		 */
		list.retainAll(c);
		
		/**
		 * 删除list的最后一个节点，调用unlinkLast(note),note设置为last，在unlinkLast内部将note的item和next都置为null(利于GC回收内存)
		 * 如果其prev=null;表明该list只有一个节点。否则将其前一节点的next置为null;
		 */
		list.removeLast();
		
		/**
		 * 获取最后一个元素，将last的item返回；
		 */
		list.getLast();
		
		/**
		 * 仅仅通过判断list的size是否为0；
		 */
		list.isEmpty();
		
		/**
		 * 获取第一个元素，将first的item返回
		 */
		list.getFirst();
		
		/**
		 * 计算公式
		 * 
		 *  int hashCode = 1;
        	for (E e : this)
            	hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
		 */
		list.hashCode();
		
		/**
		 * 在list的元素集合上创建一个迟绑定(多态)和快速失败的Spliterator
		 * 该方法会返回一个新创建的LLSpliterator对象，而该对象是Spliterators.IteratorSpliterator的一个变体。
		 */
		list.spliterator();
		
		/**
		 *从后向前删除与指定元素e第一个匹配成功的元素，并将其删除。当查找到对应元素时，调用内部方法unlink(x);进行删除。
		 */
		list.removeLastOccurrence(e);
		
		/**
		 * 从前向后删除与指定元素e第一个匹配成功的元素，并将其删除。内部调用remove方法，本质上来说，这两个方法只是同一操作的
		 * 不同调用名称而已。
		 */
		list.removeFirstOccurrence(e);
		
		/**
		 * 通过while循环，迭代匹配list中的元素是否存在于集合c中，如果存在(不管存在一次或多次)都将其从list中移除。
		 */
		list.removeAll(c);
		
		/**
		 * 与removeFirstOccurrence方法的功能相同，删除的元素只能为单个对象不能是集合。方法内部会将null值和其他值分别
		 * 做匹配操作。一旦匹配成功，就将其从list中删除。
		 */
		list.remove(e);
		/**
		 * 通过note(index)取到index位置的元素，然后调用内部方法unlink将该元素移除
		 */
		list.remove(index);
		
		/**
		 * 内部直接调用removeFirst();也是直接删除list中第一个元素。
		 */
		list.remove();
		
		/**
		 * 内部调用addFirst，然后再内部调用linkFirst将元素e添加到list的头部。
		 * 即pred=first;
		 * first=e;
		 * pred.prev=first;
		 * first.next=pred;
		 * 该方法可以作为入栈方法使用
		 */
		list.push(e);
		
		/**
		 * 获取到头元素并将其移除list中，该方法可以作为出栈方法使用
		 */
		list.poll();
		
		/**
		 * 内部实现与poll()相同
		 */
		list.pollFirst();
		
		/**
		 * 移除尾元素
		 */
		list.pollLast();
		
		/**
		 * 获取头元素，但与poll不同的是，在返回元素的同时该元素不会从list中删除
		 */
		list.peekFirst();
		
		/**
		 * 获取list的尾元素，同样也不会删除该元素。
		 */
		list.peekLast();
		
		/**
		 * 与peekFirst内部实现相同
		 */
		list.peek();
		
		/**
		 * 内部调用addLast(e)方法，因此与其实现相同。而不管执行结果怎样，都会返回true；
		 */
		list.offerLast(e);
		
		/**
		 * 内部调用addFirst(e)方法，实现与其相同。总是返回true
		 */
		list.offerFirst(e);
		
		/**
		 * 内部调用add(e)方法，而在add内部又调用 linkLast(e)因此，与所有最终调用的方法相同。
		 * add(e);addLast(e);offerLast(e)效果相同
		 */
		list.offer(e);
		
		/**
		 * 内部调用removeFirst方法，因此与其实现相同。而在语义上使得list作为出栈使用方法更合适
		 */
		list.pop();
		
		/**
		 * 从前往后遍历所有元素，没访问一个元素index+1，直到找到第一个匹配元素，返回index位置;
		 * 
		 */
		list.indexOf(e);
		
		/**
		 * 与indexOf，但是从最后一个元素向前遍历，并返回第一个匹配到的元素的index位置。
		 */
		list.lastIndexOf(e);
		
		/**
		 * 内部调用listIterator(index);但index=0
		 */
		list.listIterator();
		
		/**
		 * 实例化new ListItr(index);，ListItr是Linkedlist内部list迭代类，实现ListIterator接口
		 */
		list.listIterator(index);
		
	}
}
