package com.adme.dry.services;

import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.entities.QTblEmployee;
import com.adme.dry.entities.QTblTypeEmployee;
import com.adme.dry.mappers.BeanMapper;
import com.adme.dry.repository.EmployeeRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Adme System on 6/15/2017.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Qualifier("entityManagerFactory")
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Qualifier("employeeRepository")
    @Autowired
    EmployeeRepository employeeRepository;

    Logger log = Logger.getLogger(LoginServiceImpl.class);
    JPAQueryFactory queryFactory = null;
    QTblEmployee qTblEmployee = QTblEmployee.tblEmployee;
    QTblTypeEmployee qTblTypeEmployee = QTblTypeEmployee.tblTypeEmployee;

    @Override
    public EmployeeBean findEmployeeByUsername(String employeeUsername) {
        log.info("<>======================Inside login service=======================<>");
        log.info("<>======================Inside login service: Usernamee="+employeeUsername+"=======================<>");
        EmployeeBean bean =BeanMapper.MapTo( employeeRepository.findEmployeeByUsername(employeeUsername));
        if(bean!=null)
            log.info("<>===========================/User found/ name:"+bean.getEmployeeFirstName());
        return bean;
    }

    @Override
    public EmployeeBean findEmployeeByFirstname(String firstName) {
        queryFactory = new JPAQueryFactory(entityManagerFactory.createEntityManager());
        EmployeeBean bean = BeanMapper.MapTo(queryFactory.selectFrom(qTblEmployee).where(qTblEmployee.employeeFirstName.eq(firstName)).fetchOne());
        return bean;
    }
}
