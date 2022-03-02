package com.gwsh.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户实体")
public class User implements Serializable {
    private static final Long    serialVersionUID = 1L;
    @ApiModelProperty("用户ID")
    private              Integer id;
    @ApiModelProperty("用户名")
    private              String  username;
    @ApiModelProperty("地址")
    private              String  addrees;

    public User(Integer id, String username, String addrees) {
        this.id = id;
        this.username = username;
        this.addrees = addrees;
    }
}
