package com.yzy.controller;


import com.yzy.e.ServiceException;
import com.yzy.param.MessageParam;
import com.yzy.service.ChatGPTService;
import com.yzy.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/chat")
public class ChatController {



    @Resource
    ChatGPTService chatGPTService;

    @PostMapping("/send")
    public Result send(@RequestBody MessageParam param) throws ServiceException, IOException {
        String replyMessage = chatGPTService.getChatGPTReply(param);
        return Result.success(replyMessage);
    }



}
