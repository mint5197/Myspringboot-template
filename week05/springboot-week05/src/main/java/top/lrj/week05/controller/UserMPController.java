package top.lrj.week05.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.lrj.week05.common.Result;
import top.lrj.week05.entity.User;
import top.lrj.week05.service.UserMPService;

/**
 * @author mqxu
 * @date 2026/4/2
 * @description UserMPController
 **/
@RestController
@RequestMapping("/api/user/mp")
@RequiredArgsConstructor
@Tag(name = "MP接口", description = "MP接口")
public class UserMPController {
    private final UserMPService userMPService;

    /**
     * 条件分⻚查询接口，分⻚参数默认：第1⻚，每⻚10条
     *
     * @param pageNum  ⻚码
     * @param pageSize 每⻚数量
     * @param username 用户名
     * @return 分⻚数据
     */
    @GetMapping("/page")
    @Operation(summary = "条件分⻚查询接口")
    public Result<Page<User>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String username) {
        return Result.success(userMPService.page(username, pageNum, pageSize));
    }


    /**
     * 新增接口（无SQL）
     *
     * @param user 新增数据
     * @return 新增结果
     */
    @PostMapping
    @Operation(summary = "新增接口")
    public Result<String> add(@RequestBody User user) {
        int row = userMPService.add(user);
        if (row <= 0) {
            return Result.error("MP 新增失败");
        }
        return Result.success("MP 新增成功");
    }

    /**
     * 删除接口（无SQL）
     *
     * @param id 删除id
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除接口")
    public Result<String> delete(@PathVariable Long id) {
        int row = userMPService.delete(id);
        if (row <= 0) {
            return Result.error("MP 删除失败");
        }
        return Result.success("MP 删除成功");
    }
}

