package com.multi.day19;

public class PrintThread extends Thread {

	ShareArea shareArea;

	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		// 잔고출력 3번 반복
		for (int i = 1; i <= 3; i++) {shareArea.print();}
	}

}
