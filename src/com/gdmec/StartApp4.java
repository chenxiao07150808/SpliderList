package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import data.GlobalConfig;
import model.Task;
import com.gdmec.net.HttpUtils;


public class StartApp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String result="";
		
		String Host="http://www.gdmec.cn/";
		
		Document doc;
		
		//没有这一步，hash表没有被实例化
		GlobalConfig.Init();
		
		//VisitURL(Task task)
		
		GlobalConfig.putItem("广东机电",Host,0);
		
		Task task=GlobalConfig.getNext();
		
		VisitURL(task);
	}
	
	
	public static void VisitURL(Task task)
	{
		task.visited=true;
        if(task.level+1>GlobalConfig.MaxLevel)
       {        	
     	return ;
       }
            
		try {
	        String s,temp;
	        Document doc;
	        System.out.println("准备访问"+task.Url);
	        //不论成功与否，都要标识已经访问了        
	        s=HttpUtils.doGet(task.Url);
			doc=Jsoup.parse(s);
			
			Elements all=doc.select("a");
		

			if(all.size()>0)
			{
				for(Element element:all)
				{
					temp=element.attr("href");
					
					if(temp.contains("../"))continue;
					
					if(temp.contains("http:") || temp.contains("https:"))
					{
						GlobalConfig.putItem(element.attr("title"), element.attr("href"), task.level+1);
				        //System.out.println(element.attr("href"));
					}
					else
					{
						if(temp.startsWith("//"))
						{
							GlobalConfig.putItem(element.attr("title"), "http:"+element.attr("href"), task.level+1);
							// System.out.println("http:"+element.attr("href"));	
						}
						else
						{
							GlobalConfig.putItem(element.attr("title"), GlobalConfig.Host+element.attr("href"), task.level+1);
						  //System.out.println(GlobalValue.Host+element.attr("href"));
						}
					}
				}
			}
			
			 System.out.println("当前访问深度"+task.level);
			 System.out.println(task.Url+"访问完毕");
			 System.out.println("当前访问列表中存在"+GlobalConfig.taskList.size()+"条记录");
			//GlobalValue.showAll();
			
			//System.out.println(s);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
   
        

           
          Task next=null;  
        do{ 
         //下一个访问
         next=GlobalConfig.getNext();
         System.out.println("获取下一个任务");	
          if(next!=null)
          {
    	    VisitURL(next);
          }
         }while(next!=null);
       
            
	}
	

}
