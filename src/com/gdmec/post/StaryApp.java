package com.gdmec.post;

import java.util.HashMap;
import java.util.Map;

public class StaryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       HttpRequestor http=new HttpRequestor();
       String url="http://search.cnipr.com/search!doOverviewSearch.action";
     try {
		String result= http.doPost(url, getparameterMap(8), getCookieMap());
		System.out.println(result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static Map<String ,Object> getparameterMap(int page){
		
		
		Map<String ,Object> parameterMap=new HashMap<String,Object>();
		
		 parameterMap.put("wgViewmodle", null);
	        parameterMap.put("strWhere", "¿§·È±­");
	        parameterMap.put("start", String.valueOf(page));
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
	
	CookieMap.put("JSESSIONID","4233D3766ECC2FAC11CFBD5BC80F817A");
	
	return CookieMap;
}
}
