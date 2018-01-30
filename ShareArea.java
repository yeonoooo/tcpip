package com.multi.day19;

public class ShareArea {
	Account account1;
	Account account2;

	public ShareArea(Account account1, Account account2) {
		super();
		this.account1 = account1;
		this.account2 = account2;
	}

	public void transfer() { // �Լ��� ����ο� synchronized�� ���� ������
		synchronized (this) {
			int amount = account1.withdraw(100);
			System.out.println("�̸��� ����: 100���� ����");
			account2.deposit(amount);
			System.out.println("������ ����: 100���� �Ա�");
		}
	}

	public void print() {
		synchronized (this) {
			int sum = account1.balance + account2.balance;
			System.out.println("���� �հ�: " + sum);
		}
	}
}
