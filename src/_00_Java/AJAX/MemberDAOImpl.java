package _00_Java.AJAX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAOImpl implements IMemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
//	
	public MemberDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Member findById(String id) throws Exception {
		Member vo = null;
		sql = "SELECT mid,password FROM member WHERE mid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
		}
		return vo;
	}

	@Override
	public boolean doCreate(Member vo) throws Exception {
		sql = "INSERT INTO member(mid,password) VALUES(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getPassword());
		return this.pstmt.executeUpdate() > 0;
	}

}
