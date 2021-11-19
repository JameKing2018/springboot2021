package org.wzw.alibabanacosdiscoveryclientcommon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosDiscoveryClientCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientCommonApplication.class, args);
    }

    @RestController
    @Slf4j
    static class TestController{

        @Autowired
        LoadBalancerClient loadBalancerClient;

        @GetMapping("/test")
        public String test(){
            ServiceInstance serviceInstance=loadBalancerClient.choose("alibaba-nacos-discovery-server");
            String url=serviceInstance.getUri()+"/hello?name="+"snow51";
            RestTemplate restTemplate=new RestTemplate();
            String result=restTemplate.getForObject(url,String.class);
            return result;
        }
    }

}