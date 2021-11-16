package com.wzw.springboot.restful.domain;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
}
