package com.multi.day19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOTest2 {
	public static void main(String[] args) {
		// 1byte씩읽었어 >> 한글 깨져

		// InputStream is = System.in;
		/*
		 * InputStreamReader ir = new InputStreamReader(is); 
		 * int i; 
		 * while(true) 
		 * { i= ir.read(); 
		 * if(i ==13) break;// (char)13 = enter 
		 * System.out.print((char)i); }
		 */
		
		InputStream is = null;
		Scanner sc = null;
		try {
			is = new FileInputStream("src/com/multi/day19/EnumTest.java");
			sc = new Scanner(is);
			while (true) {
				String s = sc.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
		} catch (NoSuchElementException e) {
		} finally {
			if (is != null)
				try { is.close();
				} catch (IOException e) {}
			if (sc != null)
				sc.close();
		}

	}
}
