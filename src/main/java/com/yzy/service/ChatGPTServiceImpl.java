package com.yzy.service;


import com.yzy.e.ServiceException;
import com.yzy.param.MessageParam;
import com.yzy.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGPTServiceImpl implements ChatGPTService{



    @Resource
    private Environment env;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String getChatGPTReply(MessageParam param) throws ServiceException, IOException {
        String chatGPTKey = env.getProperty("CHAT_GPT_KEY");
        if (StringUtils.isEmpty(chatGPTKey)){
            throw new ServiceException("key缺失");
        }
        String url = "https://api.openai.com/v1/chat/completions";

        String model = "gpt-3.5-turbo";
        double temperature = 0.7;
        Map<String, Object> params = new HashMap<>();
        params.put("model", model);
        HashMap<String, String> message = new HashMap<>();
        message.put("role","user");
        message.put("content",param.getMessage());
        params.put("messages", Arrays.asList(message));
        params.put("temperature", temperature);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        System.out.println(response.getStatusCodeValue() + " " + response.getBody());

        return "success";
    }

    public static void main(String[] args) {
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";
        new RestTemplate().postForEntity(url, new HttpEntity<>(new Result()), String.class);


        HttpHeaders headers =  new HttpHeaders();

        Result body = new Result();
        HttpEntity<Result> reqEntity = new HttpEntity<Result>(body, null);

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        requestFactory.setProxy(proxy);
        RestTemplate restTemplate = new RestTemplate(requestFactory);


        new RestTemplateBuilder()

                .setConnectTimeout(Duration.ofSeconds(100))
                .setReadTimeout(Duration.ofSeconds(100))
                .build().exchange(url,HttpMethod.POST,reqEntity, Result.class);
//        double temperature = 0.7;
//        Map<String, Object> params = new HashMap<>();
//        params.put("model", model);
//        HashMap<String, String> message = new HashMap<>();
//        message.put("role","user");
//        message.put("content","在吗");
//        params.put("messages", Arrays.asList(message));
//        params.put("temperature", temperature);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer " + token);
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = new RestTemplate().postForEntity(url, requestEntity, String.class);
//        System.out.println(response.getStatusCodeValue() + " " + response.getBody());
    }

}
