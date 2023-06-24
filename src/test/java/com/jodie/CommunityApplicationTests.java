package com.jodie;

import com.jodie.entity.DiscussPost;
import com.jodie.mapper.DiscussPostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPost(0,0,10);
        for(DiscussPost post : list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
