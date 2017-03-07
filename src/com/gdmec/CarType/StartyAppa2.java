package com.gdmec.CarType;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StartyAppa2 {
	public  static ArrayList<Car> carlist = new ArrayList<Car>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     DateHelper date=new DateHelper();
     
     
		for (int i = 1; i < 40; i++) {
			String url = "http://price.pcauto.com.cn/top/k0-p" + i + ".html";
			getHtml(url);
		}
		 for (Car list:carlist ){
	    	  date.insert(list.Name, list.Type, list.price);
	      }

	}

	public static void getHtml(String url) {
		try {
			String result = HttpUtils.doGet(url);

			Document doc = Jsoup.parse(result);

			Elements list = doc.select("div.box-bd ul.list-a li");

			for (Element listshow : list) {
				//System.out.println(listshow);
				getMessage(listshow);
				//System.out.println();
				
			}

			//System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void getMessage(Element listshow){
		String Name="";
		String Type="";
		String price="";
		
		Elements temp=listshow.select("div.info p ");
		
		if(temp!=null && temp.size()>0)
		{
			Name=temp.get(2).text();
			//System.out.println(Name);
		}
		 temp=listshow.select("div.info strong a");
			if(temp!=null && temp.size()>0)
			{
				Type=temp.get(0).text();
				
			}
			
			temp=listshow.select("div.info p em.red");
			if(temp!=null && temp.size()>0)
			{
				price=temp.get(0).text();
				
			}
			carlist.add(new Car(Name,Type,price));				
	}
}
