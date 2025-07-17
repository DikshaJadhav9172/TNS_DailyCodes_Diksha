package com.dayFiveSingleInheritance;

public class Student extends Citizen{
	private int rollno;
	private String collegename;
	
	public Student() {
		super();
	}

	public Student(String name, long aadharno, String address, long phone,int rollno,String collegename) {
		super(name, aadharno, address, phone);
		
		this.rollno=rollno;
		this.collegename=collegename;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	@Override
	public String toString() {
		return "Student [getRollno()=" + getRollno() + ", getCollegename()=" + getCollegename() + ", getname()="
				+ getname() + ", getAadharno()=" + getAadharno() + ", getAddress()=" + getAddress() + ", getPhone()="
				+ getPhone() + "]";
	}

	
}