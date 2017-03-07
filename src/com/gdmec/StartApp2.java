package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.net.HttpUtils;

public class StartApp2 {

	public static void main(String[] args) {
		String result="";
		Document doc;
		try {
			result=HttpUtils.doGet("http://www.gdmec.cn/");
			doc=Jsoup.parse(result);
			Elements allLink=doc.select(" tr > td > table > tbody > tr > td > table > tbody a");
			for(Element Link:allLink){
System.out.println(Link.attr("title") +" ==> "+Link.attr("href"));
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

}
