package top.soft.classoa.mapper;

import org.junit.jupiter.api.Test;
import top.soft.classoa.entity.Notice;
import top.soft.classoa.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

class NoticeMapperTest {

    @Test
    void insert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            mapper.insert(Notice.builder()
                    .receiverId(7L)
                    .content("测试消息")
                    .createTime(new Date())
                    .build());
            return null;
        });
    }

    @Test
    void selectByReceiverId() {
        MybatisUtils.executeQuery(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            List<Notice> notices = mapper.selectByReceiverId(7L);
            System.out.println(notices);
            return notices;
        });
    }
}