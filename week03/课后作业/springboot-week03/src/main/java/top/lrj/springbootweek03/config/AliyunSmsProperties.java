package top.lrj.springbootweek03.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
/**
 * @author 李如锦
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.sms")
@Validated
public class AliyunSmsProperties {
    private boolean enabled = true;
    private String endpoint = "dypnsapi.aliyuncs.com";
    private String regionId = "cn-hangzhou";
    private String accessKeyId;
    private String accessKeySecret;
    private String templateCode;
    private String schemeName = "默认⽅案";

    @NotBlank(message = "阿里云短信签名不能为空")
    private String signname;

}
