package top.soft.classoa.mapper;

import org.junit.jupiter.api.Test;
import top.soft.classoa.entity.LeaveForm;
import top.soft.classoa.utils.MybatisUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class LeaveFormMapperTest {

    @Test
    void insert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            LeaveFormMapper leaveFormMapper = sqlSession.getMapper(LeaveFormMapper.class);
            LeaveForm form = new LeaveForm();
            form.setEmployeeId(3L);

            form.setFormType(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = null;
            Date endTime = null;
            try {
                startTime = sdf.parse("2024-12-15 00:00:00");
                endTime = sdf.parse("2024-12-16 00:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            form.setStartTime(startTime);
            form.setEndTime(endTime);
            form.setReason("私事");

            form.setCreateTime(new Date());
            form.setState("processing");
            leaveFormMapper.insert(form);
            return null;
        });
    }
}