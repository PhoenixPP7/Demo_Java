package _00_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;

public class DemoJDBC {
	//步骤1=定义JDBC驱动程序类
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:pp" ;
	private static final String USER = "scott" ;
	private static final String PASSWORD = "tiger";
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName(DBDRIVER);//步骤1=容器加载数据库驱动程序;不需要实例化,容器负责管理;
		Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD) ;//步骤2=进行数据库连接;使用[DriverManager]类的[getConnection(String url, String user, String password)]方法创建一个[Connection]接口的实例化对象;
		System.out.println(conn);
		
		//步骤3=进行数据库操作=先编写sql语句;再取得[PreparedStatement]接口对象;
		//sql语句如果太长需要换行,则建议前后连接语句的双引号中增加空格;
		
		//数据库更新操作1,[INSERT];[UPDATE],[DELETE]类似;使用[executeUpdate()]方法;
		System.out.println("↓↓↓↓↓↓↓↓↓↓插入操作1↓↓↓↓↓↓↓↓↓↓");
		String name = "Phoenix" ;
		Date birthday = new Date() ;
		int age = 28 ;
		String note = "One People" ;
		String sql = "INSERT INTO people(pid,name,birthday,age,note) VALUES(myseq.nextval,?,?,?,? )";
		//String sql = "UPDATE people SET name=?,birthday=?,age=?,note=? WHERE pid IN(?,?,?)";
		//String sql = "DELETE FROM people WHERE pid IN(?,?,?)";
		PreparedStatement stmt1 = conn.prepareStatement(sql);//使用[Connection]接口的[prepareStatement(String sql)]方法创建一个[PreparedStatement]接口的实例化对象;
		stmt1.setString(1, name);								//第1个"?"位置,设置插入的name数据;
		stmt1.setDate(2, new java.sql.Date(birthday.getTime()));//第2个"?"位置,设置插入的birthday数据;
		stmt1.setInt(3, age);									//第3个"?"位置,设置插入的age数据;
		stmt1.setString(4, note);								//第4个"?"位置,设置插入的note数据;
		int len = stmt1.executeUpdate();						//使用[PreparedStatement]接口的[executeUpdate()]方法获取sql执行后更新的数据行数;
		System.out.println("INSERT更新的数据行数len = " + len);
		
		//数据库查询操作1,[SELECT];使用[executeQuery()]方法;
		System.out.println("↓↓↓↓↓↓↓↓↓↓查询操作1↓↓↓↓↓↓↓↓↓↓");
		String keyWord = "Ph";//设置模糊查询的查询关键字;
		String sql2 = "SELECT pid,name,birthday,age,note FROM people WHERE name LIKE ? ORDER BY pid" ;
		PreparedStatement stmt2 = conn.prepareStatement(sql2);
		stmt2.setString(1, "%" + keyWord + "%");
		ResultSet rs2 = stmt2.executeQuery();//使用[ResultSet executeQuery()]方法创建一个[ResultSet]接口的实例化对象,并执行sql语句获取数据集合;
		while(rs2.next()){//;使用[ResultSet]接口的行获取方法[next()],判断是否还有下一行数据;
			//使用[ResultSet]接口的列获取方法[getXxx(columnIndex)]获取列数据;取列数据时按照数据库表列的顺序取;
			int pid2 = rs2.getInt(1);				//等同写法=rs.getInt("pid");
			String name2 = rs2.getString(2);		//等同写法=rs.getString("name");
			Date birthday2 = rs2.getDate(3);		//等同写法=rs.getDate("birthday");
			int age2 = rs2.getInt(4);				//等同写法=rs.getInt("age");
			String note2 = rs2.getString(5);		//等同写法=rs.getString("note");
			System.out.println(pid2 + "," + name2 + "," + birthday2 + "," +age2 + "," + note2);//输出每行数据;
		}
		
		//数据库查询操作2,[SELECT]分页显示;使用[executeQuery()]方法;
		System.out.println("↓↓↓↓↓↓↓↓↓↓查询操作2-分页显示-显示第一页↓↓↓↓↓↓↓↓↓↓");
		int currentPage = 1 ;//设置当前页;
		int lineSize = 5 ;//设置每页显示行数;
		String sql3 = "SELECT * FROM ( "
				+ " SELECT pid,name,birthday,age,note,ROWNUM rn"
				+ " FROM people "
				+ " WHERE name LIKE ? AND ROWNUM<=?) temp "
				+ " WHERE temp.rn>? ";
		PreparedStatement stmt3 = conn.prepareStatement(sql3);
		stmt3.setString(1, "%" + keyWord + "%");
		stmt3.setInt(2,currentPage * lineSize);
		stmt3.setInt(3,(currentPage - 1) * lineSize);
		ResultSet rs3 = stmt3.executeQuery();
		while(rs3.next()){//循环取出返回每一行的数据;
			int pid3 = rs3.getInt(1);				//等同写法=rs.getInt("pid");
			String name3 = rs3.getString(2);		//等同写法=rs.getString("name");
			Date birthday3 = rs3.getDate(3);	//等同写法=rs.getDate("birthday");
			int age3 = rs3.getInt(4);				//等同写法=rs.getInt("age");
			String note3 = rs3.getString(5);		//等同写法=rs.getString("note");
			System.out.println(pid3 + "," + name3 + "," + birthday3 + "," +age3 + "," + note3);
		}
		
		//数据库查询操作3,统计数据量;使用[executeQuery()]方法;
		System.out.println("↓↓↓↓↓↓↓↓↓↓查询操作3-统计数据量↓↓↓↓↓↓↓↓↓↓");
		String sql4 = "SELECT COUNT(pid) FROM people WHERE name LIKE ? ";
		PreparedStatement stmt4 = conn.prepareStatement(sql4);
		stmt4.setString(1, "%" + keyWord + "%");
		ResultSet rs4 = stmt4.executeQuery();
		if (rs4.next()){
			int count = rs4.getInt(1);//取出第一列数据
			System.out.println("统计出的数据量 = " + count);
		}

		conn.close();//步骤4=关闭数据库连接;
	}
/*	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName(DBDRIVER);
		Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD) ;
		Statement stmt = conn.createStatement();
		conn.setAutoCommit(false);	//取消自动提交
		try{
		stmt.addBatch("INSERT INTO people(pid,name) VALUES(myseq.nextval,'张三1')");
		stmt.addBatch("INSERT INTO people(pid,name) VALUES(myseq.nextval,'张三2')");
		stmt.addBatch("INSERT INTO people(pid,name) VALUES(myseq.nextval,'张三3')");
		stmt.addBatch("INSERT INTO people(pid,name) VALUES(myseq.nextval,'张三4')");
		stmt.addBatch("INSERT INTO people(pid,name) VALUES(myseq.nextval,'张三5')");
		int len [] = stmt.executeBatch();	//执行批处理
		System.out.println("INSERT更新的数据行数len = " + Arrays.toString(len));
		conn.commit();	//如果try语句里面没有错误,则提交;
		} catch (Exception e){
			e.printStackTrace();
			conn.rollback();	//如果try语句里面没有错误,则回滚;
		}
		conn.close();
	}
	*/
}

/*
====================JDBC(Java Database Connective)
=====说明=JDBC是Java数据库连接技术,由Java提供的一组与平台无关的数据库的操作标准(由一组接口组成),数据库是自愿操作,操作完成最后应关闭;
		Java中JDBC数据库操作形式=JDBC网络连接;使用专门的数据库的网络连接指令进行指定主机的数据库操作;
		常用数据库=Oracle、MySQL(MariaDB)、MongoDB。

==========操作数据库
=====说明=操作数据库的类和接口都在[java.sql.*]这个包里面,核心内容如下=
	驱动管理类=[DriverManager];所有关系型数据库都通过此类进行数据库连接;
	四个接口=[Connection]=负责连接;[java.sql Interface Connection]
			[Statement]=有缺陷不用;
			[ResultSet]=对查询的数据操作;
			[PreparedStatement]=负责执行SQL语句;
=====说明=JDBC操作数据库的流程
	步骤0=准备工作;
	步骤1=加载数据库驱动程序;
	步骤2=连接数据库;
	步骤3=操作数据库,CRUD;
	步骤4=关闭数据库连接;
=====步骤0=准备工作
	1=启动数据库服务=[OracleOraDb11g_home1TNSlistener](监听服务)、[OracleServicePP](主服务);
	2=Eclipse加载数据库驱动程序=项目通过"Build Path"-"Add Libraries"-添加"C:\oracle\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar";
=====步骤1=加载数据库驱动程序;
	1=找到Oracle驱动程序类,位置="ojdbc6.jar"下面的oracle.jdbc.driver.OracleDriver;
	2=加载类=使用[java.lang.Class<T>]的[public static Class<?> forName(String className) throws ClassNotFoundException]方法加载驱动程序类;加载即可,不需要实例化,容器负责管理;
		例=Class.forName("oracle.jdbc.driver.OracleDriver");
=====步骤2=连接数据库;
	说明=通过驱动管理类[DriverManager]取得数据库连接,Java中所有的关系型数据库都通过此类完成;=[java.sql.DriverManager];需提前准备以下内容=
		1=数据库的连接地址=[jdbc:oracle:连接方式:@主机名称:端口名称:数据库的SID];
			例=[jdbc:oracle:thin:@localhost:1521:pp];
		2=数据库的用户名=scott;
		3=数据库的密码=tiger;
	方法=
		连接数据库=[public static Connection getConnection(String url, String user, String password) throws SQLException];
			取得一个[Connection]接口的对象;[Connection]对象封装了数据库连接;只要有一个新的[Connection]对象,就代表一个新的数据库连接;
=====步骤3=操作数据库,CRUD(增加Create、读取查询Retrieve、更新Update、删除Delete);
	说明=先取得数据库连接对象[Connection],再加载要操作数据库的SQL语句;
	[Connection]=数据库连接接口=[java.sql Interface Connection]
		方法=
			加载SQL语句=[public PreparedStatement prepareStatement(String sql) throws SQLException];
				传入的参数sql是一个具备特殊标记("?")的完整SQL语句;
				返回值是取得的[PreparedStatement]接口实例化对象;
			关闭数据库连接=[void close() throws SQLException]
	[PreparedStatement]=执行SQL语句的接口=[java.sql Interface PreparedStatement]
		说明=[PreparedStatement]接口的实例化对象需要通过[Connection]接口的[prepareStatement()]方法取得;
			[PreparedStatement]执行的是具备特殊占位标记("?")的完整SQL语句,标记("?")需使用[PreparedStatement]接口中各个setXXX()方法设置具体内容,可以动态的设置数据;
		方法=
			设置SQL语句中特殊占位标记("?")处数据=[public void setXxx(int parameterIndex,String x) throws SQLException];
				例=[setString()]、[setInt()]、[setDouble()]、[setDate()]...;
			执行数据库更新操作=[public int executeUpdate() throws SQLException];SQL语句中[INSERT]、[UPDATE]、[DELETE]是数据库更新操作;
				返回值=int表示更新的数据库行数;
			执行数据库查询操作=[public ResultSet executeQuery() throws SQLException];SQL语句中[SELECT]是数据库查询操作;
				返回值=取得一个[ResultSet]接口的实例化对象;
	[ResultSet]=处理查询出数据的接口,是个集合=[java.sql Interface ResultSet]
		方法=
			判断是否有下一行数据=[public boolean next() throws SQLException];
			取得数据列的内容=[public int getXxx(int columnIndex) throws SQLException];
				例=[getInt()]、[getDouble()]、[getString()]、[getDate()]...;按照数据查询的顺序取得;
=====步骤4=关闭数据库连接;
	使用	[Connection]接口提供的[close()]方法;

==========补充
=====[java.util.Date]和[java.sql.Date]对象数据类型转换
	[PreparedStatement]接口中[public void setDate(int parameterIndex,Date x) throws SQLException]方法,参数Date是[java.sql.Date]对象类型,
	而系统常用的是[java.util.Date]对象类型,需要进行转换,具体如下=
		步骤1=使用[java.util.Date]类中的[public long getTime()]方法,可以将Date转为long;
		步骤2=使用[java.sql.Date]类中的[public Date(long date)]方法,可以将long变为sql.Date;
		例=[new java.sql.Date(java.util.Date.getTime()];

=====连接数据库可能出现的错误;
	监听错误1=监听服务出现错误;
		监听文件=C:\oracle\product\11.2.0\dbhome_1\NETWORK\ADMIN\listener.ora;
		监听的名称文件=C:\oracle\product\11.2.0\dbhome_1\NETWORK\ADMIN\tnsnames.ora;
		如果监听有问题,则修改上面两个文件中"HOST = PP-WIN7"这个位置,设置成与主机名称一致,并重启监听服务[OracleOraDb11g_home1TNSlistener];
	监听错误2=数据库不能找到指定的SID;
		步骤=开始->所有程序->"Oracle - OraDb11g_home1"->"配置和移植工具"->"Net Manager"->找到"LISTENER"->找到"数据库服务"->将"全局数据库名"和"SID"设置为数据库名称并添加;
				该操作会在"C:\oracle\product\11.2.0\dbhome_1\NETWORK\ADMIN\listener.ora"文件新建一个SID配置;

==========批处理与事务处理(了解)
	说明=仅用于演示手工进行批处理及事务处理,实际工作中由容器自动处理;
=====[Connection]接口
	说明=定义有事务处理的方法
	方法=
		设置事务是否自动提交=[public void setAutoCommit(boolean autoCommit) throws SQLException];
		事务提交=[public void commit() throws SQLException];
		事务撤回=[public void rollback() throws SQLException];
=====[Statement]接口
	说明=定义有批处理的方法
		方法=
			增加批处理=[public void addBatch() throws SQLException]方法;
			执行批处理=[Statement]接口[public int[] executeBatch() throws SQLException]方法;
				返回的数组指每个sql语句执行后更新的数据行数的数组;
=====[PreparedStatement]接口
	说明=定义有批处理的方法
	方法=增加批处理=[public void addBatch() throws SQLException]方法;
*/




/*创建测试使用数据库表;下表有序列,pid通过序列生成,序列操作"nextval"伪列取得下一个增长的数值;
DROP TABLE people PURGE ;
DROP SEQUENCE myseq ;
CREATE SEQUENCE myseq ;
CREATE TABLE people(
	pid			NUMBER ,
	name		VARCHAR2(20) ,
	birthday	DATE DEFAULT SYSDATE ,
	age			NUMBER(3) ,
	note		CLOB ,
	CONSTRAINT pk_pid PRIMARY KEY(pid)
)

INSERT INTO people(pid,name,birthday,age,note) VALUES(myseq.nextval,'张三',TO_DATE('1990-10-10','yyyy-mm-dd'),28,'abc');
UPDATE people SET name='李四',birthday=SYSDATE,age=22 WHERE pid IN(5,10,15,20) ;
DELETE FROM people WHERE pid IN(1,6,11,16) ;
 */