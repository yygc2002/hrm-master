package com.qiujie.service.impl;

import blockchain.web.model.Transaction;
import blockchain.web.service.PowService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.InfWorkExperience;
import com.qiujie.entity.InfWorkingExperience;
import com.qiujie.entity.SysInformation;
import com.qiujie.enums.TranscationTypeEnum;
import com.qiujie.mapper.InfWorkExperienceMapper;
import com.qiujie.mapper.InfWorkingExperienceMapper;
import com.qiujie.service.SysInformationService;
import com.qiujie.mapper.SysInformationMapper;
import com.qiujie.test.Book;
import com.qiujie.vo.StaffWorkExperience;
import com.qiujie.vo.StaffWorkingExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 50697
* @description 针对表【sys_information(员工基本信息)】的数据库操作Service实现
* @createDate 2024-05-08 15:05:49
*/
@Service
public class SysInformationServiceImpl extends ServiceImpl<SysInformationMapper, SysInformation>
    implements SysInformationService{
    @Autowired
    SysInformationMapper sysInformationMapper;

    @Autowired
    InfWorkExperienceMapper infWorkExperienceMapper;

    @Autowired
    InfWorkingExperienceMapper infWorkingExperienceMapper;

    @Autowired
    PowService powService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseDTO getStaffInformationDetailById(Integer id) {
        SysInformation sysInformation = sysInformationMapper
                .selectOne(new QueryWrapper<SysInformation>()
                        .eq("staff_id",id));
        return Response.success(sysInformation);
    }

    @Override
    public ResponseDTO saveStaffInformationDetail(SysInformation sysInformation) {
        if(updateById(sysInformation)){
            return Response.success();
        }
        return Response.error();
    }

    @Override
    public ResponseDTO getStaffInformationWorkExperience(Integer id) {
        List<InfWorkExperience> infWorkExperienceList = infWorkExperienceMapper
                .selectList(new QueryWrapper<InfWorkExperience>()
                .eq("staff_id",id));
        if(infWorkExperienceList.isEmpty()){
            return Response.error("该员工无工作经历");
        }
        StaffWorkExperience staffWorkExperience = new StaffWorkExperience();
        staffWorkExperience.setInfWorkExperienceLists(infWorkExperienceList);

        return Response.success(infWorkExperienceList);
    }

    @Override
    public ResponseDTO saveStaffInformationWorkExperience(InfWorkExperience infWorkExperience) {
        if(infWorkExperienceMapper.updateById(infWorkExperience)>0){
            Integer index = 0;
            Query query = new Query();
            query.with(Sort.by(Sort.Order.desc("_id"))).limit(1);
            List<Book> list = mongoTemplate.find(query, Book.class);
            if(!list.isEmpty()){
                index = list.get(0).getId() + 1;
            }

            Transaction transaction = new Transaction();
            transaction.setBusinessInfo("工作经历");
            transaction.setType(TranscationTypeEnum.UPDATE);
            transaction.setData(JSON.toJSONString(infWorkExperience));
            transaction.setId(index.toString());
            powService.invokeBlockService(transaction);

            return Response.success();
        }
        return Response.error();
    }

    @Override
    public ResponseDTO addStaffInformationWorkExperience(InfWorkExperience infWorkExperience) {
        if(infWorkExperienceMapper.insert(infWorkExperience)>0){
            Transaction transaction = new Transaction();
            transaction.setBusinessInfo("工作经历");
            transaction.setType(TranscationTypeEnum.ADD);
            transaction.setData(JSON.toJSONString(infWorkExperience));
            transaction.setId("1");
            powService.invokeBlockService(transaction);
            return Response.success();
        }
        return Response.error("添加工作经历失败");
    }

    @Override
    public ResponseDTO deleteStaffInformationWorkExperience(Integer id) {
        InfWorkExperience infWorkExperience = infWorkExperienceMapper.selectById(id);
        if(infWorkExperienceMapper.deleteById(id)>0){
            Transaction transaction = new Transaction();
            transaction.setBusinessInfo("工作经历");
            transaction.setType(TranscationTypeEnum.DELETE);
            transaction.setData(JSON.toJSONString(infWorkExperience));
            transaction.setId("1");
            powService.invokeBlockService(transaction);
            return Response.success();
        }
        return Response.error("删除工作经历失败");
    }

    @Override
    public ResponseDTO getStaffInformationWorkingExperience(Integer id) {
        List<InfWorkingExperience> infWorkExperienceList = infWorkingExperienceMapper
                .selectList(new QueryWrapper<InfWorkingExperience>()
                        .eq("staff_id",id));
        if(infWorkExperienceList.isEmpty()){
            return Response.error("该员工无在职经历");
        }
        StaffWorkingExperience staffWorkingExperience = new StaffWorkingExperience();
        staffWorkingExperience.setInfWorkingExperienceList(infWorkExperienceList);

        return Response.success(infWorkExperienceList);
    }

    @Override
    public ResponseDTO addStaffInformationWorkingExperience(InfWorkingExperience infWorkingExperience) {
        if(infWorkingExperienceMapper.insert(infWorkingExperience)>0){
            Transaction transaction = new Transaction();
            transaction.setBusinessInfo("在司经历");
            transaction.setType(TranscationTypeEnum.ADD);
            transaction.setData(JSON.toJSONString(infWorkingExperience));
            transaction.setId("1");
            powService.invokeBlockService(transaction);
            return Response.success("添加在职经历成功");
        }else {
            return Response.error("添加在职经历失败");
        }
    }

    @Override
    public ResponseDTO saveStaffInformationWorkingExperience(InfWorkingExperience infWorkingExperience) {
        if(infWorkingExperienceMapper.updateById(infWorkingExperience)>0){
            Transaction transaction = new Transaction();
            transaction.setBusinessInfo("在司经历");
            transaction.setType(TranscationTypeEnum.UPDATE);
            transaction.setData(JSON.toJSONString(infWorkingExperience));
            transaction.setId("1");
            powService.invokeBlockService(transaction);
            return Response.success("更新职经历成功");
        }else {
            return Response.error("更新职经历失败");
        }
    }

    @Override
    public ResponseDTO deleteStaffInformationWorkingExperience(Integer id) {
        InfWorkingExperience infWorkExperience = infWorkingExperienceMapper.selectById(id);
        if(infWorkingExperienceMapper.deleteById(id)>0){
            Transaction transaction = new Transaction();
            transaction.setBusinessInfo("在司经历");
            transaction.setType(TranscationTypeEnum.DELETE);
            transaction.setData(JSON.toJSONString(infWorkingExperienceMapper));
            transaction.setId("1");
            powService.invokeBlockService(transaction);
            return Response.success("删除在职经历成功");
        }else {
            return Response.error("删除在职经历失败");
        }
    }
}




