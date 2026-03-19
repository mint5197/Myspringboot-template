package top.lrj.springbootweek02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李如锦
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateDTO {
    private String name;
    private String mobile;
    private String avatar;
}

