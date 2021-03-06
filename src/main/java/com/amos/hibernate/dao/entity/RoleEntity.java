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
 * 模块描述: 角色
 *
 * @author amos.wang
 * @date 2020/8/7 22:25
 */
@Getter
@Setter
@Entity
@Table(name = "org_role")
public class RoleEntity extends BaseEntity {

    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "org_user_role", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<UserEntity> users;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "org_dept_role", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "dept_id")})
    private Set<DeptEntity> depts;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, description);
    }

}
