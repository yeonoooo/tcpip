package com.multi.day19;

public class ShareArea {
	Account account1;
	Account account2;

	public ShareArea(Account account1, Account account2) {
		super();
		this.account1 = account1;
		this.account2 = account2;
	}

	public void transfer() { // 함수의 선언부에 synchronized를 넣을 수있음
		synchronized (this) {
			int amount = account1.withdraw(100);
			System.out.println("이몽룡 계좌: 100만원 인출");
			account2.deposit(amount);
			System.out.println("성춘향 계좌: 100만원 입금");
		}
	}

	public void print() {
		synchronized (this) {
			int sum = account1.balance + account2.balance;
			System.out.println("계좌 합계: " + sum);
		}
	}
}
