package com.adme.dry.controllers;

import com.adme.dry.bean.CustomerBean;
import com.adme.dry.constant.Constant;
import com.adme.dry.entities.TblCustomer;
import com.adme.dry.exception.SaveException;
import com.adme.dry.mappers.BeanMapper;
import com.adme.dry.mappers.Mapper;
import com.adme.dry.models.CustomerGridModel;
import com.adme.dry.models.JQGridResponseModel;
import com.adme.dry.models.RequestCustomerModel;
import com.adme.dry.services.CustomerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Adme System on 6/21/2017.
 */
@Controller("/customer")
public class CustomerController {

    private static final String VIEW_BASE = "views/customers/";

    Logger log = Logger.getLogger(CustomerController.class);
    private static final String CLASSNAME = "CustomerController";
    private static final String ERROR_START_MESSAGE = "<>=======================ERROR/";

    @Autowired
    Mapper mapper;

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping(value = "customer/add", method = RequestMethod.GET)
    public String getCustomer() {
        return VIEW_BASE + "add";
    }

    @RequestMapping(value = "customer/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customerBean") CustomerBean customerBean, Model model) {
        try {
            log.info("Name Of customer:" + customerBean.toString());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dateNow = dateFormat.format(date);
            System.out.println(dateFormat.format(date));
            if (customerBean != null) {
                customerBean.setCreateUser("ADMIN");
                customerBean.setCreateDate(dateNow);
                TblCustomer tblCustomer = mapper.customerBeanToTblCustomer(customerBean);
                TblCustomer result = customerService.addCustomer(tblCustomer);
                if (result.getId() != 0) {
                    log.info("" + Constant.MESSAGE_SAVE_SUCCESS);
                    model.addAttribute("customer", result);
                }
            }
        } catch (SaveException ex) {
            log.info("" + Constant.MESSAGE_SAVE_EXCEPTION);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return VIEW_BASE + "add";
    }

    @RequestMapping(value = "customer/search", method = RequestMethod.GET)
    public String searchAllCustomers(Model model) {
        List<CustomerBean> searchAllCustomers = new ArrayList<>();
        List<TblCustomer> listOf = customerService.searchAllCustomers();
        for (TblCustomer customer : listOf) {
            CustomerBean bean = mapper.tblCustomerToCustomerBean(customer);
            searchAllCustomers.add(bean);
        }
        model.addAttribute("customers", searchAllCustomers);
        return VIEW_BASE + "search";
    }

    @RequestMapping(value = "customer/listOfCustomers", produces = "application/json")
    public
    @ResponseBody
    JQGridResponseModel<CustomerGridModel> listOfCustomers(
            @RequestParam(value = "_search", required = false) boolean search,
            @RequestParam(value = "filters", required = false) String filters,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "page", required = false) int page,
            @RequestParam(value = "rows", required = false) int rows,
            @RequestParam(value = "sidx", required = false) String sidx,
            @RequestParam(value = "sord", required = false) String sord
    ) {
        log.info("Inside the cotroller");
        log.info("Search:" + search);
        RequestCustomerModel requestCustomerModel = new RequestCustomerModel();
        requestCustomerModel.setFirstName(firstName);
        requestCustomerModel.setPhone(phone);
        Pageable pageRequest = new PageRequest(page - 1, rows);
        if (search == true) {
            return getFilteredCustomers(requestCustomerModel, pageRequest);
        } else {
            List<CustomerGridModel> customerBeanList = new ArrayList<>();
            Page<TblCustomer> customers = customerService.findAllCustomers(pageRequest);
            log.info("Number of Customers found:" + customers.getTotalElements());
            for (TblCustomer customer : customers) {
                CustomerGridModel customerGridModel = BeanMapper.MapToGridModel(customer);
                customerBeanList.add(customerGridModel);
            }
            log.info("List Of CustomerBeans:" + customerBeanList.size());
            JQGridResponseModel<CustomerGridModel> reponse = new JQGridResponseModel<CustomerGridModel>();
            reponse.setRows(customerBeanList);
            reponse.setRecords(Long.toString(customers.getTotalElements()));
            reponse.setPage(Long.toString(customers.getNumber() + 1));
            reponse.setTotal(Long.toString(customers.getTotalPages()));
            return reponse;
        }
    }

    public JQGridResponseModel<CustomerGridModel> getFilteredCustomers(RequestCustomerModel filter, Pageable request) {
        String methodName = "getFilteredCustomers";
        try {
            Page<TblCustomer> customersPage = null;
            if (filter != null) {
                if (filter.getFirstName() != null && !filter.getFirstName().equalsIgnoreCase("")) {
                    customersPage = customerService.searchAllCustomersByNameForJqgrid(filter.getFirstName(), request);
                    log.info("Inside CustomerController:/number of cusstomers found:" + customersPage.getTotalElements());
                }
                if (filter.getPhone() != null && !filter.getPhone().equalsIgnoreCase("")) {
                    customersPage = customerService.searchAllCustomersByPhoneForJqgrid(filter.getPhone(), request);
                    log.info("Inside CustomerController:/number of cusstomers found:" + customersPage.getTotalElements());
                }
                List<CustomerGridModel> customerBeansList = new ArrayList<>();
                if (customersPage.getTotalElements() != 0) {
                    for (TblCustomer customer : customersPage) {
                        CustomerGridModel bean = BeanMapper.MapToGridModel(customer);
                        customerBeansList.add(bean);
                    }
                    JQGridResponseModel<CustomerGridModel> reponse = new JQGridResponseModel<>();
                    reponse.setRows(customerBeansList);
                    reponse.setRecords(Long.toString(customersPage.getTotalElements()));
                    reponse.setPage(Long.toString(customersPage.getNumber() + 1));
                    reponse.setTotal(Long.toString(customersPage.getTotalPages()));
                    return reponse;
                } else {
                    Page<TblCustomer> customers = customerService.findAllCustomers(request);
                    customerBeansList = new ArrayList<>();
                    for (TblCustomer customer : customers) {
                        CustomerGridModel bean = BeanMapper.MapToGridModel(customer);
                        customerBeansList.add(bean);
                    }
                    JQGridResponseModel<CustomerGridModel> reponse = new JQGridResponseModel<>();
                    reponse.setRows(customerBeansList);
                    reponse.setRecords(Long.toString(customersPage.getTotalElements()));
                    reponse.setPage(Long.toString(customersPage.getNumber() + 1));
                    reponse.setTotal(Long.toString(customersPage.getTotalPages()));
                    return reponse;
                }
            }

        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "customer/getCustomer", method = RequestMethod.GET)
    public
    String getCustomerInformation(@RequestParam("id") String id,Model model){
        String methodName = "getCustomerInformation";
        try
        {
            if(id!=null && !id.equalsIgnoreCase("")){
                log.info("Customer number"+id);
                int customerId=Integer.parseInt(id);
                CustomerBean customerBean=mapper.tblCustomerToCustomerBean(customerService.getCustomerById(customerId));
                log.info("Customer name"+customerBean.getCustomerFirstName());
                model.addAttribute("customer",customerBean);
                return VIEW_BASE+ "customerDetails";
            }
        }
        catch (Exception ex){
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            ex.printStackTrace();
        }
        return VIEW_BASE+"customerDetails";
    }
}
