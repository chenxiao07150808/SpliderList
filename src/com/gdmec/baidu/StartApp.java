package com.gdmec.baidu;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.net.HttpUtils;

public class StartApp {
   static ArrayList<News> newShow=new ArrayList<News>();
	public static void main(String[] args) {
		getHtml("http://www.sohu.com/");
		//DateHelper date=new DateHelper(); 
		for(News list:newShow){
	//	date.insert(list.URL, list.mess);
		System.out.println(list.toString());	
		}
	}
	public static void getHtml(String url){
		String html="";
		String result="";
		try {
			result=HttpUtils.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=Jsoup.parse(result);
		
		Elements list=doc.select("#top_news > ul:nth-child(1) > li>a ");
		
		for(Element list2:list){
			getMess(list2);
			
		}
		
	}
public static void getMess(Element list2){
	String URL="";
	String mess="";
	Elements list32=list2.select("a");
	//for(Element a:list32){
		if(list32!=null&&list32.size()>0){
	    mess=list32.text();
		URL=list32.get(0).attr("href");
		
		}
		newShow.add(new News(URL, mess));
	
	//}
}
}
