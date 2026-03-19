package top.lrj.springbootweek02.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.lrj.springbootweek02.constant.GenderEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 李如锦
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;
    private String name;
    private String avatar;
    private String mobile;
    private GenderEnum gender;
    private Boolean enabled;
    private LocalDate birthday;
    private LocalDateTime createTime;
}
