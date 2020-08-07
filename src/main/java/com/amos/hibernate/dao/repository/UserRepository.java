package com.amos.hibernate.dao.repository;

import com.amos.hibernate.common.api.BaseRepository;
import com.amos.hibernate.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 模块名称: hibernate
 * 模块描述: UserRepository
 *
 * @author amos.wang
 * @date 2020/8/7 22:12
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity, String> {

}
