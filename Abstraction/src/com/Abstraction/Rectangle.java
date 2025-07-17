package com.Abstraction;

public class Rectangle extends Shape {

	private float width,height;
	public Rectangle(float width, float height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	
	public Rectangle() {
		this.width = 5.0f;
		this.height = 2.0f;
	}


	void calArea() {
		area=width*height;
		
	}

}
