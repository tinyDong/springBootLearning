package com.example.api.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/")
@Controller
public class userController {

    private static final Logger logger=LoggerFactory.getLogger(userController.class);

    @RequestMapping("regist")
    @ResponseBody
    public String regist(){
        logger.info("regist");
        return "hello,regist";
    }
}
