package com.hjh.diexam02_3;

import java.util.ArrayList;

public class Member {
	private String name;
	private String tel;
	private String gender;
	private ArrayList<String> hobby;
	
	public Member() {
		super();
	}
	public Member(String name, String tel, String gender, ArrayList<String> hobby) {
		super();
		this.name = name;
		this.tel = tel;
		this.gender = gender;
		this.hobby = hobby;
	}
	
	public void print() {
		System.out.println("결과");
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + tel);
		System.out.println("성별 : " + gender);
		System.out.print("취미 : ");
		for(int i=0; i<hobby.size(); i++) {
			if(i==(hobby.size()-1)) {
				System.out.println(hobby.get(i)+"\n");
				return;
			}
			System.out.print(hobby.get(i)+", ");
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ArrayList<String> getHobby() {
		return hobby;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", tel=" + tel + ", gender=" + gender + ", hobby=" + hobby + "]";
	}
	
	
}
