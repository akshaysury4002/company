package com.as.company.exception;

public class DeptNotFoundException extends RuntimeException {
    
    public DeptNotFoundException(String msg)
    {
        super("dept Not Found");
    }

}
