package com.merlin.multithread.thread001;


/**
 * 多个线程多个锁：多个线程，每个线程都可以拿到自己制定的锁，分别获得锁之后，
 * 执行synchronized方法体中的内容。
 * @author Merlin
 *
 */
public class MultiThread {

	//可以通过static 关键字，对类上锁
	   
	private int num = 0;
	
	public synchronized void printNum(String tag) {
		
		try {
			if(tag.equals("a")) {
				num = 100;
				System.out.println("tag a, set num over!");
				Thread.sleep(1000);
			}else {
				num = 200;
				System.out.println("tag b, set num over!");
			}
			
			System.out.println("tag " + tag + ", num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//注意观察run方法输出顺序
	public static void main(String[] args) {
		//两个不同的对象
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();
		
		Thread t1 = new Thread(() -> m1.printNum("a"));
		Thread t2 = new Thread(() -> m2.printNum("b")); 
		
		t1.start();
		t2.start();
		
	}
	
	/**
	 * 示例总结：
	 * 关键字synchronized 取得的锁都是对象锁，而不是一段代码（方法）当做锁。
	 * 所以示例代码中的那个线程先执行synchronized关键字的方法，那个线程就持有该方法
	 * 所属对象的锁(Lock),两个对象，线程获得的就是好两个不同的锁，他们互不影响。
	 * 有一种情况则是相同的锁，即在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）
	 */
}
