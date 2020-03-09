package com.praveen.cms.api.security;

import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.entity.Customer;
import com.praveen.cms.api.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {

    private final Logger logger = LogManager.getLogger(getClass().getName());
    @Autowired
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("\n\n :::Security Step 4::: "+getClass().getName()+"\n\n");

        UserPrincipal userPrincipal = new UserPrincipal();
        UserPrincipal userPrincipal1 = null;
        Customer customer = customerService.getCustomerByEmail(email);
        if(customer == null)
            throw new InternalAuthenticationServiceException(AppConstants.ErrorMessages.CUSTOMER_NOT_EXISTS_ERROR_MESSAGE);
        else{
            userPrincipal1 = userPrincipal.create(customer);
        }
        return userPrincipal1;
    }
}
