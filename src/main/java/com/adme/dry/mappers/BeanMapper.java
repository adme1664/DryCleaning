package com.adme.dry.mappers;

import com.adme.dry.bean.CustomerBean;
import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.bean.TypeEmployeeBean;
import com.adme.dry.entities.TblCustomer;
import com.adme.dry.entities.TblEmployee;
import com.adme.dry.entities.TblTypeEmployee;
import com.adme.dry.models.CustomerGridModel;

/**
 * Created by Adme System on 6/15/2017.
 */
public class BeanMapper {

    public static EmployeeBean MapTo(TblEmployee tblEmployee){
        EmployeeBean bean=new EmployeeBean();
        if(tblEmployee!=null){
            bean.setId(tblEmployee.getId());
            bean.setCreateDate(tblEmployee.getCreateDate());
            bean.setCreateUser(tblEmployee.getCreateUser());
            bean.setEmployeeAdress(tblEmployee.getEmployeeAdress());
            bean.setEmployeeGender(tblEmployee.getEmployeeGender());
            bean.setEmployeeFirstName(tblEmployee.getEmployeeFirstName());
            bean.setEmployeeLastName(tblEmployee.getEmployeeLastName());
            bean.setEmployeePhone(tblEmployee.getEmployeePhone());
            bean.setEmployeeStatus(tblEmployee.getEmployeeStatus());
            bean.setUdpateDate(tblEmployee.getUdpateDate());
            bean.setUpdateUser(tblEmployee.getUpdateUser());
            bean.setEmployeeUsername(tblEmployee.getEmployeeUsername());
            bean.setEmployeePassword(tblEmployee.getEmployeePassword());
            bean.setEmployeeType(MapTo(tblEmployee.getEmployeeType()));
        }
        return bean;
    }

    public static TypeEmployeeBean MapTo(TblTypeEmployee typeEmployee){
        TypeEmployeeBean bean=new TypeEmployeeBean();
        if(typeEmployee!=null){
            bean.setId(typeEmployee.getId());
            bean.setTypeName(typeEmployee.getTypeName());
            bean.setCanAddColor(typeEmployee.getCanAddColor());
            bean.setCanAddCustomer(typeEmployee.getCanAddCustomer());
            bean.setCanAddEmployee(typeEmployee.getCanAddEmployee());
            bean.setCanAddCustomer(typeEmployee.getCanAddCustomer());
            bean.setCanAddPayment(typeEmployee.getCanAddPayment());
            bean.setCanAddPiece(typeEmployee.getCanAddPiece());
            bean.setCanAddService(typeEmployee.getCanAddService());
            //==============<>Dont forget to finish<>=================//
        }
        return bean;
    }
    public static CustomerBean MapTo(TblCustomer customer){
        CustomerBean bean=new CustomerBean();
        if(customer!=null){
            bean.setId(customer.getId());
            bean.setCustomerFirstName(customer.getCustomerFirstName());
            bean.setCustomerLastName(customer.getCustomerLastName());
            bean.setCustomerStatus(customer.getCustomerStatus());
            bean.setCustomerRemarks(customer.getCustomerRemarks());
            bean.setCustomerAdress(customer.getCustomerAdress());
            bean.setCustomerDeliveryMode(customer.getCustomerDeliveryMode());
            bean.setCustomerEmail(customer.getCustomerEmail());
            bean.setCustomerPhone1(customer.getCustomerPhone1());
            bean.setCustomerPhone2(customer.getCustomerPhone2());
            bean.setUpdateDate(customer.getUpdateDate());
            bean.setUpdateUser(customer.getUpdateUser());
            bean.setCreateDate(customer.getCreateDate());
            bean.setCreateUser(customer.getCreateUser());
        }
        return bean;
    }
    public static TblCustomer MapTo(CustomerBean customer){
        TblCustomer entity=new TblCustomer();
        if(customer!=null){
            entity.setId(customer.getId());
            entity.setCustomerFirstName(customer.getCustomerFirstName());
            entity.setCustomerLastName(customer.getCustomerLastName());
            entity.setCustomerStatus(customer.getCustomerStatus());
            entity.setCustomerRemarks(customer.getCustomerRemarks());
            entity.setCustomerAdress(customer.getCustomerAdress());
            entity.setCustomerPhone1(customer.getCustomerPhone1());
        }
        return entity;
    }
    public static CustomerGridModel MapToGridModel(TblCustomer customer){
        CustomerGridModel customerGridModel=new CustomerGridModel();
        if(customer!=null){
            customerGridModel.setId(customer.getId());
            customerGridModel.setCustomerFirstName(customer.getCustomerFirstName());
            customerGridModel.setCustomerLastName(customer.getCustomerLastName());
            customerGridModel.setCustomerPhone1(customer.getCustomerPhone1());

        }
        return customerGridModel;
    }

}
