package com.qiujie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Staff;
import com.qiujie.mapper.StaffMapper;
import com.qiujie.util.JwtTokenUtil;
import com.qiujie.util.MD5Util;
import com.qiujie.vo.StaffDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author : qiujie
 * @Date : 2022/1/30
 */

@Service
public class LoginService extends ServiceImpl<StaffMapper, Staff> {

    @Resource
    private StaffMapper staffMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public ResponseDTO login(Staff staff) {
        String token = null;
        String password = MD5Util.MD55(staff.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(staff.getCode());
        if(!password.equals(userDetails.getPassword())){
            Response.error("密码错误!");
        }
        if(!userDetails.isEnabled()){
            Response.error("账号已被禁用!");
        }
        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo(staff.getCode(), password);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //token = JWTUtil.generateToken(staffDeptVO.getId(),password);
        token = jwtTokenUtil.generateToken(userDetails);
        return Response.success(staffDeptVO,token);

//        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo(staff.getCode(), password);
//        if (staffDeptVO != null) {
//            // 验证用户状态
//            if (staffDeptVO.getStatus() == 1) {
//                String token = JWTUtil.generateToken(staffDeptVO.getId(),password);
//                return Response.success(staffDeptVO, token); // 返回员工信息和token
//            }
//            return Response.error(BusinessStatusEnum.STAFF_STATUS_ERROR);
//        }
//        return Response.error("用户名或密码错误!");
    }
}
