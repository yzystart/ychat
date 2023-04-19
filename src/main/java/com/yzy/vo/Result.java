package com.yzy.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result{


    Object data;
    Integer code;
    String message;


    public static Result success(Object data){
        return new Result(data,200,"success");
    }

    public static Result error(String message){
        return new Result(message,500,"error!");
    }
}
