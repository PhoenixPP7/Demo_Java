package _00_Java.AJAX;

public interface IMemberService {
//DatabaseConnection conn = new DatabaseConnection();
//throws Exception
	/**
	 * 调用IMemberDAO.findById()方法,实现用户id判断是否存在的功能;
	 * @param mid 用户输入的mid数据;
	 * @return 如果用户id不存在,返回true;否则返回false;
	 */
	public boolean checkMid(String mid) throws Exception;//此方法实现AJAX异步验证
	/**
	 * 实现用户账号注册功能;<br>
	 * <li> 1.调用IMemberDAO.findById()方法,判断当前要注册的账号信息是否存在;</li>
	 * <li> 2.调用IMemberDAO.doCreate()方法,实现账号增加操作</li>
	 * @param vo
	 * @return 注册成功返回true,否则返回false;
	 */
	public boolean insert(Member vo) throws Exception;
	
}
