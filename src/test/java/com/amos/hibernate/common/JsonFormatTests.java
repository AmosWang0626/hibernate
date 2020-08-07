package com.amos.hibernate.common;

import com.amos.hibernate.dao.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 模块名称: hibernate
 * 模块描述: Json
 *
 * @author amos.wang
 * @date 2020/8/7 23:30
 */
@SpringBootTest
public class JsonFormatTests {

    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void writeValueAsString() throws JsonProcessingException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1234567890");
        userEntity.setUsername("amos");
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setCreateUser("create");
        userEntity.setDeleteFlag(false);

        System.out.println(objectMapper.writeValueAsString(userEntity));
    }

}
