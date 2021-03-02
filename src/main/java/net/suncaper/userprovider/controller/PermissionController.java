package net.suncaper.userprovider.controller;

import net.suncaper.projecttracking.common.PagableResponse;
import net.suncaper.projecttracking.common.PageRequest;
import net.suncaper.userprovider.domain.Permission;
import net.suncaper.userprovider.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @GetMapping("/search")
    public PagableResponse<List<Permission>> search(PageRequest request, @RequestParam(value = "keyword", required = false) String keyword) {
        return permissionService.search(request, keyword);
    }

    @PostMapping("create")
    public Boolean createPermission(@RequestBody Permission permission) {
        permissionService.create(permission);

        return Boolean.TRUE;
    }

    @PostMapping("update")
    public Boolean updatePermission(@RequestBody Permission permission) {
        permissionService.update(permission);

        return Boolean.TRUE;
    }

    @GetMapping("delete")
    public Boolean removePermission(@RequestParam("id") Integer id) {
        permissionService.removeById(id);

        return Boolean.TRUE;
    }

    @GetMapping
    public Permission getPermissionById(@RequestParam("id") Integer id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping("role-permissions")
    public List<Permission> getPermissionsByRoleId(@RequestParam("roleId") Integer roleId) {
        return permissionService.getPermissionsByRoleId(roleId);
    }


    @GetMapping("/select")
    @ResponseBody
    public Boolean selectPermission(@RequestParam("roleId") Integer roleId, @RequestParam("permissionId") Integer permissionId) {
        return permissionService.selectPermission(roleId, permissionId);
    }

    @GetMapping("/deselect")
    @ResponseBody
    public Boolean deselectPermission(@RequestParam("roleId") Integer roleId, @RequestParam("permissionId") Integer permissionId) {
        return permissionService.deselectPermission(roleId, permissionId);
    }
}
