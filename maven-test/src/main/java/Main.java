/*Maven的生命周期(Lifecycle)：Maven命令
* 1：clean：清楚target目录(这个存的是编译完成之后的class文件)
* 2：compile：Maven自带的编译命令：编译src/main/java和src/main/resources
* 3：package：打包：将产品打包jar包或者war包(web文件)
* 4：install：安装：将打包好的产品安装到本地仓库
* 5：deploy：发布：将打包好的产品发布到远程的仓库(一般是公司配置的Maven仓库，也叫Maven私服)
* 总结：2-4命令：后边的命令先执行前面的命令*/
/*Maven的插件：Plugins：用来进行配置所需插件的版本*/

/*一：web:项目开发*/
/*1：(在pom.xml中)打印包的类型：<packaging>war</packaging>：打包成war文件格式
* 2：右键项目设置，在生成的web，配置webapp(也就是web资源文件夹)，配置web.xml文件(web项目的额描述文件)
* 3：右键new一个HTML文件即可*/
/*二：web：项目部署：
* maven package命令打包，复制war包到Tomcat根路径/webapps目录下(手工部署)
* 以后的工作中/测试学习中会有自动化构建工具(jenkins),可以做自动发布的工作；现在的maven就是一个构建工具
* 打包之后因为默认名字比较长，可以进行改动
*       <build>
        <finalName>test</finalName>
        </build>
* 注意：一般打包成war的时候，会进行修改(指定finalName)；一般打成jar包的时候不用进行修改
* 打包是以finalName作为文件名的额，如果没有配置的话，默认是artifactId-version作为
* 文件名的，文件后缀以packaging类型来进行设置*/
/*三：web项目的运行：需要启动Tomcat
* 1：Tomcat根路径的webapps加载下面的项目
* 2：解压我们自己打包好的war文件
*/
/*四：web项目使用(访问)(面试可能会问到)
* 1：项目/引用的部署名：war文件的名称
* 2：Tomcat查找URL对应的资源：URL以http://ip:port/....
*    后面路径以webapps下相对路径来进行查找是需要进行一一映射的
*/

/*web项目编译/打包流程：(也就是package命令打包成war包的流程)
* 1：类似普通java项目打包一样：src/main/java和src/main/resources编译
*    或者复制到target/classes目录
* 2：生成web项目的部署文件夹(finalName命名)：
*   2.1：复制web资源文件夹
*   2.2：复制编译好的target/classes文件夹到WEB-INF/classes
*   2.3：复制依赖包到WEB-INF/lib
* 3：打包：将第二个步骤生成的文件夹打包成war包
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("ok");
    }

}
