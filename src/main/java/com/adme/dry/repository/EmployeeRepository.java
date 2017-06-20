package com.adme.dry.repository;

import com.adme.dry.entities.TblEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Adme System on 6/10/2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<TblEmployee,Integer> {
    @Query("SELECT a FROM TblEmployee a WHERE a.employeeUsername = :employeeUsername")
    public TblEmployee findEmployeeByUsername(@Param("employeeUsername") String employeeUsername);
}
