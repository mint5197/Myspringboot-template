package top.lrj.springbootweek04.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
public class User {
    private Long id;
    private String username;
    private LocalDateTime createTime;
}
