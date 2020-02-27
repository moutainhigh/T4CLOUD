![T4CLOUD](https://git.t4cloud.com/img/favicon.png "T4CLOUD")


# T4CLOUD  

Spring cloud 快速开发脚手架项目，支持单体BOOT快速部署（无需依赖NACOS等注册中心），也支持复杂模式的CLOUD开发。专业代码生成器一键生成前后端代码，无需考虑支撑功能，拥有方便的鉴权及权限体系，自动化的日志记录系统，让您更好的专注于业务开发即可。

===============

当前最新版本： 0.0.3（发布日期：2020.02.27）

> 源码获取
 + Github：   https://github.com/TeaR7/T4CLOUD
 + Gitee：    https://gitee.com/TRCloud/T4CLOUD
 
```
【当前进度更新】

【2020.02.27】
后台
-a 完成用户权限&角色授权&权限编辑接口
-a 增加用户新增时，验证用户名，编码等校验接口
-a 完成excel导入导出功能，支持大数据模式和普通模式
-a 完成基于minio的文件上传/下载/预览功能
-a 提供支持profiles组件功能
-a 接口增加参数校验的功能
-u 提供新的数据库脚本
-u 将跨域的配置挪动到gateway统一提供
-f 自动生成的SQL权限异常修正

前台
-a 基础表格设计完成实现
-a 树状表格设计完成实现
-a 增加组件权限校验实现
-a 基础搜索组件完成
-a 基础操作组件完成
-a 用户管理demo & 权限管理demo （分别是普通表和树状表）

其他

【计划】

1.完成权限管理功能（包含用户/授权/角色/菜单）
2.系统运维监控功能

```


## 后端技术架构

- 基础框架：Spring Boot & Spring Cloud & Spring Cloud Alibaba

- 网关：Spring Cloud Gateway

- 注册 & 配置中心： Alibaba Nacos Server

- 持久层框架：Mybatis-plus

- 安全框架：Apache Shiro ，Jwt

- 数据库连接池：阿里巴巴Druid

- 缓存框架：Redis

- 定时任务框架：XXL-Job

- 日志打印：logback

- 其他：jackson，poi，Swagger-ui，quartz, lombok（简化代码）等。



## 开发环境

- 语言：Java 8

- IDE(JAVA)： IDEA

- 依赖管理：Maven

- 数据库：MySQL5.7

- 缓存：Redis

- 注册 & 配置中心： Nacos

- 消息队列： Rocket-MQ


## 技术文档


- 在线演示 ：  [http://cloud.t4cloud.com](http://cloud.t4cloud.com)

- 在线教程：  暂无

- 常见问题：  暂无整理

- 问题反馈 ：   [zqr.it@t4cloud.com](zqr.it@t4cloud.com)

## 代码生成器

> 功能说明：   简单易用一键生成基础代码，提供Cloud和Boot两种模式（包括：controller、service、dao、mapper、entity、vue）

```

在code.properties中按提示配置相关信息，然后运行T4CodeGen的main方法即可

```

## 项目规划图

![T4CLOUD](https://ccnu-mooc.oss-cn-shanghai.aliyuncs.com/TeaR/T4CLOUD%E5%BE%AE%E6%9C%8D%E5%8A%A1%E8%84%9A%E6%89%8B%E6%9E%B6.png "T4CLOUD")

> 蓝色节点为已完成，黄色节点为正在进行，其他节点为已规划计划


## 作者

感谢几位伙伴共同努力

> + [yuxiuyu<18896591232@163.com>](mailto:18896591232@163.com)
> + [启明<lindagewu@foxmail.com>](mailto:lindagewu@foxmail.com)
> + [黄焖小鸡<18702114679@163.com>](mailto:18702114679@163.com)
> + [TeaR<zqr.it@t4cloud.com>](mailto:zqr.it@t4cloud.com)

## 写在最后
> + 本项目由现有商业项目中抽离并经过重新梳理设计，个人完成，欢迎大家入群指正我的错误或提出开发意见，任何想法都可以
> + 有朋友加入一起完善就更好了，给各自的简历加一些重量！
> + 适合用作个人项目，个人私活，中小型公司项目的快速开发
> + [zqr.it@t4cloud.com](zqr.it@t4cloud.com)


