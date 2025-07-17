package com.dayFiveSingleInheritance;

public class Citizen {
	
	private String name;
	private long aadharno;
	private String address;
	private long phone;
	
	public Citizen() {
		System.out.println("Citizen object ");
	}
	public Citizen(String name,long aadharno,String address,long phone ) {
		this.name=name;
		this.aadharno=aadharno;
		this.address=address;
		this.phone=phone;
	}
	public String getname() {
		return name;
	}

	public long getAadharno() {
		return aadharno;
	}
	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public String toString() {
		return "Citizen [name=" + name + ", aadharno=" + aadharno + ", address=" + address + ", phone=" + phone
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
