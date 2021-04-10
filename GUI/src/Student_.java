

import java.util.*;
import java.util.Date;

public class Student_ {

	private int ID;
	private String name,address,emailAddress;
	private double GPA;
	private double percentage;
	private Date enrolmentDate;
	
	private int[] Course= new int [100];////1사람당, 10과목씩 저장 가능.
	
	private int size=0;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID=iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress=emailAddress;
	}
	
	public Date getEnrolmentDate() {
		return enrolmentDate;
	}
	
	public void setEnrolmentDate(Date enrolmentDate) {
		this.enrolmentDate=enrolmentDate;
	}
	
	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gpa) {
		// TODO Auto-generated method stub
		this.GPA=gpa;
		
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setDate(Date Date) {
		enrolmentDate=Date;
	}

	public int[] getCourse() {
		return Course;
	}

	public void setCourse(int[] course_ID) {
		Course = course_ID;
	}

}