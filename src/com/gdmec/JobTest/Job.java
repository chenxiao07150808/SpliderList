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
	return "����ְλ    [" + JobName + "]     ��������   [" + JobType + "]      ����ʱ��   [" + JobTime + "]    �����ص�  [" + location + "]";
}

}
