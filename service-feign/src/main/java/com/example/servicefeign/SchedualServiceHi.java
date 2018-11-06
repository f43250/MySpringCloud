package com.example.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author FLE
 * @description feign接口
 * @time 2018/7/5 11:07
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    /**
     * @Descrption
     * @author FLE       
     * @date 2018/7/11 14:34  
     * @param [name]
     * @return java.lang.String  
     */ 
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
