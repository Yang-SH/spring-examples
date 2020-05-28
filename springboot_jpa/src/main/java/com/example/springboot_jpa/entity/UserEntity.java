package com.example.springboot_jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class UserEntity {

    /**
     * @Id 表明实体主键为整数类型，
     * @GeneratedValue 表明主键值生成策略，默认选项AUTO，可选值为 TABLE， SEQUENCE， IDENTITY，AUTO 
     * AUTO在下面几种选项中自动选择
     * IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
     * SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
     * TABLE 提供特定的数据库产生主键, 该方式更有利于数据库的移植
     * @Column注解，用来标识实体类中属性与数据表中字段的对应关系
     */
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
