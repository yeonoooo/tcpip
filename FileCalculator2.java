package com.multi.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileCalculator2 {

	void addCalculateResult(String inputFileName) throws Exception {
		FileReader fr = null;
		BufferedReader lnr = null;

		fr = new FileReader(inputFileName);
		lnr = new BufferedReader(fr);
		
		int sum = 0;
		int mul = 1;

		List<String> list = new ArrayList<>();
		
		while(true) {
			String s = lnr.readLine();
			if(s == null) break;
			int i = Integer.parseInt(s);
			sum += i;
			mul *= i;
			list.add(s);		
		}
		list.add(String.valueOf(sum));
		list.add(String.valueOf(mul));
		
		if(lnr!=null) lnr.close();
		if(fr!=null) fr.close();
		
		FileWriter fw = null;
		BufferedWriter bw = null;

		fw = new FileWriter(inputFileName);
		bw = new BufferedWriter(fw);
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i));
			bw.newLine();
		}
		
		if(bw!=null) bw.close();
		if(fw!=null) fw.close();

	}

	public static void main(String[] args) throws Exception {

		FileCalculator2 c = new FileCalculator2();
		File f = new File("calculate.txt");
		c.addCalculateResult(f.getAbsolutePath());
	}
}
