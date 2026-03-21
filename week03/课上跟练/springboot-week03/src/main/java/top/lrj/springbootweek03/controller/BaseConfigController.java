package top.lrj.springbootweek03.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lrj.springbootweek03.common.Result;

import java.util.Map;

/**
 * @author 李如锦
 */
@RestController
@RequestMapping("/config")
public class BaseConfigController {
    @Value("${server.port}")
    private Integer port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${app.app-name}")
    private String appName;

    @Value("${app.version}")
    private String version;

    @GetMapping("/base")
    public Result<Map<String , Object>> getBaseConfigInfo(){
        Map<String , Object>map = Map.of(
                "port", port,
                "contextPath", contextPath,
                "applicationName", applicationName,
                "appName", appName,
                "version", version
        );
        return Result.success(map);
    }
}
