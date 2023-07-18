package com.as.company.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String msg)
    {
        super("role Not Found");
    }
    
}
