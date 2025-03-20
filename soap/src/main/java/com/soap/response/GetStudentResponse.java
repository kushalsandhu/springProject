package com.soap.response;
 
import com.soap.model.Student;
 
import jakarta.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="GetStudentResponse")
public class GetStudentResponse {
	
	private Student student;
 
	public Student getStudent() {
		return student;
	}
 
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
 
}
 
 