# SpringBoot 概述

* 一种快速使用Spring的方式，基于约定优于配置的思想，可以让开发人员不必在配置与逻辑业务之间进行思维的切换。

* Spring的缺点
  1. 配置繁琐
  2. 依赖繁琐
* SpringBoot功能
  1. 自动配置
  2. 起步依赖
  3. 辅助功能

# SpringBoot快速入门

## 需求

* 搭建SpringBoot工程，定义HelloController.hello()方法，返回"Hello SpringBoot"

## 实现步骤

1. 创建Maven项目
2. 导入SpringBoot起步依赖
3. 定义controller
4. 编写引导类
5. 启动测试

## 需求

* 使用idea快速构建SpringBoot工程

## SpringBoot起步依赖原理分析

1. spring-boot-starter-parent
2. spring-boot-starter-web

### 小结

* spring-boot-starter-parent中定义了各种技术的版本信息，组合了一套最优搭配的技术版本
* 在各种starter中，定义了完成该功能需要的坐标合集，其中大部分信息来自于父工程
* 我们的工程继承parent，引入starter后，通过以来传递，皆可以简单方便获得需要的jar包，并且不会存在版本冲突的问题

