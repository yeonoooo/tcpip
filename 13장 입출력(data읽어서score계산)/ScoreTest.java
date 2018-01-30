package com.multi.day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

public class ScoreTest {

	public static void getScore() throws Exception {
		File f = new File("data.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String s = br.readLine();
			if (s == null) break;
			Vector<String> vec = new Vector<>();
			String[] sArr = s.split("/");
			for (String str : sArr) {
				vec.add(str);
			}
			if (!(sArr[0].equals("¿Ã∏ß"))) {
				int sum = 0;
				for (int i = 1; i < sArr.length; i++) {
					sum += Integer.parseInt(sArr[i]);
				}
				vec.add(String.valueOf(sum));
				Score score = new Score(vec.get(0), vec.get(1), vec.get(2), vec.get(3), vec.get(4));
				System.out.println(score.toString());
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		getScore();
	}
}
