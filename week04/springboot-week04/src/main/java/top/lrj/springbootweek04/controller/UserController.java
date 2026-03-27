package top.lrj.springbootweek04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lrj.springbootweek04.common.Result;
import top.lrj.springbootweek04.entity.User;


import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/info")
    public Result<User> getUserInfo(){
        User user = new User();
        user.setId(123456789123456789L);
        user.setUsername("springmvc-student");
        user.setCreateTime(LocalDateTime.now());
        return Result.success(user);
    }
}
