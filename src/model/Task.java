package model;

import com.gdmec.tools.MD5;

public class Task {
  public String Title="";
  public String Url="";
  public boolean visited=false;
  public int level=0;
  public String md5="";
  public Task(String title,String url,int l){
	    this.Title=title;
		this.Url=url;
		this.level=l;
		this.md5=MD5.string2MD5(url);
  }
}
