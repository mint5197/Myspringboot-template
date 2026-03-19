package top.lrj.springbootweek02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.lrj.springbootweek02.constant.GenderEnum;

import java.time.LocalDate;

/**
 * @author 李如锦
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentAddDTO {
    private String name;
    private String mobile;
    private GenderEnum gender;
    private String avatar;
    private LocalDate birthday;
}
