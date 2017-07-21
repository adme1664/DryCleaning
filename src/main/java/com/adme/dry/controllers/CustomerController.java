package com.adme.dry.controllers;

import com.adme.dry.bean.CustomerBean;
import com.adme.dry.bean.SessionBean;
import com.adme.dry.constant.Constant;
import com.adme.dry.entities.TblCustomer;
import com.adme.dry.exception.NotFoundException;
import com.adme.dry.exception.SaveException;
import com.adme.dry.mappers.BeanMapper;
import com.adme.dry.mappers.Mapper;
import com.adme.dry.models.CustomerGridModel;
import com.adme.dry.models.DataTableModel;
import com.adme.dry.models.JQGridResponseModel;
import com.adme.dry.models.RequestCustomerModel;
import com.adme.dry.services.CustomerServiceImpl;
import com.adme.dry.utilities.ComboboxModel;
import com.adme.dry.utilities.DateManager;
import com.adme.dry.utilities.utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Adme System on 6/21/2017.
 */
@Controller("/customer")
@Scope(value = "request")
public class CustomerController {

    private static final String VIEW_BASE = "views/customers/";

    Logger log = Logger.getLogger(CustomerController.class);
    private static final String CLASSNAME = "CustomerController";
    private static final String ERROR_START_MESSAGE = "<>=======================ERROR/";

    @Autowired
    Mapper mapper;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    SessionBean sessionBean;

    @ModelAttribute("beanSession")
    public SessionBean beanSession() {
        return sessionBean;
    }

    @RequestMapping(value = "customer/add", method = RequestMethod.GET)
    public String getCustomer() {
        try {
            beanSession();
            log.info("Variable of Session:" + sessionBean.getCustomUserDetails().getTypeEmployeeBean().getTypeName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return VIEW_BASE + "add";
    }


    @RequestMapping(value = "customer/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customerBean") CustomerBean customerBean, Model model) {
        try {
            beanSession();
            log.info("Name Of customer:" + customerBean.toString());
            log.info("VAriable of Session:" + sessionBean.getCustomUserDetails().getTypeEmployeeBean().getTypeName());

            System.out.println(DateManager.getDateNow());
            if (customerBean != null) {
                customerBean.setCreateUser(sessionBean.getCustomUserDetails().getUsername());
                customerBean.setCreateDate(DateManager.getDateNow());
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
        beanSession();
        List<CustomerBean> searchAllCustomers = new ArrayList<>();
        List<TblCustomer> listOf = customerService.searchAllCustomers();
        for (TblCustomer customer : listOf) {
            CustomerBean bean = mapper.tblCustomerToCustomerBean(customer);
            searchAllCustomers.add(bean);
        }
        model.addAttribute("customers", searchAllCustomers);
        return VIEW_BASE + "search";
    }

    @RequestMapping(value = "customer/listOfCustomersDt", produces = "application/json")
    public
    @ResponseBody
    DataTableModel<CustomerGridModel> listOfCustomersDataTables(
//            @RequestParam(value = "iDisplayStart",required =false) int iDisplayStart,
//            @RequestParam(value = "iDisplayLength",required =false) int iDisplayLength,
//            @RequestParam(value = "iColumns",required =false) int iColumns,
//            @RequestParam(value = "sSearch",required =false) String sSearch,
//            @RequestParam(value = "bRegex",required =false) boolean bRegex,
//            @RequestParam(value = "bSearchable_",required =false) boolean bSearchable_,
//            @RequestParam(value = "sSearch_",required =false) String sSearch_,
//            @RequestParam(value = "bRegex_",required =false) String bRegex_,
//            @RequestParam(value = "bSortable_",required =false) boolean bSortable_,
//            @RequestParam(value = "iSortingCols",required =false) int iSortingCols,
//            @RequestParam(value = "iSortCol_",required =false) int iSortCol_,
//            @RequestParam(value = "sSortDir_",required =false) String sSortDir_,
//            @RequestParam(value = "mDataProp_",required =false) String mDataProp_,
//            @RequestParam(value = "sEcho",required =false) int String
    ) {
        beanSession();
        log.info("Inside of the controller");
        DataTableModel<CustomerGridModel> listOfCustomerGridModels = new DataTableModel<CustomerGridModel>();
//        Pageable pageRequest=new PageRequest()
//        Page<TblCustomer> customers=customerService.findAllCustomers();
        List<TblCustomer> customers = customerService.searchAllCustomers();
        List<CustomerGridModel> listOf = new ArrayList<>();
        for (TblCustomer customer : customers) {
            CustomerGridModel custoGrid = new CustomerGridModel();
            custoGrid.setId(customer.getId());
            custoGrid.setCustomerFirstName(customer.getCustomerFirstName());
            custoGrid.setCustomerLastName(customer.getCustomerLastName());
            custoGrid.setCustomerPhone1(customer.getCustomerPhone1());
            listOf.add(custoGrid);
        }
        log.info("Number of customers:" + listOf.size());
        listOfCustomerGridModels.setRecordsTotal(listOf.size());
        listOfCustomerGridModels.setRecordsFiltered(1);
        listOfCustomerGridModels.setDraw(10);
//        listOfCustomerGridModels.setError("Error while loading the customer");
        listOfCustomerGridModels.setData(listOf);
        return listOfCustomerGridModels;
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
    public String getCustomerInformation(@RequestParam("id") String id, Model model) {
        String methodName = "getCustomerInformation";
        try {
            beanSession();
            if (id != null && !id.equalsIgnoreCase("")) {
                log.info("Customer number" + id);
                int customerId = Integer.parseInt(id);
                CustomerBean customerBean = mapper.tblCustomerToCustomerBean(customerService.getCustomerById(customerId));
                log.info("Customer name" + customerBean.getCustomerFirstName());
                model.addAttribute("customer", customerBean);
                return VIEW_BASE + "customerDetails";
            }
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            ex.printStackTrace();
        }
        return VIEW_BASE + "customerDetails";
    }

    @RequestMapping(value = "customer/updateCustomer", method = RequestMethod.GET)
    public String updateCustomer(@RequestParam("id") String id, Model model) {
        String methodName = "updateCustomer";
        try {
            int customerId = Integer.parseInt(id);
            CustomerBean customerBean = mapper.tblCustomerToCustomerBean(customerService.getCustomerById(customerId));
            log.info("Customer name" + customerBean.getCustomerFirstName());
            model.addAttribute("customer", customerBean);
            List<ComboboxModel> comboboxModels = new ArrayList<>();
            for (int i = 1; i <= utils.mapOfTypeCommunication().size(); i++) {
                ComboboxModel cmb = new ComboboxModel();
                cmb.setId(i);
                cmb.setValue(utils.mapOfTypeCommunication().get(i).toString());
                comboboxModels.add(cmb);
            }
            model.addAttribute("typeCommunications", comboboxModels);
            ComboboxModel selected = new ComboboxModel();
            selected.setId(Integer.parseInt(customerBean.getCustomerPreferedCommunication()));
            selected.setValue(utils.mapOfTypeCommunication().get(Integer.parseInt(customerBean.getCustomerPreferedCommunication())).toString());
            model.addAttribute("selected", selected);
        } catch (Exception ex) {
            log.info(ERROR_START_MESSAGE + "" + CLASSNAME + "/" + methodName + ":" + ex.getMessage());
            ex.printStackTrace();
        }
        return VIEW_BASE + "updateCustomer";
    }

    @RequestMapping(value = "customer/updateCustomer", method = RequestMethod.POST)
    public
    @ResponseBody
    CustomerBean updateCustomer(@ModelAttribute("customerBean") CustomerBean customerBean) {
        try {
            if (customerBean != null) {
                log.info("Inside update Customer:" + customerBean.getId());
                CustomerBean customerToUpdate = mapper.tblCustomerToCustomerBean(customerService.getCustomerById(customerBean.getId()));
                log.info("Customer found:" + customerToUpdate.getId());
                customerToUpdate.setCustomerFirstName(customerBean.getCustomerFirstName());
                customerToUpdate.setCustomerLastName(customerBean.getCustomerLastName());
                customerToUpdate.setCustomerAdress(customerBean.getCustomerAdress());
                customerToUpdate.setCustomerEmail(customerBean.getCustomerEmail());
                customerToUpdate.setCustomerPhone1(customerBean.getCustomerPhone1());
                customerToUpdate.setCustomerPhone2(customerBean.getCustomerPhone2());
                customerToUpdate.setCustomerDeliveryMode(customerBean.getCustomerDeliveryMode());
                customerToUpdate.setCustomerPreferedCommunication(customerBean.getCustomerPreferedCommunication());
                customerToUpdate.setCustomerStatus(customerBean.getCustomerStatus());
                customerToUpdate.setCustomerRemarks(customerBean.getCustomerRemarks());
                customerToUpdate.setUpdateDate(DateManager.getDateNow());
                customerToUpdate.setUpdateUser(sessionBean.getCustomUserDetails().getUsername());
                customerToUpdate = mapper.tblCustomerToCustomerBean(customerService.updateCustomer(mapper.customerBeanToTblCustomer(customerToUpdate)));
                return customerToUpdate;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CustomerBean();

    }
}
