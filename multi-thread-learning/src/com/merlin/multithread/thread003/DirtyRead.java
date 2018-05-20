package com.merlin.multithread.thread003;

public class DirtyRead {
	
	//初始值
	private String username = "zhangsan";
	private String password = "123";
	
	
	/**
	 *  如果不加synchorized，则会出现脏读
	 * @param username
	 * @param password
	 */
	public void setValue(String username,String password) {
		this.username = username;
		try {
			Thread.sleep(2000); //睡眠两秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue 最终结果：username = " + username + " ,password = " +password );
	}
	
	public synchronized void getValue() {
		System.out.println("getValue 得到结果：username = " + this.username + ",password = " + this.password);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(() -> dr.setValue("merlin", "456"));
		t1.start();
		Thread.sleep(1000);
		
		dr.getValue();
	}

	
	//ACID
}
