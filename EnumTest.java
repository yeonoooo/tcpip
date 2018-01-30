package com.multi.day19;

import java.util.Arrays;

//Enumeration: 열거, 셈, 계산
//제한되며 정해진 값만 나열할 때 사용
enum Season {
	SPRING("봄"), SUMMER("여름"), FALL("가을"), WINTER("겨울");
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

	// 4계절: 상수로 정의 >> 동서남북 응용가능
	public static final int SPRING = 1;
	public static final int SUMMER = 2;
	public static final int FALL = 3;
	public static final int WINTER = 4;
	public static final int MARCH = 4;

	public static void print(int season) {
		switch (season) {
		case SPRING:
			System.out.println("봄");
			break;
		case SUMMER:
			System.out.println("여름");
			break;
		case FALL:
			System.out.println("가을");
			break;
		case WINTER:
			System.out.println("겨울");
			break;
		default:
			System.out.println("잘못입력함");
			break;
		}
	}

	public static void print2(Season season) { // enum season을 호출
		switch (season) {
		case SPRING:
			System.out.println("봄");
			break;
		case SUMMER:
			System.out.println("여름");
			break;
		case FALL:
			System.out.println("가을");
			break;
		case WINTER:
			System.out.println("겨울");
			break;
		default:
			System.out.println("잘못입력함");
			break;
		}
	}

	public static void main(String[] args) {
		print(SPRING);
		print(MARCH); // 3월 >> 가을  원치않은 결과 출력
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
