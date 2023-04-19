package com.yzy.service;

import com.yzy.e.ServiceException;
import com.yzy.param.MessageParam;

public interface ChatGPTService {


    String getChatGPTReply(MessageParam param) throws ServiceException;
}
