package top.soft.classoa.mapper;


import top.soft.classoa.entity.Notice;

import java.util.List;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/12/16 15:34
 */

public interface NoticeMapper {

    /**
     * 新增消息
     *
     * @param notice 消息对象
     */
    void insert(Notice notice);


    /**
     * 根据消息接收人工号查询其所有消息
     *
     * @param receiverId 消息接收人工号
     * @return 消息列表
     */
    List<Notice> selectByReceiverId(Long receiverId);
}