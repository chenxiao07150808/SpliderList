package com.gdmec.computer;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.JobTest.HttpUtils;

public class StaryApp {
   static ArrayList<Message> list2=new ArrayList<Message>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getHtml("http://www.guazi.com/gz/buy");
		DateHelper date=new DateHelper();
				
		for(Message list3:list2){
			/*System.out.println(list3.toString());*/
			date.insert(list3.title, list3.time, list3.statu, list3.price, list3.maxprice);
		}
	}
	public static void getHtml(String url){
		String result="";
		try {
			result=HttpUtils.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Document doc=Jsoup.parse(result);
		  
		  Elements list=doc.select("body > div.w > div.list > ul>li");
		  
		  for(Element listshow:list){
			getMessage(listshow);
			 /* System.out.println(list);*/
		  }
	}
  public static void getMessage(Element listshow){
	    
	  String title="";
	  
	  String time="";
	  
	  String price="";
	  
	  String statu="";
	  
	  String maxprice="";
	  
	  Elements temp=listshow.select("a");
	  
	  if(temp!=null&&temp.size()>0){
		  title=temp.get(1).text();
		
	  }
	  temp=listshow.select("span");
	  if(temp!=null&&temp.size()>0){
		  time=temp.get(0).text();
		
	  }
	  temp=listshow.select("i");
	  if(temp!=null&&temp.size()>0){
		  price=temp.get(0).text();
		
	  }
	  
	  temp=listshow.select("div > p.fc-gray");
	  if(temp!=null&&temp.size()>0){
		  statu=temp.get(0).ownText();
	  }
	  
	  temp=listshow.select("s");
	  if(temp!=null&&temp.size()>0){
		  maxprice=temp.get(0).text();
	  }
	  list2.add(new Message(title, time, statu, price,maxprice));
  }
}
