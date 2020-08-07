package com.amos.hibernate.dao;

import com.amos.hibernate.dao.entity.UserEntity;
import com.amos.hibernate.dao.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 模块名称: hibernate
 * 模块描述: UserTests
 *
 * @author amos.wang
 * @date 2020/8/7 22:46
 */
@SpringBootTest
public class UserTests {

    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private UserRepository userRepository;

    private static String TEST_ID;


    /**
     * 测试一条龙
     */
    @Test
    public void integrate() {
        create();
        findById();

        update();
        findById();

        delete();
        findById();
    }

    @Test
    public void create() {
        UserEntity entity = new UserEntity();
        entity.setUsername("AMOS");
        entity.setPassword("000000");
        entity.setSalt("#0626");

        userRepository.save(entity);

        TEST_ID = entity.getId();
    }

    @Test
    public void update() {
        userRepository.findById(TEST_ID)
                .ifPresent(entity -> {
                    entity.setUsername("AMOS" + System.currentTimeMillis());
                    entity.setPassword(String.valueOf(System.currentTimeMillis()));

                    userRepository.save(entity);
                });
    }

    @Test
    public void delete() {
        userRepository.findById(TEST_ID).ifPresent(entity -> userRepository.deleteLogic(entity));
    }

    @Test
    public void findById() {
        userRepository.findById(TEST_ID).ifPresent(entity -> {
            try {
                System.out.println(objectMapper.writeValueAsString(entity));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
