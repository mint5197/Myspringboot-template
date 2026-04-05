package top.lrj.week05.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.lrj.week05.common.Result;
import top.lrj.week05.entity.User;
import top.lrj.week05.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "用户接口", description = "用户接口")
public class UserController {
    private final UserService userService;

    @PostMapping
    // 接口名：新增用户
    @Operation(summary = "新增用户")
    public Result<String> add(@RequestBody User user) {
        int row = userService.add(user);
        if (row != 1) {
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @GetMapping("/{id}")
    // 接口名：id查询用户 + 给id参数加备注
    @Operation(summary = "id查询用户")
    public Result<User> get(
            @Parameter(description = "用户ID", required = true)
            @PathVariable Long id) {
        return Result.success(userService.getById(id));
    }

    @GetMapping("/list")
    // 接口名：列表查询用户
    @Operation(summary = "列表查询用户")
    public Result<List<User>> list() {
        return Result.success(userService.list());
    }

    @PutMapping
    // 接口名：更新用户
    @Operation(summary = "更新用户")
    public Result<String> update(@RequestBody User user) {
        int row = userService.update(user);
        if (row != 1) {
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    // 接口名：id删除用户 + 给id参数加备注
    @Operation(summary = "id删除用户")
    public Result<String> delete(
            @Parameter(description = "用户ID", required = true)
            @PathVariable Long id) {
        int row = userService.delete(id);
        if (row != 1) {
            return Result.error("删除失败");
        }
        return Result.success("删除成功");
    }
    /**
     * 搜索功能
     *
     * @param username 用户名
     * @param minAge   最小年龄
     * @return 数据列表
     */
    @GetMapping("/search")
    @Operation(summary = "动态查询用户")
    public List<User> search(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer minAge) {
        return userService.search(username, minAge);
    }
}