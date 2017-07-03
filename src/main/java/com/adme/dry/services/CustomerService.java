package com.adme.dry.services;

import com.adme.dry.bean.CustomerBean;
import com.adme.dry.entities.TblCustomer;
import com.adme.dry.exception.NotFoundException;
import com.adme.dry.exception.SaveException;
import com.adme.dry.exception.UpdateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Adme System on 6/21/2017.
 */
public interface CustomerService {
    TblCustomer addCustomer (TblCustomer customer) throws SaveException;
    TblCustomer updateCustomer(TblCustomer customer)throws UpdateException;
    TblCustomer getCustomerById(int id) throws NotFoundException;
    List<TblCustomer> searchCustomerByFirstName(String fisrtname) throws NotFoundException;
    List<TblCustomer> searchCustomerByLastName(String lastname) throws NotFoundException;
    List<TblCustomer> searchCustomerByPhone(String phoneNumber) throws NotFoundException;
    List<TblCustomer> searchAllCustomers();
    Page<TblCustomer> searchAllCustomersByNameForJqgrid(String name, Pageable pageable) throws  NotFoundException;
    Page<TblCustomer> searchAllCustomersByPhoneForJqgrid(String phone, Pageable pageable) throws  NotFoundException;
    Page<TblCustomer> findAllCustomers(Pageable pageable);
    boolean deleteCustomer(int id) ;
    boolean activateCustomer(int id) throws UpdateException;
    boolean desactivateCustomer(int id) throws UpdateException;
}
