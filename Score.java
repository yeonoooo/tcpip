package com.multi.day19;

public class Score {
	String name;
	String sc1;
	String sc2;
	String sc3;
	String sum;

	public Score(String name, String sc1, String sc2, String sc3, String sum) {
		super();
		this.name = name;
		this.sc1 = sc1;
		this.sc2 = sc2;
		this.sc3 = sc3;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return name + ": " + sc1 + " " + sc2 + " " + sc3 + " " + sum;
	}

}


