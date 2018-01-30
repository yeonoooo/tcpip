package com.multi.day19;

import java.util.Arrays;

//Enumeration: ����, ��, ���
//���ѵǸ� ������ ���� ������ �� ���
enum Season {
	SPRING("��"), SUMMER("����"), FALL("����"), WINTER("�ܿ�");
	String name;

	Season(String name) {
		this.name = name;
	}
	
	public String getNmae() {
		return name;
	}
}

enum Month {
	EAST, WEST, SOUTH, NORTH;
	String name;
	
	Month(){
		
	}
	Month(String name){
		this.name = name;
	}
}

public class EnumTest {

	// 4����: ����� ���� >> �������� ���밡��
	public static final int SPRING = 1;
	public static final int SUMMER = 2;
	public static final int FALL = 3;
	public static final int WINTER = 4;
	public static final int MARCH = 4;

	public static void print(int season) {
		switch (season) {
		case SPRING:
			System.out.println("��");
			break;
		case SUMMER:
			System.out.println("����");
			break;
		case FALL:
			System.out.println("����");
			break;
		case WINTER:
			System.out.println("�ܿ�");
			break;
		default:
			System.out.println("�߸��Է���");
			break;
		}
	}

	public static void print2(Season season) { // enum season�� ȣ��
		switch (season) {
		case SPRING:
			System.out.println("��");
			break;
		case SUMMER:
			System.out.println("����");
			break;
		case FALL:
			System.out.println("����");
			break;
		case WINTER:
			System.out.println("�ܿ�");
			break;
		default:
			System.out.println("�߸��Է���");
			break;
		}
	}

	public static void main(String[] args) {
		print(SPRING);
		print(MARCH); // 3�� >> ����  ��ġ���� ��� ���
		print2(Season.SPRING);

		Season[] arr = Season.values();
		System.out.println(Arrays.toString(arr));

		System.out.println("-------------------");
		System.out.println(Season.SPRING);
		
		for (Season s : arr) {
			System.out.println(s+": "+s.getNmae());
		}

	}
}
