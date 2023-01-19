package callbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import callbuddy.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
