package com.amos.hibernate.dao.entity;

import com.amos.hibernate.common.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * 模块名称: hibernate
 * 模块描述: 用户信息
 *
 * @author amos.wang
 * @date 2020/8/7 22:25
 */
@Getter
@Setter
@Entity
@Table(name = "org_user_info")
public class UserInfoEntity extends BaseEntity {

    private String email;

    private String jobNumber;

    private LocalDate birthday;

}
