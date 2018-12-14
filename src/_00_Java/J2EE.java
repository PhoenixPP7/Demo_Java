package _00_Java;
public class J2EE {
	public static void main(String[] args) {
	}
}

/*
====================补充说明-WEB支持的3个CLASSPATH目录=
1.TomcatHOME/lib目录;
2.WEB-INF/classes目录=存放所有的[包].[类].文件名称;
3.WEB-INF/lib目录=存放单个项目的*.jar文件路径;---可以将数据库驱动程序拷贝到此目录,MyEclipse中项目Web App Libraries目录会关联该驱动程序;
====================WEB项目对MyEclipse中项目文件基本结构规定=
[WebRoot]文件夹=虚拟目录的配置路径;
[WebRoot]-[index.jsp]/[index.html]文件=项目首页;
[WebRoot]-[css]=保存样式表文件;
[WebRoot]-[js]=保存JavaScript脚本文件;
[WebRoot]-[images]=保存图片文件;
[WebRoot]-[pages]=保存jsp页面代码文件;
[WebRoot]-[pages]-[front]=保存jsp页面前台代码文件;
[WebRoot]-[pages]-[back]=保存jsp页面后台代码文件;
[WebRoot]-[pages]-[back]-[菜单]=保存jsp页面后台菜单功能;
[WebRoot]-[pages]-[back]-[XX]=保存jsp页面后台不同模块所需要的页面文件;例=[dept];


*/