package com.multi.day19;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class FileCompareUtil {

	ArrayList<String> compareFile(String fstFileName, String scdFileName) throws Exception {
		ArrayList<String> result = new ArrayList<>();

		FileReader fr1 = null;
		FileReader fr2 = null;
		LineNumberReader lnr1 = null;
		LineNumberReader lnr2 = null;

		fr1 = new FileReader(fstFileName);
		lnr1 = new LineNumberReader(fr1);
		fr2 = new FileReader(scdFileName);
		lnr2 = new LineNumberReader(fr2);

		while (true) {
			String s1 = lnr1.readLine();
			String s2 = lnr2.readLine();
			if (s1 == null) break;
			if (!(s1.equals(s2))) {
				String sbuf = "LINE "+lnr1.getLineNumber()+": "+s2;
				result.add(sbuf);
			}
		}
		
		if(lnr1!=null) lnr1.close();
		if(lnr2!=null) lnr2.close();
		if(fr1!=null) fr1.close();
		if(fr2!=null) fr2.close();
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		FileCompareUtil fcu = new FileCompareUtil();
		File f1 = new File("file1.txt");
		File f2 = new File("file2.txt");
		ArrayList<String> list = fcu.compareFile(f1.getAbsolutePath(), f2.getAbsolutePath());
		for (String s : list) {
			System.out.println(s);
		}
	}
}
