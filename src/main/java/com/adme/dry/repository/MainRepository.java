package com.adme.dry.repository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Adme System on 6/10/2017.
 */
public interface MainRepository {

    ColorRepository getColorRepository();
    CustomerRepository getCustomerRepository();
    DetailsTicketRepository getDetailsTicketRepository();
    EmployeeRepository getEmployeeRepository();
    EnterpriseRepository getEnterpriseRepository();
    PaymentRepository getPaymentRepository();
    PieceRepository getPieceRepository();
    ServiceRepository getServiceRepository();
    TicketRepository getTicketRepository();
    TypeEmployeeRepository getTypeEmployeeRepository();
    TypePieceRepository getTypePieceRepository();
}
