package sample.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sample.project.entity.Employee;

public interface EmpoyeeRepository extends JpaRepository<Employee,Integer> {
}
