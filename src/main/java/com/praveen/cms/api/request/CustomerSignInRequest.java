package com.praveen.cms.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSignInRequest {
    private String email;
    private String password;
}
