package com.hjh.diexam02_2;

import java.util.ArrayList;

public class Student {
	private String name;
	private int sno;
	private String major;
	private ArrayList<Score> score;
	
	public Student() {
		super();
	}

	public Student(String name, int sno, String major, Score score) {
		super();
		this.name = name;
		this.sno = sno;
		this.major = major;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public ArrayList<Score> getScore() {
		return score;
	}

	public void setScore(ArrayList<Score> score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sno=" + sno + ", major=" + major + ", score=" + score + "]";
	}
	
}
