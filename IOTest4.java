package com.multi.day19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOTest4 {
	public static void method1() {
		// 기본형 datatype을 입출력 (boolean이면 boolean으로 출력)
		// filewrite >> char[], String으로 인식

		FileOutputStream fo = null;
		DataOutputStream dos = null;

		try {
			fo = new FileOutputStream("aa.dat"); // .dat 파일은 user가 읽을수없는 파일 형태
			dos = new DataOutputStream(fo);
			dos.writeInt(100);
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
			dos.writeUTF("문자");
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
			}
			try {
				if (fo != null)
					fo.close();
			} catch (IOException e) {
			}
		}
	}

	public static void method2() {

		FileInputStream fi = null;
		DataInputStream dis = null;

		try {
			fi = new FileInputStream("aa.dat"); // .dat 파일은 user가 읽을수없는 파일 형태
			dis = new DataInputStream(fi);
			int i = dis.readInt();
			double d = dis.readDouble();
			boolean b = dis.readBoolean();
			String s = dis.readUTF();
			System.out.println("int: " + i + " double: " + d + " boolean: " + b + " String: " + s);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e) {
			}
			try {
				if (fi != null)
					fi.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void method3() {
		FileOutputStream fo = null;
		ObjectOutputStream dos = null;

		try {
			fo = new FileOutputStream("bb.dat"); // .dat 파일은 user가 읽을수없는 파일 형태
			dos = new ObjectOutputStream(fo);
			//참조형 클래스의 객체는 byte형식으로 줄세워야 함
			// implements serializable 
			dos.writeObject(new Account("123", "박정민", 1000));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
			}
			try {
				if (fo != null)
					fo.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void method4() {
		FileInputStream fi = null;
		ObjectInputStream dis = null;

		try {
			fi = new FileInputStream("bb.dat"); // .dat 파일은 user가 읽을수없는 파일 형태
			dis = new ObjectInputStream(fi);
			Account acc = (Account)dis.readObject();
			System.out.println(acc);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e) {
			}
			try {
				if (fi != null)
					fi.close();
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {
		method3();
		System.out.println("OUTPUT END");
		method4();
		System.out.println("INPUT END");
	}
}
