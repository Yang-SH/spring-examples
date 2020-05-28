package com.example.springboot_druid.controller;

import com.example.springboot_druid.entity.UserEntity;
import com.example.springboot_druid.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        //  这里的findAll方法，springDataJpa会给它一个的实现，所以我们可以直接调用
        //  findAll()方法就是SpringDataJPA为我们提供的内置方法
        return userJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        //  save()方法也是SpringDataJPA为我们提供的内置方法
        return userJPA.save(entity);
    }

    /**
     * 删除用户方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }



}
