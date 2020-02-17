package com.praveen.cms.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank(message = "First Name should not BLANK")
    @NotNull(message = "First Name can't be NULL")
    private String firstName;

    @NotBlank(message = "First Name should not BLANK")
    @NotNull(message = "First Name can't be NULL")
    private String lastName;

    @NotBlank(message = "First Name should not BLANK")
    @NotNull(message = "First Name can't be NULL")
    private String email;
}
