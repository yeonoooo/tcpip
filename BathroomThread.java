package com.multi.day19;

public class BathroomThread extends Thread
{
	BathRoom room;
	String name;
	
	public BathroomThread(BathRoom room, String name) {
		super();
		this.room = room;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <=3; i++) {
			room.use(name);
		}
	}

}
