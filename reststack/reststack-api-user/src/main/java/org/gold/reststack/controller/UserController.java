package org.gold.reststack.controller;

import org.gold.reststack.annotation.API;
import org.gold.reststack.models.User;
import org.gold.reststack.runtime.ApiDocumentHandler;
import org.gold.reststack.service.UserServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangwr on 2016.3.22.
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceIml userServiceIml;

    @Autowired
    private ApplicationContext applicationContext;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @API(name = "用户信息获取",auth = false,params = {"user_id:用户id","age:年龄"},respClass = User.class)
    @RequestMapping(value = "/api/users/{user_id}",method = RequestMethod.GET)
    public Object home(@PathVariable Long user_id){
        logger.info("获取用户信息"+user_id);
        return new User();
    }

    @API(name = "添加新用户",auth = false,params = "无",reqClass = User.class,respClass = User.class)
    @RequestMapping(value = "/users/add",method = RequestMethod.POST)
    public Object updateUser(@RequestBody User user){
        return new User();
    }

    @API(name = "更新新用户",auth = false,params = "无",reqClass = User.class,respClass = User.class)
    @RequestMapping(value = "/users/update",method = RequestMethod.POST)
    public Object addUser(@RequestBody User user){
        return new User();
    }

    @API(name = "API接口文档获取",auth = false,params = "无",respData = "html网页文档")
    @RequestMapping(value = "/documents",method = RequestMethod.GET)
    public void apiDocuments(HttpServletRequest request, HttpServletResponse response){
        ApiDocumentHandler.createDocument(applicationContext,request,response);
    }
}
