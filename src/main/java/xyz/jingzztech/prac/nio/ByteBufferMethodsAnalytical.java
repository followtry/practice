/**
 * 
 */
package xyz.jingzztech.prac.nio;

import java.nio.ByteBuffer;

import org.apache.log4j.helpers.BoundedFIFO;
import org.junit.experimental.theories.Theories;

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
	 * 缓冲区使用了构建器模式串联各个方法
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
		
		buffer.compareTo(buffer);
		
		buffer.duplicate();
		
		/**
		 * 两个缓冲区相等需要满足三个条件：
		 * 1，相同的元素类型
		 * 2，拥有相同数量的剩余元素
		 * 3，这两个剩余元素序列，它们的起始位置单独考虑，逐点相同
		 */
		buffer.equals(buffer);
		
		/**
		 * 将limit设置为position，position设置为0
		 */
		buffer.flip();
		
		buffer.get();
		
		buffer.get(capacity);
		
		buffer.getInt();
		
		int length = 0;
		int offset = 0;
		byte[] dst = null;
		buffer.get(dst, offset, length);
		
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
		
		buffer.put(dst);
		
		buffer.position();
		
		buffer.put((byte)'2');
		
		ByteBuffer src = null;
		buffer.put(src);
		
		byte b = 0;
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
