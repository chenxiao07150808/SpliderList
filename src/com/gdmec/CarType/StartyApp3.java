package com.gdmec.CarType;


import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StartyApp3 {
	public  static ArrayList<Car> carlist = new ArrayList<Car>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   //  DateHelper date=new DateHelper();
     
     
		for (int i = 2; i < 40; i++) {
		/*	if(i==1){
				String url="http://price.pcauto.com.cn/price/q-k9999-cs4.html";
				getHtml(url);
			}*/
			String url = "http://price.pcauto.com.cn/price/q-k9999-cs4-n"+i+".html";
			getHtml(url);
		}
		 for (Car list:carlist ){
	    	 // date.insert(list.Name, list.Type, list.price);
			 System.out.println(list.toString());
	      }

	}

	public static void getHtml(String url) {
		try {
			String result = HttpUtils.doGet(url);

			Document doc = Jsoup.parse(result);

			Elements list = doc.select("#rInfo > div > div.lieBiaoList.clearfix");

			for (Element listshow : list) {
				//System.out.println(listshow);
				getMessage(listshow);
				
				
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
		
		Elements temp=listshow.select("div.con > div>strong .blue");
		
		if(temp!=null && temp.size()>0)
		{
			//System.out.println(temp);
			//for(int i=0;i<temp.size();i++){
			    Name=temp.get(0).text();
			//}
		}
		 temp=listshow.select(".noborder>i>em>.blue");
			if(temp!=null && temp.size()>0)
			{
				for(int a=0;a<temp.size();a++){
				Type=temp.get(a).attr("title");
				//System.out.println(Type);
				}	
			}
			
			temp=listshow.select(".con-dl .black");
			if(temp!=null && temp.size()>0)
			{ 
				for(int b=0;b<temp.size();b++){
				price=temp.get(b).text();
			//	System.out.println(price);
				}
			}
			carlist.add(new Car(Name,Type,price));				
	}
}
