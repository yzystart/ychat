package com.yzy.e;


import lombok.Data;

@Data
public class ServiceException extends Exception{

    public ServiceException(String message){
        super(message);
    }

}
