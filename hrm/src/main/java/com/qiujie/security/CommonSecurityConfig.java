package com.qiujie.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiujie.entity.Staff;
import com.qiujie.mapper.StaffMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class CommonSecurityConfig {
    @Resource
    private StaffMapper staffMapper;
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                List<Staff> staffList = staffMapper.selectList(new QueryWrapper<Staff>()
                        .eq("code",username));
                if (staffList != null && staffList.size() > 0) {
                    return new AdminUserDetails(staffList.get(0));
                }
                throw new UsernameNotFoundException("用户名或密码错误");
            }
        };
    }
}
