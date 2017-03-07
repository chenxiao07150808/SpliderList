package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gdmec.net.HttpUtils;

public class StaryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String result="";
     Document doc;
     try {
		result=HttpUtils.doGet("http://www.gdmec.cn");
		doc=Jsoup.parse(result);
		Elements allLinks=doc.select("img");
		System.out.println(allLinks);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
