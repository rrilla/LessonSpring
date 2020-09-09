package com.hjh.diexam02_2;

public class Score {
	
	private String subject;
	private double point;
	
	public Score() {
		super();
	}

	public Score(String subject, double point) {
		super();
		this.subject = subject;
		this.point = point;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Score [subject=" + subject + ", point=" + point + "]";
	}
	
}
