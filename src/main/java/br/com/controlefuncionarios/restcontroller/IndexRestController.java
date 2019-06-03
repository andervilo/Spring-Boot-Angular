package br.com.controlefuncionarios.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.controlefuncionarios.model.Telefones;
import br.com.controlefuncionarios.service.EmployeeService;
import br.com.controlefuncionarios.service.TelefoneService;

@RestController
public class IndexRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TelefoneService telefoneService;
	
	
	
	@RequestMapping("/users")
	@ResponseBody
	public String getUsers() {
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		           "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}
	
	@RequestMapping("/response")
	@ResponseBody
	public ResponseEntity<?> getResponse() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();		
		return ResponseEntity.ok().body(
				"{"
				+ "\"success\": true,"
				+ "\"data\":"+  objectMapper.writeValueAsString(employeeService.findAll())+
				"}"
				);
	}
	@RequestMapping("/telefones")
	@ResponseBody
	public ResponseEntity<?> getTelefones() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();	
		System.out.println(objectMapper.writeValueAsString(telefoneService.findAll()));
		
		return ResponseEntity.ok().body(
				"{"
						+ "\"success\": true,"
						+ "\"data\":"+  objectMapper.writeValueAsString(telefoneService.findAll())+
				"}"
				);
	}
	
//	@RequestMapping("/response")
//	@ResponseBody
//	public String getResponse() {
//		return "{\"menu\": {\r\n" + 
//				"  \"id\": \"file\",\r\n" + 
//				"  \"value\": \"File\",\r\n" + 
//				"  \"popup\": {\r\n" + 
//				"    \"menuitem\": [\r\n" + 
//				"      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n" + 
//				"      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n" + 
//				"      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n" + 
//				"    ]\r\n" + 
//				"  }\r\n" + 
//				"}}";
//	}

}
