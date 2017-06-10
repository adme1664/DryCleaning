package com.adme.dry.repository;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Adme System on 6/10/2017.
 */
public class MainRepositoryImpl implements MainRepository {

    //region Injection des repositories
    @Qualifier("colorRepository")
    @Autowired
    ColorRepository colorRepository;

    @Qualifier("customerRepository")
    @Autowired
    CustomerRepository customerRepository;

    @Qualifier("detailsTicketRepository")
    @Autowired
    DetailsTicketRepository detailsTicketRepository;

    @Qualifier("employeeRepository")
    @Autowired
    EmployeeRepository employeeRepository;

    @Qualifier("enterpriseRepository")
    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Qualifier("paymentRepository")
    @Autowired
    PaymentRepository paymentRepository;

    @Qualifier("pieceRepository")
    @Autowired
    PieceRepository pieceRepository;

    @Qualifier("serviceRepository")
    @Autowired
    ServiceRepository serviceRepository;

    @Qualifier("ticketRepository")
    @Autowired
    TicketRepository ticketRepository;

    @Qualifier("typeEmployeeRepository")
    @Autowired
    TypeEmployeeRepository typeEmployeeRepository;

    @Qualifier("typePieceRepository")
    @Autowired
    TypePieceRepository typePieceRepository;
    //endregion

    //region Creation of getters for access the repository
    @Override
    public ColorRepository getColorRepository() {
        return colorRepository;
    }


    @Override
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    @Override
    public DetailsTicketRepository getDetailsTicketRepository() {
        return detailsTicketRepository;
    }

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public EnterpriseRepository getEnterpriseRepository() {
        return enterpriseRepository;
    }

    @Override
    public PaymentRepository getPaymentRepository() {
        return paymentRepository;
    }

    @Override
    public PieceRepository getPieceRepository() {
        return pieceRepository;
    }

    @Override
    public ServiceRepository getServiceRepository() {
        return serviceRepository;
    }

    @Override
    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    @Override
    public TypeEmployeeRepository getTypeEmployeeRepository() {
        return typeEmployeeRepository;
    }

    @Override
    public TypePieceRepository getTypePieceRepository() {
        return typePieceRepository;
    }
    //endregion
}
