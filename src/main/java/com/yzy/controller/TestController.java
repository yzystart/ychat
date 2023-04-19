package com.yzy.controller;


import com.yzy.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/test")
public class TestController {

   @GetMapping("/test")
   public Result test(){
       return Result.success("test!");
   }

    @PostMapping("/success")
    public Result success(){
        return Result.success("success!");
    }

    @PostMapping("/error")
    public Result error(){
       throw new NullPointerException();
   }


    @PostMapping("/ping")
    public Result ping(){

        InetAddress ip = null;
        String resultIp="";
        try {
            ip = InetAddress.getLocalHost();
            resultIp = ip.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return Result.success(resultIp);
   }


}
