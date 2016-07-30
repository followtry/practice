package com.yonyou.test;

import java.util.ArrayDeque;
import java.util.Collection;

public class ArrayDequeTest {
	
	 transient Object[] elements;
	
	public static void main(String[] args) {
		/**
		 * 内部属性包括
		 * Object[] elements 存储数据
		 * int head 队首位置索引
		 *  int tail 队尾位置索引
		 *  MIN_INITIAL_CAPACITY = 8; 默认最小初始化大小
		 *  使用默认构造方法创建初始大小为16的Object[]数组
		 *  队列不能存储null
		 */
		ArrayDeque<String> deque = new ArrayDeque<String>();
		String e="2";
		
		//The main insertion and extraction methods are addFirst,
	    // addLast, pollFirst, pollLast. The other methods are defined in
	    // terms of these
		//主要的插入和抽取的方法是addFirst，addLast，poolFirst，pollLast，其他方法都是依照这些方法定义的。
		/**
		 * tail = (tail + 1) & ( .length - 1) 取两者相与之后的值
		 * 因为elements.length经过内部计算扩容后，二进制方式永远都是连续的1，因此获得的值大部分都是tail+1
		 * 只有在需要扩容时，tail才等于0；进行双倍扩容
		 */
		/**
		 * 调用公共方法 addLast(e);总是返回true;
		 * 因为是语义是数组双队列，因此是作为队列使用。该方法是在队尾添加元素。
		 */
		deque.add(e);
		/**
		 * elements[tail] = e; 将元素放在tail的索引位置，并判断是否tail和head相等，如果相等则进行双倍扩容。
		 * doubleCapacity()是内部私有方法。
		 * doubleCapacity 将队列未读方法放在最前，将已经读的数据放在未读数据之后。
		 * head=0;tail=elements.length(原数组长度)
		 * 
		 */
		deque.addLast(e);
		
		/**
		 * 方法与addLast类似，差别是addLast中元素放在tail索引位置，addFirst中元素放在head索引位置。
		 * TODO head虽然语义上表示头部，但在数组存储中是从后向前存储，直到和tail相等，然后调用doubleCapacity()方法，
		 * 将head以后的元素放在新数组的最前面位置，0-tail的元素放在新数组的后半部分。然后展示的新的内容就好像是
		 * addFirst真的是从数组第一个依次插入的。
		 * 因为该队列是双端的，因此可以认为该数组的操作是首尾相接的，以0的位置为开始点，即环形的。在语义上也就没有了后端插入head数组的矛盾。
		 */
		deque.addFirst(e);
		
		/**
		 * 双端队列判空标准就是head和tail是否相等。
		 */
		deque.isEmpty();
		
		/**
		 * 调用AbstractCollection的toString方法，但迭代方法是自定义实现的new DeqIterator();
		 * 在宏观上还是从head-> tail，但在微观上head游标位置的变化是通过cursor = (cursor + 1) & (elements.length - 1)实现的。
		 * 因此虽然存储方式不是从前到后，但通过cursor索引位置转换为字符串时就会成为符合人们思想的从前到后了。
		 * 自我感觉这是很棒的一种实现思想。
		 */
		deque.toString();
		
		Collection<? extends String> c=new ArrayDeque<String>();
		/**
		 * 内部使用foreach迭代添加集合c中的元素，虽然在添加时有判断是否添加成功，只要有一个添加成功就返回true;
		 * 但根据add(e)的机制来说，除非是NullPointer异常，否则永远返回true；
		 * 该方法是非线程安全的，即在添加过程中其他线程对集合c进行修改二addAll是不知道的。
		 */
		deque.addAll(c);
		
		/**
		 * 内部调用poolFirst方法
		 * 该方法等同于removeFirst，与poll的不同之处仅仅是该方法在元素为null，抛出无此元素异常
		 */
		deque.remove();

		/**
		 * 等同于remove()
		 */
		deque.removeFirst();
		
		/**
		 * 等同于removeFirst方法
		 */
		deque.pop();
		
		/**
		 * 该方法获取head所在位置元素，如果元素不存在返回null；如果存在返回元素，并将head位置置为null；head后移一位
		 */
		deque.poll();
		
		/**
		 *  等同于pollFirst
		 */
		deque.pollFirst();
		
		/**
		 * 从head到tail查找元素e，如果元素e存在，将该元素删除并返回true。当然因为是数组操作，所以需要相应的移动复制数组。
		 * 从名字上可以看出来是只删除第一个匹配成功的元素。
		 */
		deque.removeFirstOccurrence(e);
		/**
		 * 等同于removeFirstOccurrence(e)
		 */
		deque.remove(e);
		
		/**
		 * 类似于pollLast，但不同点仅仅是removeLast在删除元素为null时，会抛出NoSuchElementException。
		 */
		deque.removeLast();
		
		/**
		 * 找到tail所在位置并删除元素，返回元素或者null
		 */
		deque.pollLast();
		
		/**
		 * 与removeFirstOccurrence类似，不同点仅仅是该方法是从tail到head,而removeFirstOccurrence是从head到tail。
		 * int i = head; 				<-> 		int i = (tail - 1) & mask;
		 * i = (i + 1) & mask;     <-> 		i = (i - 1) & mask;
		 *  实现索引位置变化，仅仅以上两点不同而已
		 *  
		 *  在内部删除时调用delete方法，暂时还未看懂
		 */
		deque.removeLastOccurrence(e);
		
		/**
		 * 初始化deque迭代器，while循环迭代匹配每个元素是否存在于集合c中，如果存在将其从deque中删除。
		 * 只要有一个元素移除成功，就会返回true；
		 */
		deque.removeAll(c);
		
		/**
		 * 与removeAll正好相反，只要元素不存在集合c中，就将其移除。
		 * 与remove仅仅在!c.contains(it.next())有区别
		 */
		deque.retainAll(c);
		
		/**
		 * 从head到tail将每个元素位置为null；
		 * TODO 疑问： 既然要把所有的元素位置置为null，为什么不按照数组顺序从前向后依次置空呢？
		 * 自我解答：或许是因为在存储数组elements中有些元素没有存储数据本来就是null，而不需要操作。
		 */
		deque.clear();
		
		/**
		 * 新建ArrayDeque对象result，并将复制的元素数组赋值给result.elements
		 * 使用Arrays.copyOf复制
		 */
		deque.clone();
		
		/**
		 * 从head到tail循环查找元素e，该元素存在返回true，否则返回false；
		 */
		deque.contains(e);
		
		/**
		 * foreach遍历集合每个元素，并调用contains判断deque中是否存在，只有在所有元素都存在才返回true；
		 * 否则只要有一个不存在立即返回false,不再向下判断。
		 */
		deque.containsAll(c);
		
		/**
		 * 内部new DescendingIterator()对象，生成倒叙遍历的迭代器。
		 */
		deque.descendingIterator();
		
		/**
		 * 调用内部方法copyElements(Object[] a);
		 * 如果head<tail;则直接复制head到tail区间元素到新的数组
		 * 如果head>tail 则先复制head到数组结尾的元素到新数组，然后再复制0->tail的元素紧随其后。
		 */
		deque.toArray();
		
		Object[] a=new Object[]{};
		/**
		 * 该方法底层和toArray()调用相同方法copyElements(Object[] a),只不过该方法会自己实例化新的数组对象。
		 */
		deque.toArray(a);
		
		/**
		 * 返回但是不移除查询到的元素，等同于peekLast方法；
		 */
		deque.peek();
		
		/**
		 * 返回head位置的元素
		 */
		deque.peekFirst();
		
		/**
		 * 返回tail位置的元素
		 */
		deque.peekLast();
		
		/**
		 * 等同于addFirst方法 addFirst(e);
		 */
		deque.push(e);
		
		/**
		 * 在队列元素上建立一个迟绑定(多态)和快速失败的spliterator迭代器
		 * 会实例化new DeqSpliterator(this, -1, -1);对象
		 */
		deque.spliterator();
		
		/**
		 * 等同于offerLast
		 */
		deque.offer(e);
		
		/**
		 * 等同于add(e)方法；
		 */
		deque.offerLast(e);

		/**
		 * 等同于addFirst(e)方法；
		 */
		deque.offerFirst(e);
		
		/**
		 * 获取第一个元素head，不存在返回NoSuchElementException
		 */
		deque.getFirst();
		
		/**
		 * 获取最后一个元素tail，不存在返回NoSuchElementException
		 */
		deque.getLast();
		
		/**
		 * 等同于getFirst
		 */
		deque.element();
		
		/**
		 * 通过this==e 判断两个队列是否相等。只要不是指向同一个堆栈，即返回false；
		 */
		deque.equals(e);
		
		/**
		 * 直接调用系统原生方法
		 */
		deque.hashCode();
		
		/**
		 * 实例化new DeqIterator()迭代器
		 */
		deque.iterator();
		
		
		/**
		 * 返回 (tail - head) & (elements.length - 1);
		 */
		deque.size();
		
		 
	   /* *
	    * 扩容算法分析
	    * private void doubleCapacity() {
	        assert head == tail;  //此处断言head==tail
	        int p = head;    
	        int n = elements.length;
	        int r = n - p; // number of elements to the right of p //head索引右面所有的元素
	        int newCapacity = n << 1;  //右移1位，即增大2倍
	        if (newCapacity < 0)  //如果右移丢失的最前面的1，导致所有位上的数值都是0
	            throw new IllegalStateException("Sorry, deque too big");
	        Object[] a = new Object[newCapacity]; //新建newCapacity大小的Object[]数组
	        System.arraycopy(elements, p, a, 0, r); //将未读元素复制到新数组前面
	        System.arraycopy(elements, 0, a, r, p); //将已读元素复制在未读数组后面
	        elements = a;
	        head = 0;
	        tail = n;
	    }*/
		ArrayDeque<String> deque2= new ArrayDeque<String>();
		for (int i = 0; i < 18; i++) {
			deque2.add(""+i);
		}
		System.out.println(deque2.toString());
		for (int i = 0; i < 3; i++) {
			deque2.addFirst(i+"-");
		}
		System.out.println(deque2.toString());
	}
}
