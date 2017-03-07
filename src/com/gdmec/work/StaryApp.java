package com.gdmec.work;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gdmec.JobTest.HttpUtils;

public class StaryApp {
public static ArrayList<Messages> listshow=new ArrayList<Messages>();
	public static void main(String[] args) {
		
getHtml("http://gz.58.com/chuzu/0/pn2");
  DateHelper date=new DateHelper();
  for(Messages show:listshow){
     System.out.println(show.toString());
	  /*date.insert(show.mainMessage,show.price, show.type);*/
  }
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
		
		Elements list=doc.select("#infolist > table > tbody tr");
		
		for(Element listinput:list){
			System.out.println(listinput);
			System.out.println("--------------------------");
		}
		
		for(Element listInput :list){
			//getMessage(listInput);
		}
	}
	public static void getMessage(Element listInput){
		String mainMessage="";
		String price="";
		String type="";
		Elements list=listInput.select("td.t");//t
			if(list!=null&&list.size()>0){
			mainMessage=list.get(0).text();
			}
			list=listInput.select("td>b");//
			if(list!=null&&list.size()>0){
				price=list.get(0).text();
				System.out.println(price);
				
			}
			list=listInput.select("td>span.showroom");
			if(list!=null&&list.size()>0){
			type=list.get(0).text();
			}
			
			listshow.add(new Messages(mainMessage, price, type));
			
		}
	}

