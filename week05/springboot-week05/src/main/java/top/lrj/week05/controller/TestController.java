package top.lrj.week05.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lrj.week05.common.Result;
import top.lrj.week05.entity.User;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/user")    public Result<User> getUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("123456");
        user.setAge(18);
        user.setEmail("test@qq.com");
        user.setCreateTime(LocalDateTime.now());
        return  Result.success(user,"成功");
    }
}
