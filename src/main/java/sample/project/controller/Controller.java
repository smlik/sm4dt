package sample.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.project.dto.EmployeeDTO;
import sample.project.service.EmployeeService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee( @Valid @RequestBody EmployeeDTO employeeDTO ){
		employeeService.saveEmployee(employeeDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/employee")
	public ResponseEntity<Map<String, Object>> getAllEmployees( Pageable pageable){
		return ResponseEntity.ok(employeeService.getAllEmployees(pageable));
	}
}
