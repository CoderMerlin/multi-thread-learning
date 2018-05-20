package com.merlin.multithread.thread005;


/**
 * 
 * @author merlin
 *
 */
public class SyncException {

	private int i = 0;
	public synchronized void operation() {
		while(true) {
			try {
				i++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + ", i = " + i);
				if(i == 10) {
					Integer.parseInt("a");
					//throw new RuntimeException();
				}
			} catch (Exception e) {//InterruptedException
				e.printStackTrace();
				System.out.println("log info i = " + i);
				//throw new RuntimException();
				//continue;
			}
		}
	}
	
    public static void main(String[] args) {
		final SyncException se = new SyncException();
		Thread t1 = new Thread(() -> se.operation(),"t1");
		t1.start();
	}
	
}
