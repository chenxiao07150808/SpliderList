package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.gdmec.net.HttpUtils;

public class StartApp {

	public static void main(String[] args) {
String result="";
		
		//第一步，声明Document
		Document doc;
		
		try {
			
			result=HttpUtils.doGet("http://www.gdmec.cn/");
			
			//第二部，转换html文档为Docment对象
			doc=Jsoup.parse(result);
			
			//第三部，提取
			Elements allLinks=doc.select("img");
			
			for(Element link:allLinks)
			{
				 System.out.println("http://www.gdmec.cn/"+link.attr("src"));	
			}
			
			//System.out.println(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
