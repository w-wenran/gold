package org.gold.reststack.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.gold.reststack.utils.beannote.Note;

import javax.persistence.*;

/**
 * Created by wangwr on 2016.3.21.
 */
@Entity
@Table(name = "info_users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    @Note("用户ID")
    private Long userId;

    @Note("用户姓名")
    @JsonProperty("user_name")
    @Column(name = "name",length = 32,nullable = false)
    private String name;

    @Note("用户电话号码")
    @JsonProperty("phone_number")
    @Column(name = "phone_number",length = 15,nullable = false)
    private String phoneNumber;

    @Note("用户年龄")
    @JsonProperty("user_age")
    @Column(name = "age",nullable = false)
    private Integer age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
