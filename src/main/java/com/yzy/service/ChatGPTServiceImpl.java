package com.yzy.service;


import com.yzy.e.ServiceException;
import com.yzy.param.MessageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class ChatGPTServiceImpl implements ChatGPTService{



    @Resource
    private Environment env;

    @Override
    public String getChatGPTReply(MessageParam param) throws ServiceException {
        String chatGPTKey = env.getProperty("CHAT_GPT_KEY");
        if (StringUtils.isEmpty(chatGPTKey)){
            throw new ServiceException("key缺失");
        }
        return "success";
    }

}
