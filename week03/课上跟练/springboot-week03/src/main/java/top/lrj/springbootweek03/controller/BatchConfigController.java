package top.lrj.springbootweek03.controller;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lrj.springbootweek03.common.Result;
import top.lrj.springbootweek03.config.AppConfig;

/**
 * @author 李如锦
 */
@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class BatchConfigController {
    @Resource
    private AppConfig appConfig;
    @RequestMapping("/batch")
    public Result<AppConfig> getBatchConfigInfo(){
        return Result.success(appConfig);
    }
}
