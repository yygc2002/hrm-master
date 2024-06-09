package com.qiujie.controller;

import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.InfWorkExperience;
import com.qiujie.entity.InfWorkingExperience;
import com.qiujie.entity.SysInformation;
import com.qiujie.service.SysInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    SysInformationService sysInformationService;

    @GetMapping("/detail/{id}")
    ResponseDTO getStaffInformationDetailById(@PathVariable Integer id){
        return sysInformationService.getStaffInformationDetailById(id);
    }

    @PostMapping("/detail/save")
    ResponseDTO saveStaffInformationDetail(@RequestBody SysInformation sysInformation){
        return sysInformationService.saveStaffInformationDetail(sysInformation);
    }

    @GetMapping("/experience/{id}")
    ResponseDTO getStaffInformationWorkExperience(@PathVariable Integer id){
        return sysInformationService.getStaffInformationWorkExperience(id);
    }

    @PostMapping("/experience/save")
    ResponseDTO saveStaffInformationWorkExperience(@RequestBody InfWorkExperience infWorkExperience){
        return sysInformationService.saveStaffInformationWorkExperience(infWorkExperience);
    }

    @PostMapping("/experience/add")
    ResponseDTO addStaffInformationWorkExperience(@RequestBody InfWorkExperience infWorkExperience){
        return sysInformationService.addStaffInformationWorkExperience(infWorkExperience);
    }

    @GetMapping("/experience/delete/{id}")
    ResponseDTO deleteStaffInformationWorkExperience(@PathVariable Integer id){
        return sysInformationService.deleteStaffInformationWorkExperience(id);
    }

    @GetMapping("experience/getWorkingExperience/{id}")
    ResponseDTO getStaffInformationWorkingExperience(@PathVariable Integer id){
        return sysInformationService.getStaffInformationWorkingExperience(id);
    }

    @PostMapping("experience/addWorkingExperience")
    ResponseDTO addStaffInformationWorkingExperience(@RequestBody InfWorkingExperience infWorkingExperience){
        return sysInformationService.addStaffInformationWorkingExperience(infWorkingExperience);
    }

    @PostMapping("experience/saveWorkingExperience")
    ResponseDTO saveWorkingExperience(@RequestBody InfWorkingExperience infWorkingExperience){
        return sysInformationService.saveStaffInformationWorkingExperience(infWorkingExperience);
    }

    @GetMapping("experience/deleteWorkingExperience/{id}")
    ResponseDTO deleteWorkingExperience(@PathVariable Integer id){
        return sysInformationService.deleteStaffInformationWorkingExperience(id);
    }
}
