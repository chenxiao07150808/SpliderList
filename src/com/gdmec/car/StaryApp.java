package com.gdmec.car;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.JobTest.HttpUtils;
import com.gdmec.tools.MD5;

public class StaryApp {
  public static ArrayList<String> newList=new ArrayList<String>();
  public static void download(){
	  for(String list:newList){
		  int last=list.lastIndexOf(".");
		  String file=MD5.string2MD5(list)+"."+list.substring(last+1);
		  DownloadFile down=new DownloadFile();
		  
		  try {
			down.downLoadFromUrl(list, file, "d://iamges");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		for(int i=66;i<88;i++){
		getHtml("http://desk.zol.com.cn/bizhi/6791_847"+i+"_2.html");
		}
		download();
	}
	public static void getHtml(String url){
		String result="";
		try {
			result=HttpUtils.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document doc=Jsoup.parse(result);
		
		Elements list=doc.select("#bigImg");

		
		 for(Element listshow:list){
			 System.out.println(listshow.attr("src"));
			 newList.add(listshow.attr("src"));
		 }
	}

}
