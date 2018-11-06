package com.example.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author FLE
 * @description 测试Service
 * @time 2018/7/4 18:22
 */
@Service
public class HelloService {

    @Autowired      //类似于一个WebService客户端请求的模版，可以调用http请求的WebService，并将结果转换成相应的对象类型。
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")     //创建熔断器功能,并指定fallbackMethod熔断方法
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
