package com.gdmec.baidu;

public class News {
String URL="";
String mess="";
public News(String URL, String mess) {

	this.URL = URL;
	this.mess = mess;
}
@Override
public String toString() {
	return "News [URL=" + URL + ", mess=" + mess + "]";
}

}
