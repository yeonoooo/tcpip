package com.multi.day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GetSum {

	public void printScore(String fileName) {

		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> list = new ArrayList<>();

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			while (true) {
				String s = br.readLine();
				if (s == null) 	break;

				String[] sArr = s.split("/");
				if (sArr[0].equals("¿Ã∏ß")) {
					s = s.replaceAll("/", "\t") + "\t√—¡°";
				} else {
					int sum = 0;
					for (int i = 1; i < sArr.length; i++) {
						sum += Integer.parseInt(sArr[i]);
					}
					s = s.replaceAll("/", "\t") + "\t" + sum;
				}
				list.add(s);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (br != null)	br.close();
				if (fr != null)	fr.close();
			} catch (IOException e) {
			}
		}

		for (String s : list) {
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		GetSum result = new GetSum();
		File f = new File("data.txt");
		result.printScore(f.getAbsolutePath());
	}

}
