# Spring Boot Starter 完全实用指南

## 一、什么是 Spring Boot Starter

**Spring Boot Starter** 是一组便捷的依赖描述符，旨在简化项目配置。通过引入 Starter，您可以一站式获取所需的 Spring 及相关技术依赖，无需手动搜索示例代码和复制粘贴大量的依赖配置。

**核心价值：**
- 快速启动项目
- 一致的依赖管理
- 自动配置支持
- 经过测试的传递依赖组合

## 二、Starter 分类体系

### 1. 应用启动器（Application Starters）

这是最主要的 Starter 类别，按功能领域可进一步细分：

#### **核心基础设施**
| Starter                       | 功能说明                                     |
| ----------------------------- | -------------------------------------------- |
| `spring-boot-starter`         | 核心启动器，包含自动配置支持、日志和 YAML    |
| `spring-boot-starter-classic` | 经典核心启动器，包含完整的自动配置支持       |
| `spring-boot-starter-test`    | 测试支持（JUnit Jupiter、Hamcrest、Mockito） |

#### **Web 开发**
| Starter                          | 功能说明                              |
| -------------------------------- | ------------------------------------- |
| `spring-boot-starter-webmvc`     | Spring MVC + Tomcat（推荐）           |
| `spring-boot-starter-webflux`    | WebFlux + Reactor Netty（响应式编程） |
| `spring-boot-starter-tomcat`     | 嵌入式 Tomcat 容器                    |
| `spring-boot-starter-jetty`      | 嵌入式 Jetty 容器                     |
| `spring-boot-starter-websocket`  | WebSocket 支持                        |
| `spring-boot-starter-thymeleaf`  | Thymeleaf 模板引擎                    |
| `spring-boot-starter-freemarker` | FreeMarker 模板引擎                   |
| `spring-boot-starter-mustache`   | Mustache 模板引擎                     |

#### **数据访问**
| Starter                                  | 功能说明                    |
| ---------------------------------------- | --------------------------- |
| `spring-boot-starter-data-jpa`           | Spring Data JPA + Hibernate |
| `spring-boot-starter-data-jdbc`          | Spring Data JDBC            |
| `spring-boot-starter-jdbc`               | JDBC + HikariCP 连接池      |
| `spring-boot-starter-data-r2dbc`         | 响应式 R2DBC                |
| `spring-boot-starter-jooq`               | jOOQ 类型安全 SQL           |
| `spring-boot-starter-data-redis`         | Redis + Lettuce 客户端      |
| `spring-boot-starter-data-mongodb`       | MongoDB                     |
| `spring-boot-starter-data-cassandra`     | Cassandra 分布式数据库      |
| `spring-boot-starter-data-elasticsearch` | Elasticsearch 搜索引擎      |
| `spring-boot-starter-data-neo4j`         | Neo4j 图数据库              |
| `spring-boot-starter-data-ldap`          | LDAP 目录服务               |
| `spring-boot-starter-data-couchbase`     | Couchbase 文档数据库        |

#### **消息队列**
| Starter                        | 功能说明               |
| ------------------------------ | ---------------------- |
| `spring-boot-starter-amqp`     | Spring AMQP + RabbitMQ |
| `spring-boot-starter-kafka`    | Apache Kafka           |
| `spring-boot-starter-pulsar`   | Apache Pulsar          |
| `spring-boot-starter-activemq` | Apache ActiveMQ        |
| `spring-boot-starter-artemis`  | Apache Artemis         |
| `spring-boot-starter-jms`      | JMS 消息服务           |

#### **安全**
| Starter                                                    | 功能说明                     |
| ---------------------------------------------------------- | ---------------------------- |
| `spring-boot-starter-security`                             | Spring Security 基础         |
| `spring-boot-starter-security-oauth2-client`               | OAuth2/OpenID Connect 客户端 |
| `spring-boot-starter-security-oauth2-resource-server`      | OAuth2 资源服务器            |
| `spring-boot-starter-security-oauth2-authorization-server` | 授权服务器                   |
| `spring-boot-starter-security-saml2`                       | SAML2 支持                   |

#### **监控与运维**
| Starter                                  | 功能说明                         |
| ---------------------------------------- | -------------------------------- |
| `spring-boot-starter-actuator`           | 生产就绪特性（健康检查、指标等） |
| `spring-boot-starter-micrometer-metrics` | Micrometer 指标采集              |
| `spring-boot-starter-opentelemetry`      | OpenTelemetry 可观测性           |

#### **其他功能**
| Starter                           | 功能说明             |
| --------------------------------- | -------------------- |
| `spring-boot-starter-mail`        | 邮件发送             |
| `spring-boot-starter-quartz`      | Quartz 定时任务      |
| `spring-boot-starter-batch`       | Spring Batch 批处理  |
| `spring-boot-starter-validation`  | Bean Validation      |
| `spring-boot-starter-cache`       | 缓存支持             |
| `spring-boot-starter-graphql`     | GraphQL 支持         |
| `spring-boot-starter-rsocket`     | RSocket 协议         |
| `spring-boot-starter-integration` | Spring Integration   |
| `spring-boot-starter-hateoas`     | HATEOAS RESTful 应用 |

### 2. 生产环境启动器（Production Starters）

| Starter                        | 功能说明                                 |
| ------------------------------ | ---------------------------------------- |
| `spring-boot-starter-actuator` | 应用监控和管理（健康检查、指标、审计等） |

### 3. 技术替换启动器（Technical Starters）

用于排除或替换特定技术组件：

| Starter                              | 功能说明                 |
| ------------------------------------ | ------------------------ |
| `spring-boot-starter-log4j2`         | 使用 Log4j2 替代 Logback |
| `spring-boot-starter-logback`        | 使用 Logback 日志        |
| `spring-boot-starter-logging`        | 默认日志                 |
| `spring-boot-starter-reactor-netty`  | Reactor Netty            |
| `spring-boot-starter-jetty-runtime`  | Jetty 运行时             |
| `spring-boot-starter-tomcat-runtime` | Tomcat 运行时            |
| `spring-boot-starter-restdocs`       | Spring REST Docs         |

## 三、官方 Starter 命名规范

### 命名格式
```
spring-boot-starter-{功能标识}
```

### 命名规则详解

| 规则           | 说明                               | 示例                                                  |
| -------------- | ---------------------------------- | ----------------------------------------------------- |
| **前缀**       | 必须以 `spring-boot-starter-` 开头 | `spring-boot-starter-web`                             |
| **功能标识**   | 使用小写字母，多个单词用连字符分隔 | `data-jpa`、`security-oauth2-client`                  |
| **测试专用**   | 以 `-test` 结尾                    | `spring-boot-starter-web-test`                        |
| **响应式版本** | 包含 `reactive` 标识               | `spring-boot-starter-data-mongodb-reactive`           |
| **技术细分**   | 明确技术栈                         | `spring-boot-starter-security-oauth2-resource-server` |

### 官方 Starter 的 Group ID
```
org.springframework.boot
```

## 四、常用 Starter 速查表

### Web 应用开发必备组合
```xml
<!-- Web MVC 应用 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<!-- 数据访问 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- 数据库连接（如 MySQL） -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- 测试 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

### 微服务典型组合
```xml
<!-- Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<!-- 监控 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<!-- 安全 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security-oauth2-resource-server</artifactId>
</dependency>

<!-- 消息 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

### 响应式应用组合
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
```

## 五、创建第三方 Starter 指南

### 命名规范（第三方）

**不要**使用 `spring-boot-starter-` 前缀，这是 Spring Boot 官方保留的。

**正确命名格式：**
```
{项目名}-spring-boot-starter
```

| 类型           | 命名示例                      | Group ID           |
| -------------- | ----------------------------- | ------------------ |
| 第三方 Starter | `mybatis-spring-boot-starter` | 第三方组织         |
| 社区贡献       | `camel-spring-boot-starter`   | `org.apache.camel` |

### 创建步骤

#### 1. 项目结构
```
my-spring-boot-starter/
├── my-spring-boot-autoconfigure/    # 自动配置模块
│   ├── src/main/java/
│   │   └── com/example/autoconfigure/
│   │       ├── MyAutoConfiguration.java
│   │       └── MyProperties.java
│   └── src/main/resources/
│       └── META-INF/
│           └── spring/
│               └── org.springframework.boot.autoconfigure.AutoConfiguration.imports
└── my-spring-boot-starter/          # Starter 模块（仅含依赖）
    └── pom.xml
```

#### 2. 自动配置类
```java
@Configuration
@ConditionalOnClass(MyService.class)
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfiguration {
    
    @Bean
    @ConditionalOnMissingBean
    public MyService myService(MyProperties properties) {
        return new MyService(properties);
    }
}
```

#### 3. 配置属性类
```java
@ConfigurationProperties(prefix = "my.service")
public class MyProperties {
    private String name = "default";
    private boolean enabled = true;
    // getters and setters
}
```

#### 4. 注册自动配置
在 `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` 中添加：
```
com.example.autoconfigure.MyAutoConfiguration
```

#### 5. Starter POM 配置
```xml
<project>
    <groupId>com.example</groupId>
    <artifactId>my-spring-boot-starter</artifactId>
    
    <dependencies>
        <!-- 包含自动配置模块 -->
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>my-spring-boot-autoconfigure</artifactId>
        </dependency>
        
        <!-- 传递依赖 -->
        <dependency>
            <groupId>com.example</groupId>
            <artifactId>my-core-library</artifactId>
        </dependency>
    </dependencies>
</project>
```

## 六、版本注意事项

根据官方文档，部分 Starter 存在版本变更：

| 旧 Starter（已弃用）                              | 新 Starter（推荐）                                         | 版本 |
| ------------------------------------------------- | ---------------------------------------------------------- | ---- |
| `spring-boot-starter-web`                         | `spring-boot-starter-webmvc`                               | 3.x+ |
| `spring-boot-starter-web-services`                | `spring-boot-starter-webservices`                          | 3.x+ |
| `spring-boot-starter-oauth2-client`               | `spring-boot-starter-security-oauth2-client`               | 3.x+ |
| `spring-boot-starter-oauth2-resource-server`      | `spring-boot-starter-security-oauth2-resource-server`      | 3.x+ |
| `spring-boot-starter-oauth2-authorization-server` | `spring-boot-starter-security-oauth2-authorization-server` | 3.x+ |

## 七、社区 Starter 资源

Spring Boot 官方维护了一个社区贡献的 Starter 列表，可在 GitHub 的 `spring-boot-starters` 模块 README 中查看。

常见第三方 Starter：
- **MyBatis**: `mybatis-spring-boot-starter`
- **Camel**: `camel-spring-boot-starter`
- **Dubbo**: `dubbo-spring-boot-starter`

## 八、最佳实践建议

1. **最小依赖原则**：只引入实际需要的 Starter，避免不必要的依赖
2. **版本管理**：使用 Spring Boot 的 BOM（Bill of Materials）统一管理版本
3. **测试分离**：生产代码和测试代码使用对应的 `-test` Starter
4. **响应式选择**：新项目优先考虑响应式 Starter（WebFlux、R2DBC 等）
5. **安全优先**：生产环境务必引入 `spring-boot-starter-actuator` 和适当的安全 Starter

---

这份文档涵盖了 Spring Boot Starter 的核心概念、分类体系、命名规范和开发实践，可直接作为团队开发参考手册使用。