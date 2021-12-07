package sample.project.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeDTO {
	
	Integer id;
	
	
	@NotNull(message = "First name can not be null")
	@Size(min = 2, message = "Minimum 2 characters must be available")
	String firstName;
	
	@NotNull(message = "Last name can not be null")
	@Size(min = 2, message = "Minimum 2 characters must be available")
	String lastName;
	
	@Email(message = "Please enter the valid email")
	String email;
	
	@Pattern(regexp = "([0-9]+-)+[0-9]+", message = "Only digits and dashes are allowed")
	String phoneNumber;
	
	LocalDate hireDate;
	
	@DecimalMin(value = "0",inclusive = false)
	Double salary;
	
	public EmployeeDTO() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId( Integer id ) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail( String email ) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	
	public void setHireDate( LocalDate hireDate ) {
		this.hireDate = hireDate;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary( Double salary ) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", hireDate=" + hireDate +
				", salary=" + salary +
				'}';
	}
}
