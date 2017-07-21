package com.adme.dry.models;

/**
 * Created by Adme System on 6/29/2017.
 */
public class CustomerGridModel {
    private Integer id;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone1;
    private String customerUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPhone1() {
        return customerPhone1;
    }

    public void setCustomerPhone1(String customerPhone1) {
        this.customerPhone1 = customerPhone1;
    }

    public String getCustomerUpdate() {
        return customerUpdate;
    }

    public void setCustomerUpdate(String customerUpdate) {
        this.customerUpdate = customerUpdate;
    }
}
