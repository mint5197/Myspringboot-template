package top.lrj.springbootweek04.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author 李如锦
 */
@Data
@Component
public class Team {
    @Value("${team.leader}")
    @NotBlank(message = "负责人姓名不能为空")
    @Length(min = 2, max = 10, message = "负责人姓名长度必须在2-10之间")
    private String leader;

    @Value("${team.age}")
    @Max(value = 60, message = "负责人年龄不能大于60岁")
    @Min(value = 30, message = "负责人年龄不能小于30岁")
    private Integer age;

    @Value("${team.email}")
    @Email(message = "邮箱格式不正确")
    private String email;

    @Value("${team.phone}")
    @Pattern(regexp = "^[0-9]{11}$", message = "手机号格式不正确")
    private String phone;

    @Value("${team.createTime}")
    @Past(message = "创建时间必须早于当前时间")
    private LocalDate createTime;

}