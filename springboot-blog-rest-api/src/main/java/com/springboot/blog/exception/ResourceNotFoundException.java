package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This is a custom exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)//cause spring boot to respond with specified HTTP status code whenever this exception is thrown from controller
public class ResourceNotFoundException extends RuntimeException {
   private String resourceName;
   private String fieldName;
   private Long fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
