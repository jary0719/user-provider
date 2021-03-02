package net.suncaper.userprovider.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.suncaper.projecttracking.common.PagableResponse;
import net.suncaper.projecttracking.common.PageRequest;
import net.suncaper.projecttracking.domain.User;
import net.suncaper.userprovider.domain.Role;
import net.suncaper.userprovider.domain.RoleExample;
import net.suncaper.userprovider.domain.UserRoleExample;
import net.suncaper.userprovider.domain.UserRoleKey;
import net.suncaper.userprovider.mapper.RoleMapper;
import net.suncaper.userprovider.mapper.UserRoleMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleService {
    private static final String ASSIGNED_ROLE = "assigned";
    private static final String UN_ASSIGNED_ROLE = "unassigned";

    private final RoleMapper roleMapper;
    private final UserRoleMapper userRoleMapper;

    public RoleService(RoleMapper roleMapper, UserRoleMapper userRoleMapper) {
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
    }


    public PagableResponse<List<Role>> search(PageRequest request, String keyword) {
        RoleExample example = new RoleExample();
        if (StringUtils.isNoneBlank(keyword)) {
            example.createCriteria().andDisplayNameLike("%" + keyword + "%");
        }

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Role> roles = roleMapper.selectByExample(example);

        return new PagableResponse<>(((Page) roles).getTotal(), roles);
    }


    public Map<String, List<Role>> getAssignedRoleByUserId(Integer userId) {
        HashMap<String, List<Role>> roleMap = new HashMap<>();

        roleMap.put(ASSIGNED_ROLE, new ArrayList<>());
        roleMap.put(UN_ASSIGNED_ROLE, new ArrayList<>());

        List<Role> allRoles = roleMapper.selectByExample(new RoleExample());

        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);

        List<UserRoleKey> assignedUserRoles = userRoleMapper.selectByExample(userRoleExample);

        for (Role role : allRoles) {
            boolean found = false;

            for (UserRoleKey userRole : assignedUserRoles) {
                if (userRole.getRoleId() == role.getId()) {
                    found = true;
                    break;
                }
            }

            if (found) {
                roleMap.get(ASSIGNED_ROLE).add(role);
            } else {
                roleMap.get(UN_ASSIGNED_ROLE).add(role);
            }
        }

        return roleMap;
    }

    @Transactional
    public void assignRole(Integer userId, Integer[] roleIds) {
        if (roleIds != null && roleIds.length > 0) {
            for (Integer roleId : roleIds) {
                UserRoleKey userRoleKey = new UserRoleKey();

                userRoleKey.setRoleId(roleId);
                userRoleKey.setUserId(userId);

                userRoleMapper.insert(userRoleKey);
            }
        }
    }

    public void unassignRole(Integer userId, Integer[] roleIds) {
        if (roleIds != null && roleIds.length > 0) {
            UserRoleExample example = new UserRoleExample();
            UserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andRoleIdIn(Arrays.asList(roleIds));

            userRoleMapper.deleteByExample(example);
        }
    }

    public void create(Role role) {
        roleMapper.insert(role);
    }

    public void update(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    public void removeById(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    public Role getRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
