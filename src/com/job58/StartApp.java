package com.job58;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.JobTest.HttpUtils;

public class StartApp {
    public static  ArrayList<job> list=new ArrayList<job>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateHelper date=new DateHelper();
		
		try {
			
			String result=HttpUtils.doGet("http://gz.58.com/sou/?key=android%E5%BC%80%E5%8F%91%E5%B7%A5%E7%A8%8B%E5%B8%88");
		
			
			Document doc=Jsoup.parse(result);
			
			Elements table=doc.select("#searchTable > tbody > tr");
			
			for(Element list2:table){
				/*System.out.println(list2);*/
				hander(list2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(job joblist:list){
			
			date.insert(joblist.title, joblist.location, joblist.pubdate);
		}
	}
	public static void hander(Element list2){
		String title="";
		String location="";
		String pubdate="";
		Elements temp=list2.select("td a");
		if(temp!=null&&temp.size()>0){
			title=temp.get(0).attr("title");
		}
		temp=list2.select("p.abt > a:nth-child(3)");
		if(temp!=null&&temp.size()>0){
			location=temp.text();
		}
		temp=list2.select("p.abt");
		if(temp!=null&&temp.size()>0){
			pubdate=temp.get(0).ownText();
			
		}
		list.add(new job(title, location, pubdate));
		
		
	}

}
