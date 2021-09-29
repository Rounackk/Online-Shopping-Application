package com.sprint.OnlineShoppingApplication.Exception;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;


public class ValidateCustomer extends Exception{
    private final List<FieldError> errorList;

    public ValidateCustomer(){
        super();
        this.errorList=null;
    }

    public ValidateCustomer(List<FieldError> errorList) {
        this.errorList = null;
    }

    public ValidateCustomer(String message) {
        super(message);
        this.errorList = null;
    }

    public List<FieldError> getErrorList() {
        return errorList;
    }
}
