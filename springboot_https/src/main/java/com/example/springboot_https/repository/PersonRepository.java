package com.example.springboot_https.repository;

import com.example.springboot_https.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository，实现与数据库交互(JPA支持自动生成一些基本CURD SQL语句)
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
