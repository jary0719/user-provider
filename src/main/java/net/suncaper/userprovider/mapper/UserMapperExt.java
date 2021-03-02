package net.suncaper.userprovider.mapper;


import net.suncaper.userprovider.domain.User;

import java.util.List;

public interface UserMapperExt {
    List<User> getUserWithRoleAndPermissionByName(String username);
}
