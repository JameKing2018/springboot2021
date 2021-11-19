package org.wzw.alibabanacosdiscoveryclientcommon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaNacosDiscoveryClientCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientCommonApplication.class, args);
    }

    @RestController
    @Slf4j
    static class TestController{

        @Autowired
        LoadBalancerClient loadBalancerClient;

        @Autowired
        RestTemplate restTemplate;

        @Autowired
        Client client;


        @GetMapping("/test")
        public String test(){

            String result=client.hello(" snow51");
            return result;
        }

        @Bean
        @LoadBalanced
        public RestTemplate restTemplate(){
            return  new RestTemplate();
        }
        @FeignClient("alibaba-nacos-discovery-server")
        interface Client{
            @GetMapping("/hello")
            String hello(@RequestParam(name="name") String name);
        }
    }

}
