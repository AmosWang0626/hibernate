package com.amos.hibernate.dao.entity;

import com.amos.hibernate.common.api.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * 模块名称: hibernate
 * 模块描述: 用户地址信息
 *
 * @author amos.wang
 * @date 2020/8/8 19:04
 */
@Getter
@Setter
@Entity
@Table(name = "org_user_address")
public class UserAddressEntity extends BaseEntity {

    private String name;

    private String phoneNo;

    private String address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAddressEntity that = (UserAddressEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phoneNo, that.phoneNo) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, phoneNo, address);
    }
}
