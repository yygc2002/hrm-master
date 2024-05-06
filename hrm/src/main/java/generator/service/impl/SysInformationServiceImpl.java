package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysInformation;
import generator.service.SysInformationService;
import generator.mapper.SysInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author 50697
* @description 针对表【sys_information(员工基本信息)】的数据库操作Service实现
* @createDate 2024-05-06 20:38:27
*/
@Service
public class SysInformationServiceImpl extends ServiceImpl<SysInformationMapper, SysInformation>
    implements SysInformationService{

}




