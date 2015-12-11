##Spring-Boot With Dubbox ##

该项目整合了最新的Spring Boot和功能强大的RPC框架Dubbox<br>
两者都有优点，也都有缺点<br>
最新版本的Spring Boot包含了Metrics模块<br>

### Dubbox官方地址：<br>
[Dubbox](https://github.com/dangdangdotcom/dubbox)：https://github.com/dangdangdotcom/dubbox<br>


### Spring Boot: <br>
 
> 1、微内核<br>
> 2、配置简单<br>
> 3、模块化<br>
> 4、开箱即用<br>
> 5、完全兼容Spring<br>
> 6、设计理念极其先进，很多思想来自OSGi，但是在现有技术的实现<br>


缺点：<br>

 > 二次改造定制难<br>
 > 缺少成熟的SOA或者RPC框架<br>


----------


Dubbox:<br>
-------
 > 1、完全兼容Dubbo<br>
 > 2、功能强大<br>
 > 3、性能强悍<br>
 > 4、运行稳定<br>
 > 5、可扩展性较好, Api和Spi分离<br>

缺点:

> 1、官方停止维护已经两年之久了<br>
 > 2、依赖较为陈旧<br>
 > 3、运行时较重，应该微内核和模块化这个框架<br>
 > 4、配置较为复杂，学习成本较高<br>

建议：<br>

    大家有机会一起维护Dubbox 模块化和微内核这个框架

---------------------------------------------------------

使用：<br>
 > 1、安装Maven<br>
 > 2、下载dubbox，在${dubbox-home}执行mvn clean install -Dmaven.test.skip=true <br> (执行该命令会从中央仓库下载依赖，若一次安装不成功，多执行几次，一般都是网络问题或依赖问题造成的)，最终肯定会成功安装到本地仓库中<br>
 > 3、使用Eclipse/IDEA导入boot-dubbo基本上的结构你就可以看懂了，下述也有简单的描述<br>
 

 ---------------------------------------
 
 boot-dubbo-normal-client<br>

 * 这个项目我想以一个第三方的项目使用dubbox
 * 这个项目跟spring boot没有一点关系。
 
如果仅仅测试dubbo:<br>
 * boot-dubbo-simple-client
 * boot-dubbo-simple

上述两个项目就够用了<br>

boot-dubbo-infrastructure<br>
这个模块项目只与数据库相关，其中集成了Spring-Data-Jpa以及Mybatis<br>
 * Spring-Data-Jpa一般负责增删改，这个及其简单
 * Mybatis负责较为复杂的查询

boot-dubbo-service<br>
该项目依赖api和boot-dubbo-infrastructure<br>
它要实现api约定的接口，另外依赖boot-dubbo-infrastructure对不同数据表的操作以及对事务的操作<br>

boot-dubbo-web<br>
该项目依赖api，它是dubbo的客户端，它通过调用api等于invoke到serice的服务上，从而实现了rpc的调用和服务治理。<br>

说明：<br>
 * service:一般我们的service瓶颈在IO或者数据库上，部署无需太多
 * web:一般的压力在web上，如果很多用户并发，session以及转换都在web上，web建议多部署几台

--------------------------------------
注释：<br>
 * 在实际项目的架构中，Service和Infrastrature(DAO)之间应该还需要一层，就是ProxyDao那么这一层应该在Infrastrature这个当中

 
### JPA:
最后我想说一下JPA这个事情，无论大家最终是否使用JPA，即便使用MyBatis中间件，也会有Entity概念，当然MyBatis理论会有很多的VO对象，我想表达的就是既然这样还不如使用JPA的自动生成表结构这个特性来达到开箱即用（不用再维护数据库表结构），直接安装就可以使用项目，减少了维护工作量。如果真的不需要JPA在项目的运行时阶段（生成表以后）可以删除该配置模块。Spring Boot所带来的一切真的就是这么简单容易。
