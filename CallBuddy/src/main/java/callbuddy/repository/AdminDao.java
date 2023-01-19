package callbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import callbuddy.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

}
