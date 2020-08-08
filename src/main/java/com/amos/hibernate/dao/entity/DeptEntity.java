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
 * 模块描述: 部门
 *
 * @author amos.wang
 * @date 2020/8/8 11:42
 */
@Getter
@Setter
@Entity
@Table(name = "org_dept")
public class DeptEntity extends BaseEntity {

    private String name;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private DeptEntity parent;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "org_dept_role", joinColumns = {@JoinColumn(name = "dept_id")},
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
        DeptEntity that = (DeptEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, description);
    }

}
