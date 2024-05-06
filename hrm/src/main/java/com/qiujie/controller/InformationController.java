package com.qiujie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import generator.domain.SysInformation;
import generator.mapper.SysInformationMapper;
import generator.service.impl.SysInformationServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Wrapper;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Resource
    SysInformationServiceImpl sysInformationService;

    @Resource
    SysInformationMapper sysInformationMapper;

    @RequestMapping("/detail")
    ResponseDTO getStaffInformationDetailById(@RequestParam Integer id){
        return Response.success(sysInformationMapper.selectOne(new QueryWrapper<SysInformation>().eq("staff_id",id)));
    }

}
