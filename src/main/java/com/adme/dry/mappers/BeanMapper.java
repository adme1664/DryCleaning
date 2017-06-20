package com.adme.dry.mappers;

import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.bean.TypeEmployeeBean;
import com.adme.dry.entities.TblEmployee;
import com.adme.dry.entities.TblTypeEmployee;

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

}
