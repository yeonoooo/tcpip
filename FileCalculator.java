package com.multi.day19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;

public class FileCalculator {

	void addCalculateResult(String inputFileName) throws Exception {
		FileReader fr = null;
		FileWriter fw = null;
		LineNumberReader lnr = null;
		BufferedWriter bw = null;

		fr = new FileReader(inputFileName);
		fw = new FileWriter("FileResult.txt");
		
		lnr = new LineNumberReader(fr);
		bw = new BufferedWriter(fw);
		
		int sum = 0;
		int mul = 1;
		
		while(true) {
			String s = lnr.readLine();
			if(s == null) break;
			int i = Integer.parseInt(s);
			sum += i;
			mul *= i;
			bw.write(s); bw.newLine();			
		}
		bw.write(sum+""); bw.newLine();
		bw.write(mul+""); 
		
		if(lnr!=null) lnr.close();
		if(bw!=null) bw.close();
		if(fr!=null) fr.close();
		if(fw!=null) fw.close();

	}

	public static void main(String[] args) throws Exception {

		FileCalculator c = new FileCalculator();
		File f = new File("calculate.txt");
		c.addCalculateResult(f.getAbsolutePath());
	}
}
