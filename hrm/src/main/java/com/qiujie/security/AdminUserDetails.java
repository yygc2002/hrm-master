package com.qiujie.security;

import com.qiujie.entity.Staff;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * SpringSecurity需要的用户信息封装类
 */
public class AdminUserDetails implements UserDetails {

    private final Staff staff;

    public AdminUserDetails(Staff staff){
        this.staff = staff;
    }

    @Override//用户权限有哪些
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return staff.getPassword();
    }

    @Override
    public String getUsername() {
        return staff.getCode();
    }

    @Override//账号是否过期
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override//账号是否锁定
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override//密码是否过期
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override//账号是否有效
    public boolean isEnabled() {
        return staff.getStatus().equals(1);
    }
}
