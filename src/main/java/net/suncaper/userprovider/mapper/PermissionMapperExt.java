package net.suncaper.userprovider.mapper;

import net.suncaper.userprovider.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapperExt {
    List<Permission> getPermissionsByRoleId(@Param("roleId") Integer roleId);
}
