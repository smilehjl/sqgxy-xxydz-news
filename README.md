# 商丘工学院新闻网

### 1、前言

&emsp;&emsp;`sqgxy-xxydz-news`是在大四参加的web大赛的一个项目，与我的队友协同开发，在此过程中收获颇多。

------

### 2、介绍

&emsp;&emsp;商丘工学院新闻官网（信息与电子工程学院）包括前台新闻展示系统及后台管理系统，基于SpringBoot+Vue+MyBatis-Plus实现。前台商城系统包括首页（轮播图、通知公告、工作动态、学院动态）走进信电、学风建设、信电之星、学科竞赛、党史学习、归德书院、学校首页、联系我们等模块。后台管理系统包括普通管理员管理、新闻管理（一级标题和二级标题绑定）、文件管理、信电之星管理、联系方式管理、关于我们、关于本站等模块。

----

### 3、技术选型

技术选项说明（前后端分离）

- 后端：SpringBoot、Mybatis-Plus、Apache  Shiro
- 前端：Vue、Element-UI、Vue-quill-editor（富文本编辑器）

----

### 4、项目演示

##### 1、后台管理系统

后端项目`sqgxy-xxydz-news-backed`地址：https://github.com/macrozheng/mall-admin-web

项目演示地址： http://180.76.56.118/#/login

##### 2、后台接口

后端项目`swagger`地址：http://180.76.56.118:10086/swagger-ui.html

项目演示地址： http://180.76.56.118:10086/swagger-ui.html

##### 3、前台新闻系统

前端项目`sqgxy-xxydz-news-fronted`地址：

项目演示地址：http://180.76.56.118/

---

### 5、项目部署

- 前端
- - 进入到根目录执行`npm install`，再执行`npm run serve`

- 后端
- - 修改`application.yml`中的数据库信息，然后运行即可。

---

### 6、预览图片
- 前端页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/1cf6ee2aac534cd9add5e67829331c7c.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/40027c2bc4dd4274ba14c766597167a4.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/1d22d7e4511640ac8f116beb814ca5be.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/15d720e01df14df3bc068553745f7fa6.png)
- 后端页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/0876b73b7216461aa252780c2bcca50d.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/569b89a95dd247fa8f9d5ff8b53b84c7.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/88e5c994a64f4e159724b6df33ebcb1d.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/fcce967026cb4ec1a058f8229d9d4c29.png)
