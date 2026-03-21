package top.lrj.springbootweek03.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AppConfigTest {
    @Resource
    private AppConfig appConfig;

    @Test
    public void getAppConfig() {
        log.info("名称: {}", appConfig.getAppName());
        log.info("版本: {}", appConfig.getVersion());
        log.info("描述: {}", appConfig.getDescription());
        log.info("是否发布: {}", appConfig.getPublicshed());
        log.info("作者: {}", appConfig.getAuthor());
        log.info("特性: {}", appConfig.getFeatures());
    }
}