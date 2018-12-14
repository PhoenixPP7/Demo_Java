package _00_Java.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DemoMySQL {
// [mysql-connector-java-5.0.3-bin.jar]="com.mysql.jdbc.Driver";
// [mysql-connector-java-8.0.12.jar]="com.mysql.cj.jdbc.Driver"
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
//mysql是数据库名称;可通过此命令建立新的名为ajax的数据库=[CREATE DATABASE ajax CHARACTER SET UTF8;]
	private static final String DBURL = "jdbc:mysql://localhost:3306/mysql?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong" ;
	private static final String USER = "root" ; // CG+HOME="root"
	private static final String PASSWORD = "mysql" ; // CG="mysql"; HOME="1q2w3e4r"
	public static void main(String[] args) throws Exception{
		Class.forName(DBDRIVER);
		Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
		System.out.println(conn);
/*		
		String sql = "SELECT mid,name,age,birthday,note FROM member LIMIT ?,?" ;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,0);
		pstmt.setInt(2,5);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()){
			System.err.println(rs.getInt(1) + " ， " + rs.getString(2) + " ， "
					+ rs.getInt(3) + " ， " + rs.getDate(4) + " ， "
					+ rs.getString(5));
		}
		*/
		conn.close();
	}
}

/*
====================MySQL
==========安装MySQL
=====安装[mysql-5.0.22-win32.exe]
=====安装[Navicat for MySQL_11.2.15.exe],一路Next;
	安装之后将[PatchNavicat.exe]复制到"Navicat for MySQL"的安装目录"D:\Program Files\MySQL-Navicat for MySQL";
	执行"PatchNavicat.exe"->对话框选择="navicat.exe"->确定->弹出"Patch successful!"表示破解成功;
====="Navicat for MySQL"
	连接MySQL=连接->MySQL->连接名="自定义,PP MySQL";主机名或IP地址="localhost";端口="3306";用户名="root";密码="mysql"->连接测试->确定;
	使用MySQL=工具->命令列界面
==========加载MySQL驱动程序
	加载数据库驱动1-Eclipse=
		将[mysql-connector-java-5.0.3-bin.jar]拷贝到项目CLASSPATH目录下=MySQLProject->WebRoot->WEB-INF->lib;
	加载数据库驱动1-Tomcat=
		将[mysql-connector-java-5.0.3-bin.jar]拷贝到 "D:\program\Tomcat 8.5\lib"目录下;
==========MySQL说明
=====CG
端口=3306
账号=root
密码=mysql
Windows Service Name=MySQL57
CMD界面的MySQL不支持UTF-8,显示的中文为乱码,可以使用"Navicat for MySQL";
=====Home
端口=3306---3306被占用,已改成"3336"
账号=root
密码=1q2w3e4r
Windows Service Name=MySQL80
mysql 账号=root@localhost
mysql 密码=/qpiYol8l5na

==========启动MySQL服务
方式1=计算机管理->服务->MySQL->"启动"此服务;
方式2=CMD命令->启动MySQL服务="net start mysql";关闭MySQL服务="net stop mysql";



==========MySQL-数据库命令
=====连接MySQL
	CMD->mysql -uroot -pmysql
=====查看全部数据库
	SHOW DATABASES;
=====切换数据库
	USE pp;
=====创建数据库
	CREATE DATABASE pp CHARACTER SET UTF8;
=====删除数据库
	DROP DATABASE IF EXISTS pp;
=====查看全部数据表
	SHOW TABLES;
=====删除数据表
	DROP TABLE IF EXISTS member ;
=====创建数据表
	CREATE TABLE member(
		mid			VARCHAR(50),
		password	VARCHAR(32)	NOT NULL,
		CONSTRAINT pk_mid PRIMARY KEY(mid)
	) ;

==========MySQL数据库其他命令说明
=====与Oracle相比,MySQL使用VARCHAR,日期使用DATETIME,CLOB使用TEXT;
=====MySQL支持自动增长列,AUTO_INCREMENT;
	创建数据表中自动增长的字段时声明=[mid		INT		AUTO_INCREMENT];
=====增加数据行(自动增长列不用再增加设置)=
	NSERT INTO member(age,birthday,name,note) VALUES(10,'1990-10-10 11:11:11','pp','tt');
=====取得自动增长列的当前值=
	SELECT KAST_INSERT_ID();
=====MySQL-分页处理
	SELECT 字段 FROM 表 [WHERE ...] LIMIT 开始行数,取得数据个数;
	SELECT * FROM member LIMIT 5,5;	
	
==========数据库创建脚本
-- 一、删除数据库
DROP DATABASE IF EXISTS ajax;

-- 二、创建数据库
CREATE DATABASE ajax CHARACTER SET UTF8;

-- 三、使用ajax数据库
USE ajax;

-- 四、删除数据表
DROP TABLE IF EXISTS member ;

-- 五、创建数据表
CREATE TABLE member(
	mid			VARCHAR(50),
	password	VARCHAR(32)	NOT NULL,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) ;

-- 六、增加测试数据
--'password' 通过MD5加密后的内容= '5d41402abc4b2a76b9719d911017c592' ;
--'java' 通过MD5加密后的内容= '93f725a07423fe1c889f448b33d21f46' ;
INSERT INTO member(mid,password) VALUES('admin','5d41402abc4b2a76b9719d911017c592') ;
INSERT INTO member(mid,password) VALUES('pp','93f725a07423fe1c889f448b33d21f46') ;

-- 七、事务提交
COMMIT ;








	CREATE TABLE member(
		mid			INT			AUTO_INCREMENT,
		age			INT			NOT NULL,
		birthday	DATETIME,
		name		VARCHAR(50)	NOT NULL,
		note		TEXT,
		CONSTRAINT	pk_mid PRIMARY KEY(mid)
	);



*/