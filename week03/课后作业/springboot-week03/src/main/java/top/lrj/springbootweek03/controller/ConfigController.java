package top.lrj.springbootweek03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lrj.springbootweek03.common.Result;
import top.lrj.springbootweek03.config.AliyunSmsProperties;

/**
 **配置管理基础接口
 */
@RestController
@RequestMapping("/api/config")
public class ConfigController {

    // @Value读取配置
    @Value("${server.port:8080}")
    private Integer serverPort;

    @Autowired
    private AliyunSmsProperties aliyunSmsProperties;

    // 接口1：返回配置信息
    @GetMapping("/info")
    public Result<Object> getConfigInfo() {
        // 封装配置数据
        ConfigInfoVO vo = new ConfigInfoVO();
        vo.setServerPort(serverPort);
        vo.setSmsEndpoint(aliyunSmsProperties.getEndpoint());
        vo.setSmsRegionId(aliyunSmsProperties.getRegionId());
        vo.setSmsSignName(aliyunSmsProperties.getSignname());
        return Result.success(vo);
    }

    // 内部VO：仅封装配置数据
    @lombok.Data
    private static class ConfigInfoVO {
        private Integer serverPort;
        private String smsEndpoint;
        private String smsRegionId;
        private String smsSignName;
    }
}