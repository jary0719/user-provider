package net.suncaper.userprovider.controller;

import net.suncaper.projecttracking.common.PagableResponse;
import net.suncaper.projecttracking.common.PageRequest;
import net.suncaper.userprovider.domain.Role;
import net.suncaper.userprovider.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/search")
    public PagableResponse<List<Role>> search(PageRequest request, @RequestParam(value = "keyword", required = false) String keyword) {
        return roleService.search(request, keyword);
    }

    @GetMapping("assigned")
    public Map<String, List<Role>> getAssignedRoleByUserId(@RequestParam("userId") Integer userId) {
        return roleService.getAssignedRoleByUserId(userId);
    }

    @PostMapping("create")
    public Boolean createRole(@RequestBody Role role) {
        roleService.create(role);

        return Boolean.TRUE;
    }

    @PostMapping("update")
    public Boolean updateRole(@RequestBody Role role) {
        roleService.update(role);

        return Boolean.TRUE;
    }

    @GetMapping("delete")
    public Boolean removeRole(@RequestParam("id") Integer id) {
        roleService.removeById(id);

        return Boolean.TRUE;
    }

    @GetMapping("assign-role")
    public boolean assignRole(@RequestParam("userId") Integer userId, @RequestParam("roleIds") Integer[] roleIds) {
        roleService.assignRole(userId, roleIds);

        return Boolean.TRUE;
    }

    @GetMapping("unassign-role")
    public boolean unassignRole(@RequestParam("userId") Integer userId, @RequestParam("roleIds") Integer[] roleIds) {
        roleService.unassignRole(userId, roleIds);

        return Boolean.TRUE;
    }

    @GetMapping
    public Role getRoleById(@RequestParam("id") Integer id){
        return roleService.getRoleById(id);
    }

}
