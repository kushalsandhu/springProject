package com.soap.service;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.soap.model.Student;
 
@Service
public class StudentService {
	
	
	private List<Student> students = new ArrayList<>();
	
	public StudentService() {
		students.add(new Student(1,"Kushal",22,"A"));
		students.add(new Student(2,"Kullu",21,"A"));
		students.add(new Student(3,"Harry",24,"B"));
				
	}
 
	public Student getStudentById(int id) {
		return students.stream().filter(s->s.getId() == id).findFirst().orElse(null);
	}
	
	public String addStudent(int id, String name, int age, String grade) {
	     students.add(new Student(id,name,age,grade));
	     return "Student Added successfully.";
}
 
    public List<Student> getAllStudents() {
    	return students;
    }
    
    //123456789
    public int sub(int a, int b) {
    	return a-b;
    }
}
 
 