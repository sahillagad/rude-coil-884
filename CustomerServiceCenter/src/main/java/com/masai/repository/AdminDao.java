package com.masai.repository;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AdminDao extends JpaRepository<Admin,Integer> {

}
