package com.studentnew.demo.exceptions;

public class DuplicateEntityException extends RuntimeException{
    public DuplicateEntityException(String messege){
        super(messege);
    }
}
