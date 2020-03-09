package com.praveen.cms.api.constant;

public interface RestMappingConstants {
    String APP_BASE="/cms";

    public interface CustomerRequestUri{
        String Customer_BASE_URL = APP_BASE + "/customer";
        String GET_CUSTOMER_LIST = "/getCustomers";
        String GET_CUSTOMER_BY_ID = "/getCustomer";
        String SIGNUP_CUSTOMER = "/signup";
        String UPDATE_CUSTOMER = "/updateCustomer";
        String DELETE_CUSTOMER = "/deleteCustomer";
        String PURCHASE_PRODUCTS = "/placeOrder";
        String VIEW_ALL_PURCHASED_PRODUCTS ="/viewPurchasedProducts" ;
        String SIGNIN_CUSTOMER ="/signin" ;
        String SEARCH_CUSTOMER_OR_PRODUCT ="/search" ;
    }

    public interface OrderRequestUri{
        String ORDER_BASE_URL = APP_BASE + "/order";
        String GET_CUSTOMER_BY_ID = "/customer";
        String GET_PRODUCTS_BY_ORDER_ID = "/products";
    }

    public interface ProductRequestUri{
        String PRODUCT_BASE_URL = APP_BASE + "/product";
        String GET_PRODUCT_LIST = "/getProducts";
        String GET_PRODUCT_BY_ID = "/getProduct";
        String ADD_PRODUCT = "/addProduct";
        String UPDATE_PRODUCT = "/updateProduct";
        String DELETE_PRODUCT = "/deleteProduct";
    }

}
