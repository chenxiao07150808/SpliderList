package com.gdmec.JobTest;

public class Job {
String JobName="";
String JobType="";
String JobTime="";
String location="";
public Job(String jobName, String jobType, String jobTime, String location) {
	
	this.JobName = jobName;
	this.JobType = jobType;
	this.JobTime = jobTime;
	this.location = location;
}
@Override
public String toString() {
	return "工作职位    [" + JobName + "]     工作类型   [" + JobType + "]      工作时间   [" + JobTime + "]    工作地点  [" + location + "]";
}

}
