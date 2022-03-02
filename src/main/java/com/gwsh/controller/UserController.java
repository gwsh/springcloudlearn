package com.gwsh.controller;

import com.gwsh.config.SwaggerTagsValue;
import com.gwsh.entities.User;
import com.gwsh.service.UserService;
import com.gwsh.utils.RestResult;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@Api(tags = SwaggerTagsValue.USER_CONTROLLER_TAG)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取用户列表
     *
     * @return 返回用户列表对象
     */
    @ApiOperation(value = "查询用户", notes = "查询用户信息。")

    @GetMapping("/getAllUserList")
    public RestResult<List<User>> getAllUsers() {
        List<User>             _list      = this.userService.getAllUsers();
        RestResult<List<User>> restResult = new RestResult<>();
        return restResult.success(_list);
    }

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "根据id删除用户信息。")
    @ApiImplicitParam(
            name = "id", value = "用户id", readOnly = true, dataType = "int", paramType = "path"
    )
    @ApiResponse(
            responseCode = "1", description = "成功", ref = "ref")
    @ApiResponse(
            responseCode = "0", description = "失败", ref = "ref")
    public void deleteUserById(@PathVariable Integer id) {
        this.userService.delete(id);
    }

}
