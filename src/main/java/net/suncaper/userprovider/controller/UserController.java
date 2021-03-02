package net.suncaper.userprovider.controller;

import net.suncaper.projecttracking.common.PagableResponse;
import net.suncaper.projecttracking.common.PageRequest;
import net.suncaper.userprovider.domain.User;
import net.suncaper.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Boolean createUser(@RequestBody User user) {
        userService.saveUser(user);

        return Boolean.TRUE;
    }

    @PostMapping("/update")
    public Boolean updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return Boolean.TRUE;
    }

    @GetMapping("/check-username")
    public Boolean checkUserName(@RequestParam("username") String username,@RequestParam(value = "id", required = false) Integer id) {
        return userService.checkUserName(username, id);
    }

    @GetMapping
    public User getUserById(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/delete")
    public Integer removeUser(@RequestParam("id") Integer id) {
        return userService.removeUser(id);
    }

    @GetMapping("/user-with-roles")
    public User getUserWithRoleAndPermissionByName(@RequestParam("username") String username) {
        return userService.getUserWithRoleAndPermissionByName(username);
    }

    @GetMapping("/search")
    PagableResponse<List<User>> searchUser(PageRequest request, String keyword) {
        return userService.list(request, keyword);
    }


    @GetMapping("/contacts")
    public List<User> getContactsDeptId(Integer deptId) {
        return userService.getContactsDeptId(deptId);
    }

    @GetMapping("/secretaries")
    public List<User> getSecretaryDeptId(Integer deptId) {
        return userService.getSecretarysDeptId(deptId);
    }

    @GetMapping("/leaders")
    public List<User> getLeaders() {
        return userService.getLeaders();
    }
}
