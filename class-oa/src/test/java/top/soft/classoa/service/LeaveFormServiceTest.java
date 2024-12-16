package top.soft.classoa.service;

import org.junit.jupiter.api.Test;
import top.soft.classoa.entity.LeaveForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class LeaveFormServiceTest {
    LeaveFormService leaveFormService = new LeaveFormService();

    /**
     * 请假72h以上测试用例
     */
    @Test
    void createLeaveForm1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveForm form = new LeaveForm();
        form.setEmployeeId(8L);
        form.setStartTime(sdf.parse("2022010100"));
        form.setEndTime(sdf.parse("2022011008"));
        form.setFormType(1);
        form.setReason("我要请假72h以上");
        form.setCreateTime(new Date());

        LeaveForm savedForm = leaveFormService.createLeaveForm(form);
        System.out.println(savedForm);
    }

    /**
     * 请假72h以下测试用例
     */
    @Test
    void createLeaveForm2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveForm form = new LeaveForm();
        form.setEmployeeId(8L);
        form.setStartTime(sdf.parse("2024120409"));
        form.setEndTime(sdf.parse("2024120509"));
        form.setFormType(1);
        form.setReason("我要请假72h以内");
        form.setCreateTime(new Date());

        LeaveForm savedForm = leaveFormService.createLeaveForm(form);
        System.out.println(savedForm);
    }

    /**
     * 研发部经理提交请假单
     */
    @Test
    void createLeaveForm3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveForm form = new LeaveForm();
        form.setEmployeeId(2L);
        form.setStartTime(sdf.parse("2024120409"));
        form.setEndTime(sdf.parse("2024120509"));
        form.setFormType(1);
        form.setReason("研发部经理请假");
        form.setCreateTime(new Date());

        LeaveForm savedForm = leaveFormService.createLeaveForm(form);
        System.out.println(savedForm);
    }

    /**
     * 总经理提交请假单
     */
    @Test
    void createLeaveForm4() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        LeaveForm form = new LeaveForm();
        form.setEmployeeId(1L);
        form.setStartTime(sdf.parse("2024120409"));
        form.setEndTime(sdf.parse("2024120509"));
        form.setFormType(1);
        form.setReason("总经理请假");
        form.setCreateTime(new Date());

        LeaveForm savedForm = leaveFormService.createLeaveForm(form);
        System.out.println(savedForm);
    }
}