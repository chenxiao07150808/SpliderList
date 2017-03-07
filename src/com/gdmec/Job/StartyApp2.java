package com.gdmec.Job;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gdmec.net.HttpUtils;

public class StartyApp2 {
     final  static ArrayList<Job>Joblist2=new ArrayList<Job>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<20;i++){
		getHttp(gethtml2("030200", "android¹¤³ÌÊ¦", i));
		}
		for(Job job:Joblist2){
			System.out.println(job.toString());
		}

	}
	public static String gethtml2(String cityCode,String keyword,int page){
		String nameStr="";
		try {
			nameStr=new String(java.net.URLEncoder.encode(keyword, "utf-8").getBytes());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=" + cityCode
				+ "%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword=" + nameStr
				+ "&keywordtype=2&curr_page=" + page
				+ "&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14&dibiaoid=0&confirmdate=9";
		try {
			String html=HttpUtils.doGet(url);
			return html;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
   public static void getHttp(String html){
	  Document doc=Jsoup.parse(html);
	  
	  Elements Jobtest=doc.select("#resultList div.el");
	  
	  for (org.jsoup.nodes.Element job : Jobtest) {
			processInput(job);
		}
   }
   public static void processInput(org.jsoup.nodes.Element job){
	   String companyName="";
	   String JobName="";
	   String location="";
	   String Salary="";
	   Elements temp=job.select("span.t2 a");
	   if(temp!=null&&temp.size()>0){
		   companyName=temp.get(0).attr("title");
	   }
	   temp=job.select("p a");
	   if(temp!=null&&temp.size()>0){
		   JobName=temp.get(0).attr("title");
	   }
	   temp=job.select("span.t3");
	   if(temp!=null&&temp.size()>0){
		   location=temp.get(0).text();
	   }
	   temp=job.select("span.t4");
	   if(temp!=null&&temp.size()>0){
		 Salary=temp.get(0).text();  
	   }
	  
	 Joblist2.add(new Job(companyName, JobName, location, Salary));
	   
   }
}
