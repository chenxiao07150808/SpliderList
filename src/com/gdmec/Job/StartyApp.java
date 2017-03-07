package com.gdmec.Job;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.net.HttpUtils;

public class StartyApp {
	public static ArrayList<Job> JobList = new ArrayList<Job>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processHtml(getHttp("030200", "н╒пе", 2));
		for(Job job:JobList){
			System.out.println(job.toString());
		}
	}

	public static String getHttp(String cityCode, String keyword, int page) {
		String nameStr = "";
		try {
			nameStr = new String(java.net.URLEncoder.encode(keyword, "utf-8").getBytes());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=" + cityCode
				+ "%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword=" + nameStr
				+ "&keywordtype=2&curr_page=" + page
				+ "&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14&dibiaoid=0&confirmdate=9";
		System.out.println(url);
		try {
			String http = HttpUtils.doGet(url);
			return http;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static void processHtml(String http) {
		Document doc = Jsoup.parse(http);
		Elements jobtest = doc.select("#resultList div.el");
		for (Element job : jobtest) {
			processInput(job);
		}

	}
	public static void processInput(Element job){
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
		 JobList.add(new Job(companyName, JobName, location, Salary));
	}
}
