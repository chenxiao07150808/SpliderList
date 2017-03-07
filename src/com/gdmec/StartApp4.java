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
		
		//û����һ����hash��û�б�ʵ����
		GlobalConfig.Init();
		
		//VisitURL(Task task)
		
		GlobalConfig.putItem("�㶫����",Host,0);
		
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
	        System.out.println("׼������"+task.Url);
	        //���۳ɹ���񣬶�Ҫ��ʶ�Ѿ�������        
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
			
			 System.out.println("��ǰ�������"+task.level);
			 System.out.println(task.Url+"�������");
			 System.out.println("��ǰ�����б��д���"+GlobalConfig.taskList.size()+"����¼");
			//GlobalValue.showAll();
			
			//System.out.println(s);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
   
        

           
          Task next=null;  
        do{ 
         //��һ������
         next=GlobalConfig.getNext();
         System.out.println("��ȡ��һ������");	
          if(next!=null)
          {
    	    VisitURL(next);
          }
         }while(next!=null);
       
            
	}
	

}
