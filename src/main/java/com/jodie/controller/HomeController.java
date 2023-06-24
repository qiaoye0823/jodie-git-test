package com.jodie.controller;

import com.jodie.entity.DiscussPost;
import com.jodie.entity.Page;
import com.jodie.entity.User;
import com.jodie.mapper.DiscussPostMapper;
import com.jodie.service.DiscussPostService;
import com.jodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        // 方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入Model
        // 所以，在thymeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));  // 查询数据库获取行数
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        // 根据userId查询username
        List<Map<String, Object>> discussPosts = new ArrayList<>();

        if(list != null){
            for(DiscussPost post : list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        // 将页面展现的结果装到model里
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
