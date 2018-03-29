package com.example.redismybatisweb.controller;

import com.example.redismybatisweb.dao.UserBasic;
import com.example.redismybatisweb.mapper.UserBasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserBasicMapper userBasicMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("regist")
    @ResponseBody
    public String regist(){
        UserBasic user=new UserBasic();
        user.setRegistTime(new Date());
        user.setTelephone("12345678901");
        user.setUserCode("asdsad");
        userBasicMapper.insertSelective(user);
        return "success";
    }


    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(String id){


        ValueOperations<String,UserBasic> operations = redisTemplate.opsForValue();
        boolean hasKey=redisTemplate.hasKey("user_"+id);
        UserBasic userBasic=null;
        if (hasKey){
            userBasic=operations.get("user_"+id);
            logger.info("缓存中取到了user id={}",id);
        }else {
            userBasic=userBasicMapper.selectByPrimaryKey(id);
        }
        if (userBasic!=null){
            return userBasic.toString();
        }else {
            return "failure";
        }

    }

    @RequestMapping("putInRedis")
    @ResponseBody
    public String putInRedis(String id){
        UserBasic userBasic=userBasicMapper.selectByPrimaryKey(id);
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        operations.set("user_"+id,userBasic);
        return "success";
    }

}
