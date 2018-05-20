package com.merlin.multithread.thread004;


/**
 * 锁重入
 * @author merlin
 *
 */
public class SyncDubbo1 {

	public synchronized void method1() {
		System.out.println("method1...");
		method2();
	}

	private synchronized void method2() {
		System.out.println("method2...");
		method3();
	}

	private synchronized void method3() {
		System.out.println("method3...");
	}
	public static void main(String[] args) {
		final SyncDubbo1 sd = new SyncDubbo1();
		Thread th = new Thread(() -> sd.method1());
		th.start(); 
	}
}
