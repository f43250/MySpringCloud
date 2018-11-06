package com.example.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @author FLE
 * @description 熔断器方法
 * @time 2018/7/5 14:20
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }
}
