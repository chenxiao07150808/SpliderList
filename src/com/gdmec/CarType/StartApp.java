package com.gdmec.CarType;



import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StartApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		try {
				for(int i=2;i<99;i++){
					String result=HttpUtils.doGet("http://price.pcauto.com.cn/top/k0-p"+i+".html");
					Document doc=Jsoup.parse(result);
				
					 Elements table=doc.select("div.box-bd ul.list-a li");
					 for(Element row:table)
				        {
				        	//System.out.println(row.html());
				        	handler(row);
				        System.out.println();
				        }	 
				}
			
	        //System.out.println(result);	       	
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}	
	public static void handler(Element row)
	{
		String title="";
		String chexing="";
		String price="";
		
		Elements temp=row.select("div.info p ");
		if(temp!=null && temp.size()>0)
		{
			title=temp.get(2).text();
			System.out.print(title+"   ");
		}
		
		 temp=row.select("div.info strong a");
		if(temp!=null && temp.size()>0)
		{
			chexing=temp.get(0).text();
			System.out.print("车型:"+chexing+"    ");
		}
		
		temp=row.select("div.info p em.red");
		if(temp!=null && temp.size()>0)
		{
			price=temp.get(0).text();
			System.out.println("价格:"+price);
		}
						
	}

}
