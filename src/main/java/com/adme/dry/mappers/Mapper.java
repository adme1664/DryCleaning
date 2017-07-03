package com.adme.dry.mappers;

import com.adme.dry.bean.CustomerBean;
import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.bean.TypeEmployeeBean;
import com.adme.dry.entities.TblCustomer;
import com.adme.dry.entities.TblEmployee;
import com.adme.dry.entities.TblTypeEmployee;
import com.adme.dry.models.CustomerGridModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

/**
 * Created by Adme System on 6/26/2017.
 */
@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    EmployeeBean tblEmployeeToEmployeeBean(TblEmployee tblEmployee);

    TblEmployee employeeBeanToTblEmployee(EmployeeBean employeeBean);

    TypeEmployeeBean tblTypeEmployeeToTypeEmployeeBean(TblTypeEmployee tblTypeEmployee);

    TblTypeEmployee typeEmployeeBeanToTblTypeEmployee(TypeEmployeeBean typeEmployeeBean);

    CustomerBean tblCustomerToCustomerBean(TblCustomer tblCustomer);

    TblCustomer customerBeanToTblCustomer(CustomerBean customerBean);

    @InheritInverseConfiguration
    CustomerGridModel customerBeanToCustomerGridModel(TblCustomer tblCustomer);
}
