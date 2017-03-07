package com.postTest;

import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

public class StaryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       HttpRequestor http=new HttpRequestor();
       String url="http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery";
     try {
    	 for(int i=1;i<20;i++){
		String result= http.doPost(url, getparameterMap(i), getCookieMap());
		 Document doc=Jsoup.parse(result);
		 Elements list=doc.select("#wipper > div.cont > div.cont_right > div > table > tbody>tr");
		 for(Element listshow:list){
			 getHtml(listshow);
		 }
    	 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static void getHtml(Element listshow) {
		// TODO Auto-generated method stub
		String Name="";
		String ID="";
		String Workplace="";
		String Worknumber="";
		Elements list=listshow.select("tr> td a");//t
			if(list!=null&&list.size()>0){
			Name=list.text();
		  
			}
			list=listshow.select("tr >td.td2");//
			if(list!=null&&list.size()>0){
				ID=(list.get(0).text()).replace("&nbsp",""); 
				Workplace=list.get(2).text();
				Worknumber=list.get(3).text();
			}
			System.out.println(ID+" "+Name+" "+Workplace+" "+Worknumber);
			}
	

	public static Map<String ,Object> getparameterMap(int page){
		
		
		Map<String ,Object> parameterMap=new HashMap<String,Object>();
		
		 parameterMap.put("wgViewmodle", null);
	        parameterMap.put("strWhere", null);
	        parameterMap.put("toPage", String.valueOf(page));
	        parameterMap.put("limit", "10");
	        //option
	        parameterMap.put("option", "2");
	        //iHitPointType
	        parameterMap.put("iHitPointType", null);
	        //strSortMethod=RELEVANCE
	        parameterMap.put("strSortMethod", "RELEVANCE");
	        //strSources=FMZL%2CSYXX
	        parameterMap.put("strSources", "FMZL,SYXX");
	        //strSynonymous
	        parameterMap.put("strSynonymous", null);
	        //yuyijs
	        parameterMap.put("yuyijs", null);
	        //filterChannel=
	        parameterMap.put("filterChannel", null);
	        //keyword2Save=
	        parameterMap.put("keyword2Save", null);
	        //key2Save=
	        parameterMap.put("key2Save", null);
	        //forward=
	        parameterMap.put("forward", null);
	        //otherWhere=
	        parameterMap.put("otherWhere", null);
	        //username=
	        parameterMap.put("username", null);
	        //password=
	        parameterMap.put("password", null);
	        
	        return parameterMap;
			
	}
public static Map<String ,Object> getCookieMap(){
	Map<String ,Object> CookieMap=new HashMap<String ,Object>();
	
	CookieMap.put("JSESSIONID","6b50o8xyn1CgAzCgBQ");
	
	return CookieMap;
}

}
