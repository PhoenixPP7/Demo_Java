package _00_Java.AJAX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * 本类负责数据库的连接和关闭操作,实例化本类的对象就意味着要进行数据库的开发<br>
 * 本类的构造方法可进行数据库驱动加载和数据库连接的取得;
 * @author pp
*/
public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	private static final String DBURL = "jdbc:mysql://localhost:3306/ajax?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong" ;
	private static final String USER = "root" ; // CG+HOME="root"
	private static final String PASSWORD = "mysql" ; // CG="mysql"; HOME="1q2w3e4r"
	
	private Connection conn = null;
	
	//构造方法负责对conn对象进行实例化;
	public DatabaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getConnection(){//返回数据库的连接对象Connection实例化对象;
		return this.conn;
	}
	public void close() {//负责数据库的关闭;
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
