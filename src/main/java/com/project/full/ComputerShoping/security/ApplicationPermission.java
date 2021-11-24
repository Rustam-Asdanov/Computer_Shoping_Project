package com.project.full.ComputerShoping.security;

public enum ApplicationPermission {
    COMPUTER_READ("can see computers"),
    COMPUTER_WRITE("can change data");

    private final String permissionInfo;

    ApplicationPermission(String permissionInfo) {
        this.permissionInfo = permissionInfo;
    }

    public String getPermissionInfo() {
        return permissionInfo;
    }
}
