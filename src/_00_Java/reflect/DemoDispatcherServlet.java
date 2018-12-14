package _00_Java.reflect;

import java.io.File;

import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/dept/*")
public class DemoDispatcherServlet extends UtilDispatcherServlet {
	private final String insertValidate = "dept.deptno|dept.dname|dept.loc|dept.company.title";
	private final String updateValidate = "dept.deptno|dept.dname|dept.loc";
	private Dept dept = new Dept();
	
	public String insert() {
	System.out.println("**************** insert **************");
//	System.out.println("跳转路径 = " + super.getPath("errors.page"));
//	System.out.println("提示信息 = " + super.getMsg("insert.success.msg"));
//	System.out.println(dept);
		if (super.isUpload()) {
			String fileName = super.createSingleFileName();
			super.upload(fileName);
		}
		super.setMsgAndUrl("insert.success.msg", "index.page");
		return "forward.page";
	}
	
	public String list() {
		System.out.println("**************** list **************");
		super.handleSplit(); //处理分页;
		//需要通过Servlet传递url、allRecorders;
		super.request.setAttribute("url", "/dept/list");
		super.request.setAttribute("allRecorders", 97);
		return "dept.list.page";
	}
	
	public String update() {
		System.out.println("**************** update **************");
		return "";
	}

	@Override
	public String getTitle() {
		return "部门";
	}
	
	public Dept getDept(){
		return dept;
	}

	@Override
	public String getUploadDirectory() {
		return "/upload" + File.separator + "dept" + File.separator;
	}

	@Override
	public String getColumnData() {
		return "部门名称:dname|公司名称:title";
	}

	@Override
	public String getDefaultColumn() {
		return "dname";
	}
}
