package org.gold.reststack.controller;

import org.gold.reststack.annotation.API;
import org.gold.reststack.models.User;
import org.gold.reststack.service.UserServiceIml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwr on 2016.3.22.
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceIml userServiceIml;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @API(name = "首页展示",auth = false,params = {"name:姓名"},reqClass = User.class,respClass = User.class)
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public Object home(){
        logger.info("=====================info");
        logger.error("==================================error");
        logger.warn("============================warn");
        logger.debug("===========================debug");
        return new User();
    }
}
