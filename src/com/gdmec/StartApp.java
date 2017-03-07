package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.gdmec.net.HttpUtils;

public class StartApp {

	public static void main(String[] args) {
String result="";
		
		//��һ��������Document
		Document doc;
		
		try {
			
			result=HttpUtils.doGet("http://www.gdmec.cn/");
			
			//�ڶ�����ת��html�ĵ�ΪDocment����
			doc=Jsoup.parse(result);
			
			//����������ȡ
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
