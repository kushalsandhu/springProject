package com.soap.model;
 
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
 
// class annotations
@XmlRootElement(name="Student") // mark this class as rorot element of XMl tree
@XmlAccessorType(XmlAccessType.FIELD)  // tells tha JAXB -> should access the fields directly, bounded to xml
public class Student {
	
	
	@XmlElement(name="id")
	private int id;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="age")
	private int age;
	
	@XmlElement(name="grade")
	private String grade;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
 
	public Student(int id, String name, int age, String grade) {
	
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	public String getGrade() {
		return grade;
	}
 
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
 
}
 
 