package com.gdmec.Job;

public class Job {
  String companyName="";
  String JobName="";
  String JobNo="";
  String JobUrl="";
  String companyUrl="";
  String location="";
  String Salary="";
  public Job(String companyName, String jobName, String location,String salary) {
		
		this.companyName = companyName;
		this.JobName = jobName;
		this.location = location;
		this.Salary = salary;
	}
public Job(String companyName, String jobName, String jobNo, String jobUrl, String companyUrl, String location,
		String salary) {
	
	this.companyName = companyName;
	this.JobName = jobName;
	this.JobNo = jobNo;
	this.JobUrl = jobUrl;
	this.companyUrl = companyUrl;
	this.location = location;
	this.Salary = salary;
}
@Override
public String toString() {
	return "��˾����:" + this.companyName + "    ����ְλ:" + this.JobName + "     ��˾��ַ:" + this.location + "    нˮ:" + this.Salary;
}
  
}
