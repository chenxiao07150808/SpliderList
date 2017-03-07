package com.gdmec.computer;

public class Message {
  String title="";
  String time="";
  String statu="";
  String price="";
  String maxprice="";
public Message(String title, String time, String statu, String price,String maxprice) {
	
	this.title = title;
	this.time = time;
	this.statu = statu;
	this.price = price;
	this.maxprice=maxprice;
}

@Override
public String toString() {
	return "Message [title=" + title + ", time=" + time + ", statu=" + statu + ", price=" + price + ", maxprice=" + maxprice + "]";
}
  
}
