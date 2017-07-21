package com.adme.dry.services;

import com.adme.dry.bean.CustomerBean;
import com.adme.dry.constant.Constant;
import com.adme.dry.entities.QTblCustomer;
import com.adme.dry.entities.TblCustomer;
import com.adme.dry.exception.NotFoundException;
import com.adme.dry.exception.SaveException;
import com.adme.dry.exception.UpdateException;
import com.adme.dry.mappers.Mapper;
import com.adme.dry.repository.CustomerRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adme System on 6/21/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Qualifier("customerRepository")
    @Autowired
    CustomerRepository customerRepository;

    @Qualifier("entityManagerFactory")
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    Mapper mapper;

    QTblCustomer qTblCustomer = QTblCustomer.tblCustomer;

    Logger log = Logger.getLogger(CustomerServiceImpl.class);
    private static final String CLASSNAME = "CustomerServiceImpl";
    private static final String ERROR_START_MESSAGE = "<>=======================ERROR/";


    @Override
    public TblCustomer addCustomer(TblCustomer customer) throws SaveException {
        String methodName = "addCustomer";
        try {
            return customerRepository.save(customer);
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            throw new SaveException(Constant.MESSAGE_SAVE_EXCEPTION, ex.getCause());
        }
    }

    @Override
    public TblCustomer updateCustomer(TblCustomer customer) throws UpdateException {
        String methodName = "updateCustomer";
        try {
            log.info("Inisde the service:"+methodName+"Id:"+customer.getId());
            TblCustomer customerToUpdate = getCustomerById(customer.getId());
            if (customerToUpdate.getId() != 0) {
                customerToUpdate.setCustomerId(customer.getCustomerId());
                customerToUpdate.setCreateDate(customer.getCreateDate());
                customerToUpdate.setCreateUser(customer.getCreateUser());
                customerToUpdate.setCustomerAdress(customer.getCustomerAdress());
                customerToUpdate.setCustomerDeliveryMode(customer.getCustomerDeliveryMode());
                customerToUpdate.setCustomerFirstName(customer.getCustomerFirstName());
                customerToUpdate.setCustomerEmail(customer.getCustomerEmail());
                customerToUpdate.setCustomerPhone1(customer.getCustomerPhone1());
                customerToUpdate.setCustomerPhone2(customer.getCustomerPhone2());
                customerToUpdate.setCustomerLastName(customer.getCustomerLastName());
                customerToUpdate.setCustomerPreferedCommunication(customer.getCustomerPreferedCommunication());
                customerToUpdate.setCustomerRemarks(customer.getCustomerRemarks());
                customerToUpdate.setCustomerStatus(customer.getCustomerStatus());
                customerToUpdate.setUpdateDate(customer.getUpdateDate());
                customerToUpdate.setUpdateUser(customer.getUpdateUser());
            }
            return customerRepository.save(customerToUpdate);

        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            throw new UpdateException(Constant.MESSAGE_UPDATE_EXCEPTION, ex.getCause());
        }
    }

    @Override
    public TblCustomer getCustomerById(int id) throws NotFoundException {
        String methodName = "getCustomerById";
        try {
            log.info("The ID:"+id);
            return customerRepository.findOne(id);
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());

        }
        throw new NotFoundException(Constant.MESSAGE_NOT_FOUND, new Throwable());
    }

    @Override
    public List<TblCustomer> searchCustomerByFirstName(String fisrtname) throws NotFoundException {
        String methodName = "searchCustomerByFirstName";
        try {
            JPAQueryFactory queryFactory = new JPAQueryFactory(entityManagerFactory.createEntityManager());
            List<TblCustomer> customers = queryFactory.selectFrom(qTblCustomer).where(qTblCustomer.customerFirstName.like(fisrtname)).fetch();
            return customers;
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
        }
        throw new NotFoundException(Constant.MESSAGE_NOT_FOUND, new Throwable());
    }

    @Override
    public List<TblCustomer> searchCustomerByLastName(String lastname) throws NotFoundException {
        String methodName = "searchCustomerByLastName";
        try {
            JPAQueryFactory queryFactory = new JPAQueryFactory(entityManagerFactory.createEntityManager());
            List<TblCustomer> customers = queryFactory.selectFrom(qTblCustomer).where(qTblCustomer.customerLastName.like(lastname)).fetch();
            return customers;
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
        }
        throw new NotFoundException(Constant.MESSAGE_NOT_FOUND, new Throwable());
    }

    @Override
    public List<TblCustomer> searchCustomerByPhone(String phoneNumber) throws NotFoundException {
        String methodName = "searchCustomerByPhone";
        try {
            JPAQueryFactory queryFactory = new JPAQueryFactory(entityManagerFactory.createEntityManager());
            List<TblCustomer> customers = queryFactory.selectFrom(qTblCustomer).where(qTblCustomer.customerPhone1.like(phoneNumber)).fetch();
            return customers;
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
        }
        throw new NotFoundException(Constant.MESSAGE_NOT_FOUND, new Throwable());
    }

    @Override
    public List<TblCustomer> searchAllCustomers() {
        String methodName = "searchAllCustomers";
        try
        {
           return customerRepository.findAll();
        }
        catch (Exception ex){
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Page<TblCustomer> searchAllCustomersByNameForJqgrid(String name,Pageable pageable) throws NotFoundException {
        String methodName="searchAllCustomersByNameForJqgrid";
        try
        {
            return customerRepository.searchCustomerByName(name,pageable);
        }
        catch (NotFoundException ex){
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<TblCustomer> searchAllCustomersByPhoneForJqgrid(String phone,Pageable pageable) throws NotFoundException {
        String methodName="searchAllCustomersByPhoneForJqgrid";
        try
        {
            return customerRepository.searchCustomerByPhone(phone, pageable);
        }
        catch (NotFoundException ex){
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<TblCustomer> findAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }

    @Override
    public boolean activateCustomer(int id) throws UpdateException {
        String methodName = "activateCustomer";
        try {
            boolean result = false;
            TblCustomer customer = getCustomerById(id);
            if (customer.getId() != null) {
                customer.setCustomerStatus(Constant.ACTIVATE);
                customerRepository.save(customer);
                result = true;
            }
            return result;
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            throw new UpdateException(Constant.MESSAGE_UPDATE_EXCEPTION, ex.getCause());
        }
    }

    @Override
    public boolean desactivateCustomer(int id) throws UpdateException {
        String methodName = "desactivateCustomer";
        try {
            boolean result = false;
            TblCustomer customer = getCustomerById(id);
            if (customer.getId() != null) {
                customer.setCustomerStatus(Constant.DESACTIVATE);
                customerRepository.save(customer);
                result = true;
            }
            return result;

        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            throw new UpdateException(Constant.MESSAGE_UPDATE_EXCEPTION, ex.getCause());
        }
    }
}
