package top.lrj.springbootweek02.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.lrj.springbootweek02.constant.GenderEnum;

import java.time.LocalDateTime;

/**
 * @author 李如锦
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
    private Long id;
    private String name;
    private String mobile;
    private GenderEnum gender;

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;
}
