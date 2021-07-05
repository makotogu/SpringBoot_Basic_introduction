# 配置文件分类

* SpringBoot是基于约定的，所以很多配置都有默认值，但如果想使用自己的配置替换默认配置的话，可以使用application.properties或者application.yml进行配置。

* properties：

  ``` properties
  server.port=8080
  ```

  

* yml(或者yaml)：

  ``` yml
  server:
  	port: 8080
  ```

* 如果三种配置文件同时存在，优先级最高的是properties，yaml最低，同样属性低优先级会被忽略。

# YAML

* yaml是一种直观的能够被电脑识别的数据序列化格式，并且容易被阅读和交互。以数据为核心的，比xml更加简洁。

* 和其他配置对比

  ``` properties
  server.port=8080
  server.address=127.0.0.1
  ```

  ``` xml
  <server>
      <port>8080</port>
      <address>127.0.0.1</address>
  </server>
  ```

  ``` yaml
  server:
  	port: 8080
  	address: 127.0.0.1
  ```

  简洁，以数据为核心

  ## 基本语法

  * 大小写敏感
  * 数据值前必须有空格，作为分割符
  * 使用缩进表示层级关系
  * 缩进时不允许使用tab键，只允许使用空格（各个系统Tab对应的空格数目不同，导致层次混乱）
  * 缩进的空格数目不重复，只要相同层级的元素左侧对齐即可
  * \# 表示注释，从这个字符一直到行尾都会被解析器忽略

## 数据格式

* 对象(map)：键值对的集合

  ```yaml
  person:
  	name: zhangsan
      
  # 行内写法
  person: {name: zhangsan}
  ```

* 数组：一组按次序排列的值

  ``` yaml
  address:
  	- beijing
  	- shanghai
  # 行内写法
  address: [beijing,shanghai]
  ```

* 纯量：单个的、不可再分的值

  ``` yaml
  msg1: 'hello \n world' # 单引号忽略转义字符
  msg2: "hello \n world" # 双引号识别转义字符
  ```

## 参数引用

``` yaml
name: lisi

person:
	name: ${name}
```



# 读取配置文件内容

1. @Value
2. Environment
3. @ConfigurationProperties

## profile

* 我们开发SpringBoot时，通常同一套程序会被安装到不同环境，比如：开发、测试、生产等。其中数据库地址、服务器端口等等配置都不同，如果每次打包时都要修改配置文件，那会非常麻烦。profile功能就是来进行动态配置切换。
* profile配置
  * 多profile文件方式
  * yml多文档方式
* profile激活方式
  * 配置文件
  * 虚拟机参数
  * 命令行参数

## 内部配置文件加载顺序

* SpringBoot程序启动时，会从以下位置加载配置文件：
  1. file:./config/    当前目录的/config目录下
  2. file:./     当前项目的根目录
  3. classpath:/config/   classpath的/config目录
  4. classpath:/     classpath的根目录
* 高优先级配置的属性会生效

## 外部配置文件加载顺序





# SpringBoot整合其他框架

## springboot整合Junit

* 步骤
  1. 搭建SpringBoot工程
  2. 引入starter-test起步依赖
  3. 编写测试类
  4. 添加测试相关注解
     * @RunWith(SpringRunner.class)
     * @SpringBootTest(classes = 启动类.class)
  5. 编写测试方法

## SpringBoot整合Redis

* 步骤
  1. 搭建SpringBoot工程
  2. 引入redis起步依赖
  3. 配置redis相关属性
  4. 注入redisTemplate模板
  5. 编写测试方法、测试

## SpringBoot整合MyBatis

* 步骤
  1. 搭建SpringBoot工程
  2. 引入mybatis起步依赖，添加mysql驱动
  3. 编写DataSource和mybatis相关配置
  4. 定义表和实体类
  5. 编写dao和mapper文件/纯注解开发
  6. 测试