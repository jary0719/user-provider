package net.suncaper.userprovider;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.suncaper.userprovider.domain.User;
import net.suncaper.userprovider.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
//    @Ignore
    public void testCreateUser() {

        User user = new User();
        user.setId(-1);
        user.setUsername("admin");
        user.setNickName("超级管理员");
        user.setPassword("admin");

        userService.saveUser(user);
    }
}
