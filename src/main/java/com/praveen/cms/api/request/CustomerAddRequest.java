package com.praveen.cms.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerAddRequest {

    @NotBlank(message = "First Name should not BLANK")
    @NotNull(message = "First Name can't be NULL")
    private String firstName;

    @NotBlank(message = "Last Name should not BLANK")
    @NotNull(message = "Last Name can't be NULL")
    private String lastName;

    @NotBlank(message = "Email should not BLANK")
    @NotNull(message = "Email can't be NULL")
    private String email;

    @NotBlank(message = "Password should not BLANK")
    @NotNull(message = "Password can't be NULL")
    private String password;
}
