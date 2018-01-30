package com.multi.day19;

public class TransferThread extends Thread {

	ShareArea shareArea;

	public TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		// 이몽룡 >> 성춘향 100만원 10번 반복
		for (int cnt = 1; cnt < 12; cnt++) {shareArea.transfer();}
	}

}
