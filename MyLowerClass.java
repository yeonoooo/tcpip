package com.multi.day19;

public class MyLowerClass implements Runnable {
	String name;

	public MyLowerClass(String name) {
		System.out.println("MyLowerClass����");
		this.name = name;
	}

	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			// System.out.println(Thread.currentThread().getName()+": "+ch); // �����ڷ� name�� ����
			System.out.println(name + ": " + ch);
		}
	}

}
