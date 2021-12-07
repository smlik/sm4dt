package sample.project.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column(name = "first_name", length = 20)
	String firstName;
	
	@Column(name = "last_name", length = 25)
	String lastName;
	
	@Column(name = "email", length = 25)
	String email;
	
	@Column(name = "phone_number", length = 20)
	String phoneNumber;
	
	@Column(name = "hire_date")
	LocalDate hireDate = LocalDate.now();
	
	@Column(name = "salary", precision = 8, scale = 2)
	Double salary;
	
	
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
}
