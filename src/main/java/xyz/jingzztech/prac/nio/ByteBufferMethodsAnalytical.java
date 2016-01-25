/**
 * 
 */
package xyz.jingzztech.prac.nio;

import java.nio.ByteBuffer;

/**
 * @author jingzz
 * @time 2015年11月25日 下午3:43:29
 * @func  java NIO包内方法实践类
 * @name NIODemo
 */
public class ByteBufferMethodsAnalytical {
	
	private static ByteBuffer buffer =ByteBuffer.allocate(200) ;
	
	private static ByteBufferMethodsAnalytical nioDemo;

	private ByteBufferMethodsAnalytical() {
	}
	public ByteBuffer getBuffer() {
		return buffer;
	}
	public void setBuffer(ByteBuffer buffer) {
		this.buffer = buffer;
	}
	public static ByteBufferMethodsAnalytical getIns(){
		if (nioDemo == null) {
			nioDemo.buffer = nioDemo.buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
		}
		return nioDemo;
	}
	
	/*
	 * 缓冲区使用了构建器模式串联各个方法。
	 * 
	 * 缓冲区产生的目的就是为了提高数据的传输效率
	 * 
	 * 缓冲区四种属性： 容量（Capacity）、上界（limit）、位置（Position）、标记（mark）
	 * 容量：缓冲区能够容纳的数据元素的最大数量，该容量在创建时设定，一旦设定，不可被修改。
	 * 上界：缓冲区第一个不可读的元素，也可以说是现存元素的计数
	 * 位置：下一个要被读或者写的元素的索引，位置会由get和put方法更新
	 * 标记：一个备忘位置,调用mark()方法设定mark = position ,调用reset() 设定 position = mark。标记在设定前是未定义的。
	 * 
	 *  四个属性的大小关系为:
	 *  0 <= mark <= position <= limit <= capacity
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	public static void test(String[] args) {
		
		buffer.array();
		
		buffer.arrayOffset();
		
		buffer.asCharBuffer();
		
		buffer.asDoubleBuffer();
		
		buffer.asFloatBuffer();
		
		buffer.asIntBuffer();
		
		buffer.asLongBuffer();
		
		buffer.asReadOnlyBuffer();
		
		buffer.asShortBuffer();
		
		int capacity = 100;
		buffer.allocate(capacity);
		
		buffer.allocateDirect(capacity);
		
		/*
		 * 将 position 置为 0;  limit 置为容器大小; mark = -1;
		 * 当然没有删除原来已经含有的数据，但确实访问不到了，在填充数据时会将原来的数据覆盖掉
		 */
		buffer.clear();
		
		buffer.capacity();
		
		buffer.compact();
		
		/**
		 * 比较两个ByteBuffer。this 和 that
		 * 
		 * 返回结果：this 小于that ，返回负数；
		 * this 等于that，返回0；
		 * this 大于 that ，返回整数。
		 * 返回的数字大小就是一般是this和that中第一个不同元素的ASCII的差值。如果所有值都相等，那么返回的值就是this和that剩余元素的差值。
		 * 
		 * 不允许不同对象间进行比较，如果传递了类型错误的对象，会抛出ClassCastException异常
		 * 
		 * 两个缓冲区比较是对剩余元素进行的，直到不相等的元素被发现或者到达limit上限。
		 * 如果一个缓冲区在不相等元素发现前，剩余元素被耗尽，该缓冲区被认为小于另一个缓冲区。
		 * 
		 * 该方法的比较是不可交换的，因为this.compareTo(that)如果获取到负值，那that.compareTo(this) 返回的就是正值了。
		 * 
		 */
		buffer.compareTo(buffer);
		
		buffer.duplicate();
			
		/**
		 * 两个缓冲区相等需要满足三个条件：
		 * 1，相同的元素类型
		 * 2，拥有相同数量的剩余元素（Buffer容量不需要相同，缓冲区中剩余数据的索引也不必相同）
		 * 3，在每个缓冲区中应被get()方法返回的数据元素序列必须一致
		 * 
		 * 以上条件可以在两个拥有不同属性的缓冲区可能相等，两个相似的缓冲区，甚至看起来完全相同的缓冲区不一定相等。
		 * 
		 */
		buffer.equals(buffer);
		
		/**
		 * 将limit设置为position，position设置为0
		 */
		buffer.flip();
		
		/**
		 * 缓冲区批量移动有两种方式：将一个数组作为参数，然后将缓冲区数据释放到数组中；
		 * 另一个是使用offset和length参数指定目标数组的子区间，截取移动缓冲区数据的一部分。
		 */
		
		/**
		 * 记得在调用该方法前先查询缓冲区内元素的数量。
		 * 调用get()方法会向前移动position属性，所以之后调用remaining()会返回0
		 */
		buffer.get();
		
		buffer.get(capacity);
		
		buffer.getInt();
		
		int length = 0;
		int offset = 0;
		byte[] dst = null;
		/**
		 * 获取指定长度的数据元素
		 */
		buffer.get(dst, offset, length);
		
		/*
		 *注意：buffer.get(dst);当传入的 一个数组没有指定长度，相当于要求整个数据被填充，而此时如果缓冲区内的元素不足以将数组填充满，
		 *程序就会抛出异常
		 */
		
		
		buffer.get(dst);
		
		buffer.getChar();
		
		int index = 10;
		buffer.getChar(index);
		
		buffer.getClass();
		
		buffer.getDouble();
		
		buffer.getDouble(index);
		
		buffer.getFloat();
		
		buffer.getFloat(index);
		
		buffer.getInt(index);
		
		buffer.getLong();
		
		buffer.getLong(index);
		
		buffer.getShort();
		
		buffer.getShort(index);
		
		buffer.hasArray();
		
		buffer.hashCode();
		
		buffer.hasRemaining();
		
		buffer.isDirect();
		
		buffer.isReadOnly();
		
		buffer.limit();
		
		int newLimit = 10;
		buffer.limit(newLimit);
		
		/**
		 * 使得缓冲区能够记住一个位置，并在之后将其返回
		 */
		buffer.mark();
		
		buffer.order();
		
		buffer.order(null);
		
		int newPosition = 0;
		buffer.position(newPosition);
		
		/**
		 * 相当于 put(src, 0, src.length)，因为内部调用的就是该方法
		 */
		buffer.put(dst);
		
		buffer.position();
		
		buffer.put((byte)'2');
		
		ByteBuffer src = null;
		/**
		 * 将数据在两个缓冲区之间批量传递
		 * buffer是target 缓冲区，参数引用是src缓冲区
		 * 
		 * 内部使用了for循环将src内的元素存储在buffer中，而存储过程是调用的put(byte)方法
		 * 
		 * 当然在传递之前会检查各种条件是否成立,比如：
		 * 1，src不能是target自身
		 * 2.，target不能是只读属性
		 * 3，src.remaining()的大小不能大于target.remaining();
		 * 等等
		 */
		buffer.put(src);
		
		byte b = 0;
		/**
		 * 为指定位置index赋值为b
		 */
		buffer.put(index, b);
		
		buffer.put(null, offset, length);
		
		char value = 0;
		buffer.putChar(value);
		
		buffer.putChar(index, value);
		
		double value1 = 0;
		buffer.putDouble(value1);
		
		buffer.putDouble(index, value1);
		
		float value2 = 0;
		buffer.putFloat(value2);
		
		buffer.putFloat(index, value2);
		
		
		int value3 = 0;
		buffer.putInt(value3);
		
		buffer.putInt(index, value3);
		
		long value4 = 0;
		buffer.putLong(value4);
		
		buffer.putLong(index, value4);
		
		short value5 = 0;
		buffer.putShort(value5);
		
		buffer.putShort(index, value5);
		
		/**
		 * 不改变limit，将position置为0，将mark置为-1
		 */
		buffer.rewind();
		
		/**
		 * 返回缓冲区中剩余未读取的元素，取值为limit - position
		 */
		buffer.remaining();
		
		/**
		 * 将缓冲区当前的position还原到标记位置mark，
		 * 在调用之前必须确保已经设定过mark，否则会抛出异常InvalidMarkException
		 * 
		 * reset与clear区别是：reset是将元素位置还原到原来标记的位置；而clear是将position置为0，将清空缓存区
		 */
		buffer.reset();
		
		buffer.slice();
		
		buffer.toString();
		
		buffer.wrap(dst);
		
		buffer.wrap(null, offset, length);
		
		ByteBuffer flipReset = flipReset();
		//在buffer使用flip翻转两次后，调用get方法会报 java.nio.BufferUnderflowException异常
//		flipReset.get();
		//调用put方法会报java.nio.BufferOverflowException异常
//		flipReset.put((byte)'h');
	}
	
	//将buffer清零
	public  static ByteBuffer flipReset(){
		ByteBufferMethodsAnalytical nioDemo = ByteBufferMethodsAnalytical.getIns();
		ByteBuffer byteBuffer = nioDemo.getBuffer();
		System.out.println(byteBuffer.toString());
		
		/*
		 * 翻转（flip方法）一次，buffer从能够输入元素的填充状态转为释放状态
		 */
		byteBuffer.flip();
		System.out.println(byteBuffer.toString());
		/**
		 * 翻转两次后，buffer的位置和上界都会置为0，任何的get和put元素的方法都会产生异常
		 */
		byteBuffer.flip();
		System.out.println(byteBuffer.toString());
		return byteBuffer;
	}
}
