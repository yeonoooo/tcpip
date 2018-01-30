package com.multi.day19;

public class MultiThreadBathTest {
	public static void main(String[] args) {
		BathRoom room = new BathRoom("multicampus 12floor");
		BathroomThread t1 = new BathroomThread(room, "A");
		BathroomThread t2 = new BathroomThread(room, "B");
		BathroomThread t3 = new BathroomThread(room, "C");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
}
