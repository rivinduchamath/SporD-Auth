package com.cloudofgoods.auth.service;

public interface PermissionDetailsService {
    String savePermission(String permissionName);

    boolean deletePermissionById(Integer permissionId);
}
