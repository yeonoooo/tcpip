package com.multi.day19;

public class MyUpperClass extends Thread{
	
	public MyUpperClass() {
		System.out.println("MyUpperClass »ý¼º");
	}

	@Override
	public void run() {
		for(char ch = 'A'; ch<='Z';ch++) {
			System.out.println(currentThread().getName()+": "+ch);
		}
	}
	
}
