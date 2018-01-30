package com.multi.day19;

import java.io.File;
import java.util.Arrays;

public class IOTest5 {
	public static void main(String[] args) {
		File f = new File("src/com/multi/day19/BathRoom.java");
		File f2 = new File("src/com/multi/day19");
		
		System.out.println("존재 유무: "+f.exists());
		System.out.println("파일 크기: "+f.length());
		System.out.println("쓰기 가능: "+f.canWrite());
		System.out.println("f1 디렉토리 여부: "+f.isDirectory());
		System.out.println("f2 디렉토리 여부: "+f2.isDirectory());
		if(f2.isDirectory()) {
			System.out.println(Arrays.toString(f2.list()));
		}
	}
}
