package com.yx.oa.dao;

import com.yx.oa.entity.Notice;

import java.util.List;

public interface NoticeDao {
    public void insert(Notice notice);

    public List<Notice> selectByReceiverId(Long receiverId);
}
