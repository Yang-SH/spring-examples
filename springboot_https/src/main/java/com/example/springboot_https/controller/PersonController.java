package com.example.springboot_https.controller;

import com.example.springboot_https.entity.Person;
import com.example.springboot_https.entity.Result;
import com.example.springboot_https.repository.PersonRepository;
import com.example.springboot_https.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制器，处理Http/https请求（RESTful API）
 */

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    /**
     * 查询所有人员列表（Get方式-@GetMapping）
     * @return
     */
    @GetMapping(value = "/person")
    private List<Person> personlist() {
        return personRepository.findAll();
    }

    /**
     * 添加人员 (Post方式-@PostMapping)
     * @param person
     * @return
     */
    @PostMapping(value = "/person")
    public Result personAdd(HttpServletRequest request, @RequestBody Person person) {
        return ResultUtil.sucess(personRepository.save(person));
    }
}

