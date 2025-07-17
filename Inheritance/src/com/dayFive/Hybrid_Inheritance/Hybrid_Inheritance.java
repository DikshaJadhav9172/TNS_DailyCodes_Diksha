package com.dayFive.Hybrid_Inheritance;

class Person {
		long photo;
		String name;
		
		public void PersonalDetails() {
			System.out.println(name+" "+photo);
			System.out.println("PersonalDetails() from Person Class\n");
		}
		
}
class Employee extends Person{
	int empid;
	String position;
	float salary;
	
	public void EmployeeDetails() {
		System.out.println(empid+" "+position);
		System.out.println("EmployeeDetails() from Employee Class\n");
	}
}
class Manager extends Employee{
	String authority;
	
	public void managerAuthority() {
		System.out.println(authority);
		System.out.println("managerAuthority() from Manager Class\n");
	}
}
class Client extends Person{
	String bond;
	String Projects;
	
	public void clientDetails() {
		System.out.println(bond+" "+Projects);
		System.out.println("clientDetails() from Client Class\n");
	}
	
}
public class Hybrid_Inheritance {
	public static void main(String[] args) {
		 Client c=new Client();
		 c.PersonalDetails();
		 c.clientDetails();
		 
		 Manager m=new Manager();
		 m.EmployeeDetails();
		 m.managerAuthority();
	}
}
