package com.multi.day19;
//Shared Area
public class BathRoom {
	
	String location;
	
	public BathRoom(String location) {
		this.location =location;
	}
	
	boolean first = true;
	
//	synchronized block
	public void use(String name) {
		synchronized (this) {//this = bathroom
			if(first && name.equals("A")) {
				try {
					wait(); // wait until meeting notify() or notifyAll()
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			System.out.println(name+"입장");
			System.out.println(name+"사용");
			System.out.println(name+"퇴장");
			System.out.println("====================");
			first = false;
			notifyAll(); //wait 에게 신호를 보내서 깨워줌: 대기>>실행가능상태
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	synchronized modifier
	public synchronized void use2(String name) {
			System.out.println(name+"입장");
			System.out.println(name+"사용");
			System.out.println(name+"퇴장");
			System.out.println("====================");
	}
}
