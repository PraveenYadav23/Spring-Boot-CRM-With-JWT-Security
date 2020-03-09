package com.praveen.cms.api.convertor;

import com.praveen.cms.api.bo.AddCustomerBo;
import com.praveen.cms.api.bo.CustomerSignInBo;
import com.praveen.cms.api.entity.Customer;
import com.praveen.cms.api.request.CustomerAddRequest;
import com.praveen.cms.api.request.CustomerSignInRequest;

public class CustomerConvertor {

    public static AddCustomerBo convertAddCustomerRequestToAddCustomerBo(CustomerAddRequest customerAddRequest){

        AddCustomerBo addCustomerBo = new AddCustomerBo();
        addCustomerBo.setFirstName(customerAddRequest.getFirstName());
        addCustomerBo.setLastName(customerAddRequest.getLastName());
        addCustomerBo.setEmail(customerAddRequest.getEmail());
        addCustomerBo.setPassword(customerAddRequest.getPassword());
        return addCustomerBo;
    }

    public static Customer convertAddCustomerBoToAddCustomerEntity(AddCustomerBo addCustomerBo){

        Customer customer = new Customer();
        customer.setFirstName(addCustomerBo.getFirstName());
        customer.setLastName(addCustomerBo.getLastName());
        customer.setEmail(addCustomerBo.getEmail());
        customer.setPassword(addCustomerBo.getPassword());
        return customer;
    }

}
