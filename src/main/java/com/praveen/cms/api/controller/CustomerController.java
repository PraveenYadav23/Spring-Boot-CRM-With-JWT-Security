package com.praveen.cms.api.controller;

import com.praveen.cms.api.bo.AddCustomerBo;
import com.praveen.cms.api.bo.CustomerSignInBo;
import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.constant.RestMappingConstants;
import com.praveen.cms.api.constant.SecurityConstants;
import com.praveen.cms.api.convertor.CustomerConvertor;
import com.praveen.cms.api.entity.Customer;
import com.praveen.cms.api.request.CustomerAddRequest;
import com.praveen.cms.api.request.CustomerSignInRequest;
import com.praveen.cms.api.request.ProductsRequest;
import com.praveen.cms.api.response.*;
import com.praveen.cms.api.security.JwtTokenProvider;
import com.praveen.cms.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestMappingConstants.CustomerRequestUri.Customer_BASE_URL)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping(path = RestMappingConstants.CustomerRequestUri.GET_CUSTOMER_LIST)
    public ResponseEntity<BaseApiResponse> getCustomers(
            @RequestHeader(value = AppConstants.Common.TOKEN_HEADER, required = true) String token,
            @RequestParam(value = AppConstants.Common.PAGE_NUMBER,defaultValue = "0") int page,
            @RequestParam(value = AppConstants.Common.PAGE_LIMIT,defaultValue = AppConstants.Common.PAGE_LIMIT_VALUE) int limit,
            HttpServletRequest request
    )
    {
        CustomerListResponse customerListResponses = customerService.getCustomers(page,limit);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(customerListResponses);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @GetMapping(path= RestMappingConstants.CustomerRequestUri.GET_CUSTOMER_BY_ID)
    public ResponseEntity<BaseApiResponse> getCustomerById(
            @RequestHeader(value = AppConstants.Common.TOKEN_HEADER, required = true) String token,
            @RequestParam("customerId") Long customerId,HttpServletRequest request)
    {
        CustomerDetailResponse customerDetailResponse = customerService.getCustomerById(customerId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(customerDetailResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @PostMapping(path = RestMappingConstants.CustomerRequestUri.SIGNUP_CUSTOMER)
    public ResponseEntity<BaseApiResponse> signUpCustomer(
            @Valid @RequestBody(required = true) CustomerAddRequest customerAddRequest,HttpServletRequest request)
    {
        AddCustomerBo addCustomerBo = CustomerConvertor.convertAddCustomerRequestToAddCustomerBo(customerAddRequest);
        CustomerAddResponse customerAddResponse = customerService.addCustomer(addCustomerBo);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(customerAddResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @PostMapping(path = RestMappingConstants.CustomerRequestUri.SIGNIN_CUSTOMER)
    public ResponseEntity<BaseApiResponse> signInCustomer(
            @RequestBody CustomerSignInRequest customerSignInRequest,
            HttpServletResponse signinResponse, HttpServletRequest request){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customerSignInRequest.getEmail(),customerSignInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(true);
        signinResponse.setHeader("Access-Control-Allow-Headers",
                "Authorization, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, "
                        + "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        signinResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
        signinResponse.setHeader(AppConstants.Common.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + jwt);

        return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.OK);

    }

    @PutMapping(path=RestMappingConstants.CustomerRequestUri.UPDATE_CUSTOMER)
    public ResponseEntity<Customer> updateCustomer(
            @RequestHeader(value = AppConstants.Common.TOKEN_HEADER, required = true) String token,
            @RequestBody Customer customer,HttpServletRequest request)
    {
         Customer theCustomer = customerService.updateCustomer(customer);
         return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }

    @DeleteMapping(path = RestMappingConstants.CustomerRequestUri.DELETE_CUSTOMER)
    public ResponseEntity<BaseApiResponse> deleteCustomer(
            @RequestHeader(value = AppConstants.Common.TOKEN_HEADER, required = true) String token,
            @RequestParam("customerId") Long customerId,HttpServletRequest request)
    {
        CustomerDeleteResponse customerDeleteResponse = customerService.deleteCustomer(customerId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(customerDeleteResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @PostMapping(path = RestMappingConstants.CustomerRequestUri.PURCHASE_PRODUCTS)
    public ResponseEntity<BaseApiResponse> purchaseProducts(
            @RequestHeader(value = AppConstants.Common.TOKEN_HEADER, required = true) String token,
            @RequestParam("customerId") Long customerId,
            @RequestBody ProductsRequest productRequest,HttpServletRequest request
    ){
        OrderPlacedResponse orderPlacedResponse = customerService.purchaseProductsService(customerId,productRequest);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(orderPlacedResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @GetMapping(path = RestMappingConstants.CustomerRequestUri.VIEW_ALL_PURCHASED_PRODUCTS)
    public ResponseEntity<BaseApiResponse> viewAllProducts(
            @RequestHeader(value = AppConstants.Common.TOKEN_HEADER, required = true) String token,
            @RequestParam(value = AppConstants.Common.PAGE_NUMBER,defaultValue = "0") int page,
            @RequestParam(value = AppConstants.Common.PAGE_LIMIT,defaultValue = AppConstants.Common.PAGE_LIMIT_VALUE) int limit,
            @RequestParam("customerId") Long customerId,HttpServletRequest request
    )
    {
        PurchasedProductsListResponse productsListResponse = customerService.viewAllPurchasedProductList(page,limit,customerId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(productsListResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

//    @GetMapping(path = RestMappingConstants.CustomerRequestUri.SEARCH_CUSTOMER_OR_PRODUCT)
//    public ResponseEntity<BaseApiResponse> searchCustomer(
//            @RequestParam("name") String name,
//            HttpServletRequest request
//    ){
//        List<Customer> customerList = customerService.searchCustomer(name);
//        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(customerList);
//        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
//    }

}
