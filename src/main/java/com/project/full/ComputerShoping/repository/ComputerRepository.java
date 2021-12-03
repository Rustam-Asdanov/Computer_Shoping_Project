package com.project.full.ComputerShoping.repository;

import com.project.full.ComputerShoping.model.Account;
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

    Computer getComputerById(long id);

    @Query("select * from Computer c where c.the_account_id=?1 ")
    List<Computer> getComputerByAccountId(long id);

    @Query("select * from Computer c where c.the account_id=:id LIMIT 5 OFFSET :counter")
    List<Computer> getComputerList(long id, int counter);
}
