### zmp

基于spring-boot 搭建, 已实现部分钉钉API; 支持本地数据库操作 ;
- 提供rest 服务
- 模块化开发方式
- 服务可自由组合发布
- DingTalk API DEMO
- 本地数据库  DEMO
- 整合swagger-ui
- JWT
- HTTP Head Token 认证


### 目录结构
```
├── db-script  ------------------------------------------- 脚本目录
|   └── inin.sql  
├── zmp-api-web  ----------------------------------------- API web工程
├── zmp-system  ------------------------------------------ 系统服务
|   ├── zmp-system-api-8081  ----------------------------- 系统服务接口、BEAN定义 
|   ├── zmp-system-provider-dingtalk  -------------------- 钉钉服务
|   |   ├── zmp-system-provider-dingtalk-channel  -------- 钉钉服务窗服务
|   |   └── zmp-system-provider-dingtalk-extuser  -------- 钉钉外部联系人服务
|   |   └── zmp-system-provider-dingtalk-inneruser  ------ 钉钉内部联系人服务
|   |   └── zmp-system-provider-dingtalk-robot  ---------- 钉钉自定义机器人服务
|   |   └── zmp-system-provider-dingtalk-sdk  ------------ 钉钉公共依赖
|   ├── zmp-system-provider-local  ----------------------- 本地数据库系统
|   |   └── zmp-system-provider-local-extuser  ----------- 本地外部联系人服务
|   ├── zmp-system-provider-weixin  ---------------------- 微信服务（扩展）
├── zmp-scheduled  --------------------------------------- 定时任务
├── zmp-common  ------------------------------------------ 公共模块
|   ├── zmp-common-api  ---------------------------------- 
|   ├── zmp-common-redis  -------------------------------- 
|   ├── zmp-common-service  ------------------------------ 
|   ├── zmp-common-upload  ------------------------------- 
|   ├── zmp-common-utils  -------------------------------- 
|   ├── zmp-common-web  ---------------------------------- 

```

### 启动

API web工程 启动类： com.zhenergy.zmp.DemoApplication.java

### 接口访问

http://localhost:8081/swagger-ui.html


