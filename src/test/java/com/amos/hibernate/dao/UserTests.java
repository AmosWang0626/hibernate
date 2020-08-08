package com.amos.hibernate.dao;

import com.amos.hibernate.dao.entity.DeptEntity;
import com.amos.hibernate.dao.entity.UserAddressEntity;
import com.amos.hibernate.dao.entity.UserEntity;
import com.amos.hibernate.dao.entity.UserInfoEntity;
import com.amos.hibernate.dao.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        DeptEntity dept = new DeptEntity();
        dept.setName("组织架构");
        dept.setDescription("顶级目录");

        UserEntity entity = new UserEntity();
        entity.setUsername("AMOS");
        entity.setPassword("000000");
        entity.setSalt("#0626");

        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setEmail("daoyuan0626@gmail.com");
        userInfo.setJobNumber("1000");
        userInfo.setBirthday(LocalDate.of(1996, 5, 11));

        // user_info
        entity.setUserInfo(userInfo);
        // addresses
        entity.setAddresses(getAddressEntities(entity));
        // dept
        entity.setDept(dept);

        userRepository.save(entity);

        TEST_ID = entity.getId();
    }

    @Test
    public void update() {
        userRepository.findById(TEST_ID)
                .ifPresent(entity -> {
                    entity.setUsername("AMOS" + System.currentTimeMillis());
                    entity.setPassword(String.valueOf(System.currentTimeMillis()));
                    entity.getUserInfo().setBirthday(LocalDate.of(1996, 6, 26));
                    Optional.ofNullable(entity.getAddresses()).ifPresent(entities ->
                            entities.forEach(userAddress -> userAddress.setAddress("中国·上海·嘉定")));

                    userRepository.save(entity);
                });
    }

    @Test
    public void delete() {
        userRepository.findById(TEST_ID)
                .ifPresent(entity -> userRepository.deleteLogic(entity));
    }

    @Test
    public void findById() {
        userRepository.findById(TEST_ID)
                .ifPresent(entity -> {
                    try {
                        System.out.println(objectMapper.writeValueAsString(entity));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
    }

    private Set<UserAddressEntity> getAddressEntities(UserEntity entity) {
        UserAddressEntity userAddress = new UserAddressEntity();
        userAddress.setUser(entity);
        userAddress.setName("王凌峰");
        userAddress.setPhoneNo("18937128888");
        userAddress.setAddress("中国·上海·静安");

        UserAddressEntity userAddress2 = new UserAddressEntity();
        userAddress2.setUser(entity);
        userAddress2.setName("王鹏程");
        userAddress2.setPhoneNo("18937128889");
        userAddress2.setAddress("中国·上海·静安");

        Set<UserAddressEntity> userAddresses = new HashSet<>();
        userAddresses.add(userAddress);
        userAddresses.add(userAddress2);

        return userAddresses;
    }
}
