package com.multi.day19;

public class MultiThreadTest {
	public static void main(String[] args) {
		
		System.out.println("Main Ω√¿€");
		Thread t1 = new MyUpperClass();
		Thread t2 = new MyUpperClass();
		Thread t3 = new Thread(new MyLowerClass("LowerThread1"));
		Thread t4 = new Thread(new MyLowerClass("LowerThread2"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		for (int i = 1; i <= 26; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}

		System.out.println("Main ≥°");
	}

}
