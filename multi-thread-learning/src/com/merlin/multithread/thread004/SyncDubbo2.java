package com.merlin.multithread.thread004;


/**
 * 
 * @author merlin
 *
 */
public class SyncDubbo2 {

	static class Main{
		public int i = 10;
		public synchronized void operationSup() {
			try {
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sub extends Main{
		public synchronized void operationSub() {
			try {
				while(i > 0) {
					i--;
					System.out.println("Sub print i = " +i);
					Thread.sleep(100);
					this.operationSup();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {

		Sub sub = new Sub();
		Thread th = new Thread(( ) -> sub.operationSub());
		th.start();
	}
}
