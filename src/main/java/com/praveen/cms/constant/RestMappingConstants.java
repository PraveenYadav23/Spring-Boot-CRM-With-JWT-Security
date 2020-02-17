package com.praveen.cms.constant;

public interface RestMappingConstants {
    String APP_BASE="/praveen";

    public interface CustomerRequestUri{
        String Customer_BASE_URL = APP_BASE + "/cms";
        String GET_CUSTOMER_LIST = "/customers";
        String GET_CUSTOMER_BY_ID = "/customer";
        String ADD_CUSTOMER = "/addCustomer";
        String UPDATE_CUSTOMER = "/updateCustomer";
        String DELETE_CUSTOMER = "/deleteCustomer";
    }

    public interface OrderRequestUri{
        String ORDER_BASE_URL = APP_BASE + "/order";
        String GET_CUSTOMER_BY_ID = "/customer";
        String GET_PRODUCTS_BY_ORDER_ID = "/products";
    }

    public interface ProductRequestUri{
        String PRODUCT_BASE_URL = APP_BASE + "/product";
        String GET_PRODUCT_LIST = "/products";
        String GET_PRODUCT_BY_ID = "/product";
        String ADD_PRODUCT = "/addProduct";
        String UPDATE_PRODUCT = "/updateProduct";
        String DELETE_PRODUCT = "/deleteProduct";
    }

}
