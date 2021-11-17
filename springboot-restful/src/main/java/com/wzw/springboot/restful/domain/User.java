package com.wzw.springboot.restful.domain;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@ApiModel(description = "用户实体类")
@Data
public class User {
    @ApiModelProperty(value = "用户编号")
    private Long id;
    @NotNull
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @NotNull
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
}
