package _00_Java.AJAX;

import java.sql.Connection;

public class DAOFactory {
//MemberDAOImpl = static IMemberDAO
	public static IMemberDAO getIMemberDAOInstance(Connection conn) {
		return new MemberDAOImpl(conn);
	}
}
