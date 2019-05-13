package com.webb;

import com.alibaba.fastjson.JSONObject;
import com.webb.domain.UserT;
import com.webb.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-*.xml"})
public class TestMyBatis {

    private static final Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource
    private IUserService userService;

    @Test
    public void test1() {
        UserT userT = userService.getUserById(1);
        logger.info(JSONObject.toJSONString(userT));
    }

    @Test
    public void testAdd() {
        UserT userT = new UserT();
        userT.setUserName("测试2");
        userT.setPassword("123123");
        userT.setAge(22);
        userService.add(userT);
    }

}
