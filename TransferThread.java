package com.multi.day19;

public class TransferThread extends Thread {

	ShareArea shareArea;

	public TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		// �̸��� >> ������ 100���� 10�� �ݺ�
		for (int cnt = 1; cnt < 12; cnt++) {shareArea.transfer();}
	}

}
