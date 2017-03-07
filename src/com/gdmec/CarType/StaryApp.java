package com.gdmec.CarType;

import java.util.ArrayList;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.JobTest.HttpUtils;
import com.gdmec.post.HttpRequestor;

public class StaryApp {
   public static ArrayList<Car> car=new ArrayList<Car>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		String url="";
       for(int i=1;i<20;i++){
    	   if(i==0){
    		 getHtml("http://price.pcauto.com.cn/price/q-k111.html");
    	   }
    	   getHtml("http://price.pcauto.com.cn/price/q-k111-n"+i+".html");
       }
       for(Car carlist:car){
    	  System.out.println(car.toString());
       }
      
	}
   public static void getHtml(String url){
	   HttpRequestor Http=new HttpRequestor();
	  String result="";
	  
	  /*try {
		result=Http.doGet(url);
		
		Document doc=Jsoup.parse(result);
		
		Elements list=doc.select("#rInfo > div > div.lieBiaoList.clearfix");
		
	   for(Element carlist:list)
	   {
		   getMessage(carlist);
	   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	  //thlieBiao
	  
	  try {
			 result=HttpUtils.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=Jsoup.parse(result);
		
		Elements list=doc.select("#rInfo > div > div.lieBiaoList.clearfix");
		
	/*	for(Element job:Joblist){
			
			System.out.println(job);
		}
		*/
		
	
		for(Element carlist:list)
		   {
			   //getMessage(carlist);
			   System.out.println(carlist);
			   System.out.println("=================================");
		   }
   }
   public static void getMessage(Element carlist){
	   String Type="";
	   String Name="";
	   String price="";
	   Elements temp=carlist.select("div.lieBiaoList.clearfix .noborder>i>em>a");
	   if(temp!=null&&temp.size()>0){
		   Type=temp.text();
		 System.out.println(Type);
	   }
	  //<a rel="nofollow" class="blue" title="2016款 5.0L GT 性能版" target="_blank" href="/m42721/">2016款 5.0L GT 性能版</a>
	   //<i class="iCol4 blue"><a rel="nofollow" title="车主点评" target="_blank" href="/comment/sg42721/m42721/">点评</a><a rel="nofollow" title="实拍图片" target="_blank" href="/cars/s21226/">图片</a><a href="/m42721/config.html" target="_blank" title="参数配置" rel="nofollow">参数配置</a></i>
   temp=carlist.select("strong");
      if(temp!=null&&temp.size()>0){
    	  Name=temp.text();
    	  //System.out.println(Name);
      }
      temp=carlist.select(".con-dl .black");
      if(temp!=null&&temp.size()!=0){
    	  price=temp.text();
    	  
      }
      car.add(new Car(Name,Type,price));
   }
}
