package com.amos.hibernate.dao.entity;

import com.amos.hibernate.common.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 模块名称: hibernate
 * 模块描述: 用户
 *
 * @author amos.wang
 * @date 2020/8/7 22:10
 */
@Getter
@Setter
@Entity
@Table(name = "org_user")
public class UserEntity extends BaseEntity {

    private String username;

    private String password;

    private String salt;

}
