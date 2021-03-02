package net.suncaper.userprovider.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.suncaper.projecttracking.common.PagableResponse;
import net.suncaper.projecttracking.common.PageRequest;
import net.suncaper.userprovider.domain.*;
import net.suncaper.userprovider.mapper.PermissionMapper;
import net.suncaper.userprovider.mapper.RolePermissionMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PermissionService {
    private final PermissionMapper permissionMapper;
    private final RolePermissionMapper rolePermissionMapper;

    public PermissionService(PermissionMapper permissionMapper, RolePermissionMapper rolePermissionMapper) {
        this.permissionMapper = permissionMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    public PagableResponse<List<Permission>> search(PageRequest request, String keyword) {
        PermissionExample example = new PermissionExample();
        if (StringUtils.isNoneBlank(keyword)) {
            example.createCriteria().andDisplayNameLike("%" + keyword + "%");
        }

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Permission> permissions = permissionMapper.selectByExample(example);

        return new PagableResponse<>(((Page) permissions).getTotal(), permissions);
    }

    public void create(Permission permission) {
        permissionMapper.insert(permission);
    }

    public void update(Permission permission) {
        permissionMapper.updateByPrimaryKey(permission);
    }

    public void removeById(Integer id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    public Permission getPermissionById(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    public List<Permission> getPermissionsByRoleId(Integer roleId) {
        return permissionMapper.getPermissionsByRoleId(roleId);
    }

    public Boolean selectPermission(Integer roleId, Integer permissionId) {
        RolePermissionKey rolePermissionKey = new RolePermissionKey();
        rolePermissionKey.setRoleId(roleId);
        rolePermissionKey.setPermissionId(permissionId);

        rolePermissionMapper.insert(rolePermissionKey);

        return Boolean.TRUE;
    }

    public Boolean deselectPermission(Integer roleId, Integer permissionId) {
        RolePermissionKey rolePermissionKey = new RolePermissionKey();
        rolePermissionKey.setRoleId(roleId);
        rolePermissionKey.setPermissionId(permissionId);

        rolePermissionMapper.deleteByPrimaryKey(rolePermissionKey);

        return Boolean.TRUE;
    }
}
