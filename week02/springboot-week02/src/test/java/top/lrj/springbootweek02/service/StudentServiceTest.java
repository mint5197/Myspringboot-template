package top.lrj.springbootweek02.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.lrj.springbootweek02.SpringbootWeek02Application;
import top.lrj.springbootweek02.constant.GenderEnum;
import top.lrj.springbootweek02.dto.StudentAddDTO;
import top.lrj.springbootweek02.dto.StudentUpdateDTO;
import top.lrj.springbootweek02.vo.StudentVO;

import java.time.LocalDate;
import java.util.List;

// 明确指定主启动类，确保上下文加载完整
@SpringBootTest(classes = SpringbootWeek02Application.class)
@Slf4j
class StudentServiceTest {

    // 改用 @Autowired 注入（比 @Resource 更适配 Spring 环境）
    @Autowired
    private StudentService studentService;

    @Test
    void getAllStudents() {
        List<StudentVO> allStudents = studentService.getAllStudents();
        allStudents.forEach(studentVO -> log.info("学生信息: {}", studentVO));
    }

    @Test
    void addStudent() {
        studentService.addStudent(StudentAddDTO.builder()
                .name("李如锦")
                .mobile("12345678901")
                .gender(GenderEnum.MALE)
                .avatar("https://mqxu.top/avatar.jpg")
                .birthday(LocalDate.of(1999, 1, 1))
                .build());

        log.info("添加成功，当前所有学生：");
        List<StudentVO> allStudents = studentService.getAllStudents();
        allStudents.forEach(studentVO -> log.info("{}", studentVO));
    }

    @Test
    void getStudent() {
        // 先判断数据是否存在，避免空指针
        StudentVO studentVO = studentService.getStudent(1001L);
        if (studentVO != null) {
            log.info("单个学生信息: {}", studentVO);
        } else {
            log.warn("未找到ID为1001的学生");
        }
    }

    @Test
    void getStudentByName() {
        List<StudentVO> studentList = studentService.getStudentByName("张");
        log.info("模糊查询结果（包含'张'）：");
        studentList.forEach(studentVO -> log.info("{}", studentVO));
    }

    @Test
    void updateStudent() {
        studentService.updateStudent(1001L, StudentUpdateDTO.builder()
                .name("张三-修改后")
                .mobile("12345678901")
                .avatar("https://mqxu.top/new.jpg")
                .build());

        log.info("修改成功，修改后信息：");
        StudentVO studentVO = studentService.getStudent(1001L);
        log.info("{}", studentVO);
    }

    @Test
    void deleteStudent() {
        studentService.deleteStudent(1001L);
        log.info("删除成功，当前剩余学生：");
        List<StudentVO> allStudents = studentService.getAllStudents();
        allStudents.forEach(studentVO -> log.info("{}", studentVO));
    }
}