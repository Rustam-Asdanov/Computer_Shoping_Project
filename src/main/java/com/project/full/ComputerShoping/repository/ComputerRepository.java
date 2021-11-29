package com.project.full.ComputerShoping.repository;

import com.project.full.ComputerShoping.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer,Long> {
}
