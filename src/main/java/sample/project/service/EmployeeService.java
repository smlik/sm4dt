package sample.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sample.project.dto.EmployeeDTO;
import sample.project.entity.Employee;
import sample.project.repository.EmpoyeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
	
	@Autowired
	EmpoyeeRepository empoyeeRepository;
	
	public void saveEmployee( EmployeeDTO employeeDTO ) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee, "hireDate");
		empoyeeRepository.save(employee);
	}
	
	public Map<String, Object> getAllEmployees( Pageable pageable ) {
		Map<String,Object> result = new HashMap<>();
		Page<Employee> employees = empoyeeRepository.findAll(pageable);
		result.put("content",getContent(employees));
		result.put("total",employees.getTotalPages());
		result.put("totalRecords",employees.getTotalElements());
		return result;
	}
	
	private List<EmployeeDTO> getContent( Page<Employee> employees ) {
		return employees
				.stream()
				.map(this::getDTO)
				.collect(Collectors.toList());
	}
	
	private EmployeeDTO getDTO( Employee employee ) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employee, dto);
		return dto;
	}
}
