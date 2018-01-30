package com.multi.day19;

public class MultiThreadAccountTest {
	public static void main(String[] args) {
		ShareArea area = new ShareArea(new Account("1", "ÀÌ¸ù·æ", 2000), new Account("2", "¼ºÃáÇâ", 1000));
		TransferThread t1 = new TransferThread(area);
		PrintThread t2 = new PrintThread(area);

		t1.start();
		t2.start();
	}

}
