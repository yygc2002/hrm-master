package com.qiujie.service;

import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.InfWorkExperience;
import com.qiujie.entity.InfWorkingExperience;
import com.qiujie.entity.SysInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 50697
* @description 针对表【sys_information(员工基本信息)】的数据库操作Service
* @createDate 2024-05-08 15:05:49
*/
public interface SysInformationService extends IService<SysInformation> {
    public ResponseDTO getStaffInformationDetailById(Integer id);

    public ResponseDTO saveStaffInformationDetail(SysInformation sysInformation);

    public ResponseDTO getStaffInformationWorkExperience(Integer id);

    public ResponseDTO saveStaffInformationWorkExperience(InfWorkExperience infWorkExperience);

    public ResponseDTO addStaffInformationWorkExperience(InfWorkExperience infWorkExperience);

    //删除工作经历
    public ResponseDTO deleteStaffInformationWorkExperience(Integer id);

    //根据id获取在职经历
    public ResponseDTO getStaffInformationWorkingExperience(Integer id);

    public ResponseDTO addStaffInformationWorkingExperience(InfWorkingExperience infWorkingExperience);

    public ResponseDTO saveStaffInformationWorkingExperience(InfWorkingExperience infWorkingExperience);

    public ResponseDTO deleteStaffInformationWorkingExperience(Integer id);
}
