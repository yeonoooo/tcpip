package com.multi.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Date;

public class BufferedReaderTest {
	// fire reader/writer
	public static void method1() {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("src/com/multi/day19/Account.java");
			fw = new FileWriter("Account.java");
			while (true) {
				int data = fr.read();
				if (data == -1)
					break;
				fw.write(data);
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// buffered reader/writer >> ���پ� �а� ����
	public static void method2() {
		FileReader fr = null;
		FileWriter fw = null;
		// �� ���� ���϶����� ��ٷȴ� �ѹ��� ���� >> ���������� �� ȿ����
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader("src/com/multi/day19/Account.java");
			fw = new FileWriter("Account2.java");

			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			while (true) {
				String s = br.readLine();
				if (s == null)
					break;
				bw.write(s);
				bw.newLine(); // enter�� �ν����� ����
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void method3() {
		FileReader fr = null;
		FileWriter fw = null;
		// �� ���� ���϶����� ��ٷȴ� �ѹ��� ���� >> ���������� �� ȿ����
		LineNumberReader lnr = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader("src/com/multi/day19/Account.java");
			fw = new FileWriter("Account3.java");

			lnr = new LineNumberReader(fr);
			bw = new BufferedWriter(fw);

			while (true) {
				String s = lnr.readLine();
				if (s == null)
					break;
				bw.write(s);
				bw.newLine(); // enter�� �ν����� ����
				System.out.println(lnr.getLineNumber() + s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (lnr != null)
					lnr.close();
				if (bw != null)
					bw.close();
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void method4() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("PrintWriterOutput.txt");
			pw.write(100); //����
			pw.println(); 
			pw.println(100+200); // ����. ���� �� �Էµ�.
			pw.write("����");
			pw.print("�ڹ� 200\n");
			pw.printf("%d%n", 300+200);
			pw.write("2018.01.08"); pw.println();
			pw.printf("%s%n", 20180108);
			Date d = new Date();
			pw.printf("%tY�⵵ %tm�� %td��%n", d,d,d);
			System.out.printf("%tY�⵵ %tm�� %td��", d,d,d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

	public static void main(String[] args) {
		// method1();
		// System.out.println("======================================");
		// method2();
		// System.out.println("======================================");
		method4();
	}
}
