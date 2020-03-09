package com.praveen.cms.api.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddCustomerBo {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
