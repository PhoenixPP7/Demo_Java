package _00_Java.AJAX;

public interface IMemberDAO {
	/**
	 * 实现根据用户ID查询用户数据;
	 * @param id 要查询的数据ID;
	 * @return 如果查询到有内容数据,则以VO对象的形式返回,如果没有数据返回null;
	 * @throws Exception
	 */
	public Member findById(String id) throws Exception;
	/**
	 * 实现用户数据保存;该操作前应先执行findById()方法;
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(Member vo) throws Exception;
//public boolean findById(Member vo);
//public boolean createId(Member vo) throws Exception;
}
