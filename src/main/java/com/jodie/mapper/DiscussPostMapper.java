package com.jodie.mapper;

import com.jodie.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // 首页查询方法
    // userId用于查询我发布的帖子, offset 起始行的行号，limit每页显示的行数

    List<DiscussPost> selectDiscussPost(int userId, int offset, int limit);

    // 查询行数， @Param注解用于给参数取别名
    int selectDiscussPostRows(int userId);
}
