package com.amos.hibernate.dao.entity;

import com.amos.hibernate.common.api.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;

    @JsonIgnore
    @OneToOne(targetEntity = UserInfoEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id")
    private UserInfoEntity userInfo;

    @JsonIgnore
    @OneToOne(targetEntity = DeptEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private DeptEntity dept;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserAddressEntity> addresses;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "org_user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleEntity> roles;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), username, password, salt);
    }

}
