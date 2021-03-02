package net.suncaper.userprovider.domain;

import java.util.List;

public class RoleExt {
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
