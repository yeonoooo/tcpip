package com.multi.day19;

import java.io.File;
import java.util.Arrays;

public class IOTest5 {
	public static void main(String[] args) {
		File f = new File("src/com/multi/day19/BathRoom.java");
		File f2 = new File("src/com/multi/day19");
		
		System.out.println("���� ����: "+f.exists());
		System.out.println("���� ũ��: "+f.length());
		System.out.println("���� ����: "+f.canWrite());
		System.out.println("f1 ���丮 ����: "+f.isDirectory());
		System.out.println("f2 ���丮 ����: "+f2.isDirectory());
		if(f2.isDirectory()) {
			System.out.println(Arrays.toString(f2.list()));
		}
	}
}
