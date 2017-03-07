package com.gdmec.CarType;

public class Car {
	public String Name;
	public String Type;
	public String price;
	 Car(String Name, String Type, String price) {
		this.Name = Name;
		this.Type = Type;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [carName=" + Name + ", Type=" + Type + ", price=" + price + "]";
	}
	
	 
}
