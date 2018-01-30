package com.multi.day19;

public class MyLowerClass implements Runnable {
	String name;

	public MyLowerClass(String name) {
		System.out.println("MyLowerClass생성");
		this.name = name;
	}

	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			// System.out.println(Thread.currentThread().getName()+": "+ch); // 생성자로 name을 받음
			System.out.println(name + ": " + ch);
		}
	}

}
