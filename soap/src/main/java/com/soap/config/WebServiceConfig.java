package com.soap.config;
 
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
 
// set up the soap web service endpoints ans instruct the spring on how to generate wsdl from xml schema
// /students -> wsdl file file
 
@EnableWs  //Enable SOAP web service -> activating web fetures -> SOAP endpoints
@Configuration // marks the class bean den source -> application context
public class WebServiceConfig {
	
	// incoming req ->
	// spring web services -> special servlet -> dispatch incominh message to app endpoint methods
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}
	
	// stduent schema bean
	@Bean
	public XsdSchema studentSchema() {
		return new SimpleXsdSchema(new ClassPathResource("students.xsd"));
	}
	
	@Bean(name="students")
	// localhost:8080/ws/students.wsdl
	// DefaultWsdlDef -> based on XML schema
	// porttyename, locationuri, targetnamepsance
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("StudentPort");
	    wsdl11Definition.setLocationUri("/ws/");
	    wsdl11Definition.setTargetNamespace("http://soap.com/students");
	    wsdl11Definition.setSchema(studentSchema);
	    return wsdl11Definition;
	}
 
}
 
 