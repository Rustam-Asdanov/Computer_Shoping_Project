package com.project.full.ComputerShoping.repository;

import com.project.full.ComputerShoping.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComputerRepository extends JpaRepository<Computer,Long> {
    @Query("select count(*) from Computer c where c.photo_name LIKE %:name%")
    int checkImageName(@Param("name") String originalFilename);

//    @Query("select * from Computer c where c.login=")
//    List<Computer> getAllByLogin(String name,int count);
}
