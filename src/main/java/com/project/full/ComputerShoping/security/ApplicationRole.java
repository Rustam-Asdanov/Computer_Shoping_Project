package com.project.full.ComputerShoping.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.project.full.ComputerShoping.security.ApplicationPermission.*;

public enum ApplicationRole {
    GUEST(Sets.newHashSet(COMPUTER_READ)),
    ADMIN(Sets.newHashSet(COMPUTER_READ,COMPUTER_WRITE));

    private final Set<ApplicationPermission> applicationRolesSet;

    ApplicationRole(Set<ApplicationPermission> applicationRolesSet) {
        this.applicationRolesSet = applicationRolesSet;
    }

    public Set<ApplicationPermission> getApplicationRolesSet() {
        return applicationRolesSet;
    }
}
