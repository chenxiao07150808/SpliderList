package com.gdmec.work;

public class Messages {
String mainMessage="";
String price="";
String type="";

public Messages(String mainMessage, String price, String type) {
	this.mainMessage = mainMessage;
	this.price = price;
	this.type = type;
}
@Override
public String toString() {
	return "Messages [mainMessage=" + mainMessage + ", price=" + price + ", type=" + type + "]";
}

}
