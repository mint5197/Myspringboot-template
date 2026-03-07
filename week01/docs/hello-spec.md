# Hello 接口规格文档

## 1. 核心目标
- 提供一个基础的测试接口，用于快速验证 Spring Boot 服务是否正常运行，返回标准化的欢迎消息。

## 2. 业务规则
- 请求方式：GET
- 接口地址：/api/hello
- 不需要携带任何参数
- 响应格式为 JSON 结构，包含状态码、提示信息和业务数据
- 状态码统一返回 200，表示请求成功
- 提示信息固定为 "success"
- 业务数据为欢迎语文本，例如："Hello Spring Boot"

## 3. 技术约束
- 使用 Spring Boot 3.x
- 使用 Java 17
- 端口使用默认 8080
- 返回类型使用统一包装类 ResultVO<String>

## 4. 输入输出

### 4.1 输入
- 无请求体，无查询参数

### 4.2 输出
- 成功示例：
```json
{
  "code": 200,
  "msg": "success",
  "data": "Hello Spring Boot"
}
```

## 5. 验收标准

- 服务启动无异常
- 调用接口返回 HTTP 状态码 200
- 响应 JSON 必须包含 code、msg、data 三个字段
- data 字段值为非空字符串，内容为欢迎语