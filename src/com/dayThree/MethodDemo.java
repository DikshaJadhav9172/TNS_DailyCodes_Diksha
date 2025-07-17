package com.dayThree;

public class MethodDemo {
	
		public void addition()
		{
			int x=20;
			int y=10;
			int add=x+y;
			
			System.out.println("Addition of X and Y ="+add);
		}
		public void multiply(int a,int b) 
		{
			int product=a*b;
			System.out.println("Multiplication is:"+ product);
			
		}
		public static void main(String[] args) 
		{
			MethodDemo obj=new MethodDemo();
			obj.addition();
			obj.multiply(2,3);
			
		}
			
}
