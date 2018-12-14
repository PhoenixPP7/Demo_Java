package _00_Java.AJAX;

public class MemberServiceImpl implements IMemberService {
//this.dbc.close();
	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean checkMid(String mid) throws Exception{
		try {
			return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(mid) == null;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean insert(Member vo) throws Exception  {
		try {
			if(DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(vo.getMid()) == null) {
				return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
