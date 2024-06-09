package com.qiujie.test;

import blockchain.web.model.Transaction;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiujie.dto.Response;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.entity.Attendance;
import com.qiujie.entity.Dept;
import com.qiujie.entity.Staff;
import com.qiujie.enums.AttendanceStatusEnum;
import com.qiujie.enums.TranscationTypeEnum;
import com.qiujie.mapper.AttendanceMapper;
import com.qiujie.mapper.DeptMapper;
import com.qiujie.mapper.StaffMapper;
import com.qiujie.service.AttendanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class Springboot17MongodbApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Resource
    private StaffMapper staffMapper;
    @Resource
    private AttendanceMapper attendanceMapper;
    @Resource
    private DeptMapper deptMapper;
    @Autowired
    AttendanceService attendanceService;
    @Test
    void contextLoads() {
        Book book = new Book();
        //book.setId(13);
        book.setName("testMongoDB");
        book.setType("testMongoDB");
        book.setDescription("testMongoDB");
        mongoTemplate.save(book);

//        Staff staff = staffMapper.selectById(1);
//        Transaction<Staff> staffTransaction = new Transaction<Staff>();
//        staffTransaction.setData(staff);
//        staffTransaction.setId("2");
//        staffTransaction.setType(TranscationTypeEnum.ADD);
//        staffTransaction.setBusinessInfo("测试");
//        mongoTemplate.save(staffTransaction);
    }
    @Test
    void find(){
        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("_id"))).limit(1);
        List<Book> all = mongoTemplate.find(query, Book.class);
        //List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all.get(0));
    }

    @Test
    void date(){
        String today = DateUtil.today();
        //是否有今天的数据
        List<Attendance> attendances = this.attendanceMapper.selectList(new QueryWrapper<Attendance>()
                .eq("staff_id",1)
                .eq("attendance_date",today));
        if(!attendances.isEmpty()){
            Attendance attendance = attendances.get(0);
            attendance.setMorStartTime(DateUtil.date().toTimestamp());
            this.attendanceMapper.updateById(attendance);

        }
    }

    private boolean isLate(Attendance attendance, Dept dept) {
        if (DateUtil.compare(attendance.getMorStartTime(), dept.getMorStartTime(), "HH:mm:ss") > 0) {
            return true;
        } else if (DateUtil.compare(attendance.getAftStartTime(), dept.getAftStartTime(), "HH:mm:ss") > 0) {
            return true;
        }
        return false;
    }

    @Test
    void signIn(){
        Integer id = 1;
        String today = DateUtil.today();
        //是否有今天的数据
        List<Attendance> attendances = this.attendanceMapper.selectList(new QueryWrapper<Attendance>()
                .eq("staff_id",id)
                .eq("attendance_date",today));
        Dept dept = this.deptMapper.findDeptByStaffId(id);

        if (!attendances.isEmpty()){
            Attendance attendance = attendances.get(0);
            //是否已经签到过
            if (attendance.getMorStartTime() == null){
                attendance.setMorStartTime(DateUtil.date().toTimestamp());
                if (isLate(attendance,dept)){
                    attendance.setStatus(AttendanceStatusEnum.LATE);
                }
                attendanceService.edit(attendance);
            }
            else {
                System.out.println("今日已签到");
            }
        }
        else{
            Attendance attendance = new Attendance();
            attendance.setStaffId(id);
            attendance.setMorEndTime(dept.getMorEndTime());
            attendance.setAftEndTime(dept.getAftStartTime());
            attendance.setAttendanceDate(DateUtil.parse(today).toSqlDate());
            attendance.setMorStartTime(DateUtil.date().toTimestamp());
            if (isLate(attendance,dept)){
                attendance.setStatus(AttendanceStatusEnum.LATE);
            }
            else {
                attendance.setStatus(AttendanceStatusEnum.NORMAL);
            }
            attendanceService.add(attendance);
        }

        System.out.println("签到成功");
    }
}

