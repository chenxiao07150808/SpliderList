package com.gdmec.JobTest;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.JobTest.HttpUtils;

public class StaryApp {
  static ArrayList<Job> list=new ArrayList<Job>();
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        getHtml();
     for(Job list2:list){
    	 if(!list2.toString().equals("")){
    	 System.out.println(list2.toString());
     }
     }
	}
	public static void getHtml(){
		String url="http://gz.58.com/sou/?key=android%E5%BC%80%E5%8F%91%E5%B7%A5%E7%A8%8B%E5%B8%88";
		String html="";
		try {
			 html=HttpUtils.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc=Jsoup.parse(html);
		
		Elements Joblist=doc.select("#main td.t");
		
	/*	for(Element job:Joblist){
			
			System.out.println(job);
		}
		*/
		
	
		for(Element job:Joblist){
			check(job);
		}
		}
	public static void check(Element job){
		String JobName="";
		String JobTime="";
		String JobType="";
		String location="";
		
		Elements temp=job.select("a");
		
		if(temp!=null&&temp.size()!=0){
			JobName=temp.get(0).text();
			JobType=temp.get(2).text();
			JobTime=temp.get(1).text();
			location=temp.get(3).text();
		}
			list.add(new Job(JobName, JobType, JobTime, location));
	}

}
