package com.sprint.OnlineShoppingApplication.Dto;

import com.sprint.OnlineShoppingApplication.model.Address;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerDto {
    private Integer customerId;
    @NotBlank(message = "First Name is Required")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Mobile number cannot be empty")
    private String mobileNumber;
    private String email;
    private Integer addressId;

    private String password;
    private String role;
}
