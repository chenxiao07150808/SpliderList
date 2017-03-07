package com.guangxi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class StaryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String url="http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery";
       getHtml(url);
	}
 /*  public static void getHtml(String url){
	   try {
		String result=HttpUtils.doGet(url);
		
		Document doc=Jsoup.parse(result);
		
		Elements list=doc.select("#wipper > div.cont > div.cont_right > div > table > tbody");
		
		for(Element listshow:list){
		getMessage(listshow);
		}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
   }*/
	
	public static void getHtml(String url){
		String result="";
		try {
			result=HttpUtils.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=Jsoup.parse(result);
		
		Elements list=doc.select("#wipper > div.cont > div.cont_right > div > table > tbody>tr");
		
		/*for(Element listinput:list){
			System.out.println(listinput);
		}*/
		
		for(Element listInput :list){
			getMessage(listInput);
		}
	}
   /*public static void getMessage(Element listshow){
	   String Id="";
	   String Name="";
	   String Workplace="";
	   String Worknumber="";
	   
	   Elements temp=listshow.select("tr >td.td2 a");
	
	   if(temp!=null&&temp.size()>0){
		   Name=temp.text();
		   System.out.println(Name);
	   }
	   
	  
	    temp=listshow.select("tr >td.td2");
      
	   if(temp!=null && temp.size()>0){
		   Id=temp.get(0).text();
		   System.out.println(Id);
	   }
	   
   }*/
	public static void getMessage(Element listInput){
		String Name="";
		String ID="";
		String Workplace="";
		String Worknumber="";
		Elements list=listInput.select("tr> td a");//t
			if(list!=null&&list.size()>0){
			Name=list.text();
		  
			}
			list=listInput.select("tr >td.td2");//
			if(list!=null&&list.size()>0){
				ID=(list.get(0).text()).replace("&nbsp",""); 
				Workplace=list.get(2).text();
				Worknumber=list.get(3).text();
			}
			System.out.println(ID+" "+Name+" "+Workplace+" "+Worknumber);
			}
	//JSESSIONID=gvx4u2ar01CgAzCgBQ; _gscu_1389467868=78086965jrk1qx18;
}
