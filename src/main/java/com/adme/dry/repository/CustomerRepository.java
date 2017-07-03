package com.adme.dry.repository;

import com.adme.dry.entities.TblCustomer;
import com.adme.dry.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Adme System on 6/10/2017.
 */
@Repository
public interface CustomerRepository extends JpaRepository<TblCustomer,Integer> {

    @Query("SELECT C FROM TblCustomer C WHERE C.customerFirstName like :customerFirstName")
    Page<TblCustomer> searchCustomerByName(@Param("customerFirstName") String customerFirstName, Pageable page) throws NotFoundException;

    @Query("SELECT C FROM TblCustomer C WHERE C.customerPhone1 LIKE :customerPhone1")
    Page<TblCustomer> searchCustomerByPhone(@Param("customerPhone1") String customerPhone1, Pageable page) throws NotFoundException;

}
