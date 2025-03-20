package com.soap.endpoint;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
 
import com.soap.response.GetStudentResponse;
import com.soap.service.StudentService;
import com.soap.model.Student;
import com.soap.request.GetStudentRequest;
 
@Endpoint  // soap web service
public class StudentEndpoint {
	
	private static final String NAMESPACE_URI = "http://soap.com/student";
	
	// inject service layer
	@Autowired
	private StudentService studentService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentRequest")
	@ResponsePayload
	public GetStudentResponse getStudentResponse(@RequestPayload GetStudentRequest request) {
		
		Student student = studentService.getStudentById(request.getId());
		GetStudentResponse response = new GetStudentResponse();
		response.setStudent(student);
		return response;
		
	}
 
}
 
 