package com.multi.day19;

import java.io.Serializable;

public class Account implements Serializable{
	String accountNo;
	int balance;
	String owenerName;

	public Account() {

	}

	public Account(String accountNo, String owenerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.owenerName = owenerName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountNo=").append(accountNo).append(", balance=").append(balance)
				.append(", owenerName=").append(owenerName).append("]");
		return builder.toString();
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (balance < amount)
			return 0;
		balance -= amount;
		return amount;
	}

}
