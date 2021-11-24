package com.project.full.ComputerShoping.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthority(){
        return getApplicationRolesSet().stream()
                .map(applicationPermission ->
                        new SimpleGrantedAuthority(applicationPermission.getPermissionInfo()))
                .collect(Collectors.toSet());
    }
}
