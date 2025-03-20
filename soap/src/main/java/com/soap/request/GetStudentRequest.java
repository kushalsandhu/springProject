package com.soap.request;
 
import jakarta.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "GetStudentRequest")
public class GetStudentRequest {
	
	private int id;
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
	
 
}
 
 