package com.qiujie.config;

import com.qiujie.security.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
//启用方法级别安全，允许在方法上使用@PreAuthorize和@PostAuthorize注解来控制访问权限。
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    RestfulAccessDeniedHandler restfulAccessDeniedHandler;


}
