package data;

import java.util.HashMap;

import model.Task;

public class GlobalConfig {
public static HashMap<String ,Task> taskList=null;
public static int MaxLevel=2;
public static String Host="http://www.gdmec.cn/";
public static void Init(){
	taskList=new HashMap<String,Task>();
}
public static void putItem(String title,String url,int level){
	Task task=new Task(title,url,level);
	if(taskList.containsKey(task.md5)){
		System.out.println(url+"这个来链接任务已经存在");
		return;
	}
	taskList.put(task.md5, task);
}
public static void delItem(Task task){
	taskList.remove(task.md5);
}
public static void showAll(){
	for(Task task:taskList.values()){
		System.out.println(task.md5+"=>:"+task.Url);
	}
	
}
public static Task getNext(){
	for(Task task:taskList.values()){
		if(task.visited==false){
			return task;
		}
	}
	return null;
}
	

}
