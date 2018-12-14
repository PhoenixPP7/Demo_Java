package _00_Java.reflect;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;


@SuppressWarnings("serial")
public abstract class UtilDispatcherServlet extends HttpServlet {
	
	private SmartUpload smart = null;
	
	private static final String PAGES_BASENAME = "_00_Java.reflect.Pages" ;		//为通过[ResourceBundle]进行数据加载做准备,必须设置目录,且保存在CLASSPATH中;
	private static final String MESSAGES_BASENAME = "_00_Java.reflect.Messages" ;
	
	private ResourceBundle pagesResource;		//定义两个[ResourceBundle]属性,这样就可以在类的其他方法中使用数据读取操作;
	private ResourceBundle messagesResource;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private Integer currentPage = 1;
	private Integer lineSize = 5;
	private String keyWord;
	private String column;
	
	public void init() throws ServletException {
		//初始化时加载配置文件,且适用于国际化操作;
		this.pagesResource = ResourceBundle.getBundle(PAGES_BASENAME,Locale.getDefault());
		this.messagesResource = ResourceBundle.getBundle(MESSAGES_BASENAME,Locale.getDefault());
	}
	
	public void handleSplit(){
	    try {
	        this.currentPage = Integer.parseInt(this.request.getParameter("currentPage"));
	    } catch (Exception e) {}
	    try {
	    	this.lineSize = Integer.parseInt(this.request.getParameter("lineSize"));
	    } catch (Exception e) {}
	    this.column = request.getParameter("column") ;
	    this.keyWord = request.getParameter("keyWord") ;
	    if (column == null) {
	    	this.column = this.getDefaultColumn();
	    }
	    if (keyWord == null) {
	    	this.keyWord = "";
	    }
	    this.request.setAttribute("currentPage",this.currentPage);
	    this.request.setAttribute("lineSize",this.lineSize);
	    this.request.setAttribute("column",this.column);
	    this.request.setAttribute("keyWord",this.keyWord);
	    this.request.setAttribute("columnData",this.getColumnData());
	}
	
	public Integer getCurrentPage(){
		return currentPage;
	}
	public Integer getLineSize() {
		return lineSize;
	}
	public String getColumn() {
		return column;
	}
	public String getKeyWord() {
		return keyWord;
	}
	
	/**
	 * 取得[Pages.properties]配置文件中定义的访问路径;
	 * @param key 访问路径的key;
	 * @return 配置文件中的路径内容,如果没有返回null;
	 */
	public String getPath(String key) {
		return this.pagesResource.getString(key);
	}
	
	/**
	 * 取得[Messages.properties]配置文件中的配置文字信息;
	 * @param key 访问文字信息的key;
	 * @param args 所有占位符的内容;如果没有设置此参数,则会调用"getTitle()"方法设置的的统一的提示信息;
	 * @return 配置文件中的内容,并且是组合后的结果,如果没有返回null;
	 */
	public String getMsg(String key,String ... args) {
		String note = this.messagesResource.getString(key);
		if (args.length > 0 || this.getTitle() == null) {
			return MessageFormat.format(note,args);
		} else {
			return MessageFormat.format(note,this.getTitle());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		this.request = request;		//将传递进来的"request"保存下来,保存在本类中;
        this.response = response;	//将传递进来的"response"保存下来,保存在本类中;
		String path = this.getPath("errors.page");
		System.out.println("request.getRequestURI() = " + request.getRequestURI());
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (request.getContentType() != null){
		    if (request.getContentType().contains("multipart/form-data")) {
		        this.smart = new SmartUpload();
				try {
					this.smart.initialize(super.getServletConfig(), request, response);
					this.smart.upload();
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
        }
        //通过取得当前类对象"this"和要调用的方法名称"status",就可以利用反射进行调用;
        if (status != null && status.length() > 0) {
        	//在进行参数的处理之前,需要对提交数据进行验证;
        	if(this.validateRequest(status)) {
	        	this.handleRequest();//处理参数与简单Java类之间的自动赋值;
	        	try {	//只有将JSP传来的数据都处理准备完毕之后,才可以执行以下方法;
	        		
	        		System.out.println("this.getClass() = " + this.getClass());
	        		System.out.println("status = " + status);
	        		
					Method method = this.getClass().getMethod(status);	//"this"指的是继承了此抽象类使用此方法的子类;
					//path = (String) method.invoke(this);	//反射调用方法;
					path = this.getPath((String) method.invoke(this)); //   "/index.jsp"
				} catch (Exception e) {
					e.printStackTrace();
				}
//        	} else { //验证失败
//        		String referer = request.getHeader("referer");
//        		System.out.println("referer = " + referer);
//        		if (referer != null) {
//        			String basePath = request.getScheme()+"://"+request.getServerName()+request.getContextPath();
//        			path = referer.replace(basePath, ""); //  "/index.jsp"
//        		}
        	}
        }
        request.getRequestDispatcher(path).forward(request,response);
	}
	
	/**
	 * 根据传入的参数status,加载需要验证的字段;
	 * @param status
	 * @return
	 */
	public boolean validateRequest(String status) {
		boolean flag = false;
		String rule = null;
		try {
			Field field = this.getClass().getDeclaredField(status + "Validate");
			field.setAccessible(true);
			rule = (String) field.get(this); //取出验证规则的数据;
		} catch (Exception e) { //表示数据不存在
			flag = true;
		}
		//需要针对给定的内容进行指定格式的验证;
		if (rule == null || "".equals(rule)) {	//没有规则;
			flag = true;
		} else {	//表示有规则;
			UtilValidateParameter vp = new UtilValidateParameter(this, request,this.smart, rule, this.messagesResource);
			flag = vp.validate();
//			System.out.println(vp.getErrors());
			this.request.setAttribute("errors",vp.getErrors());
		}
		return flag;
	}
	
	/**
	 * 此方法实现判断是否有文件上传;将SmartUpload的方法定义在此类中,将方法进行了封装,对子类隐藏;
	 * @return 没有文件上传,返回false;
	 */
	public boolean isUpload() {
		try {
			return this.smart.getFiles().getSize() > 0 ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 取得上传文件的个数;将SmartUpload的方法定义在此类中,将方法进行了封装,对子类隐藏;
	 * @return 上传文件的数量;
	 */
	public int getUploadCount() {
		return this.smart.getFiles().getCount();
	}
	
	/**
	 * 实现上传文件的保存操作;
	 * @param index SmartUpload 操作索引;
	 * @param fileName 文件名称;
	 * @throws Exception 
	 */
	private void saveFile(int index,String fileName) throws Exception {
		String filePath = super.getServletContext().getRealPath(this.getUploadDirectory()) + fileName;
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (this.smart.getFiles().getFile(index).getContentType().contains("image")){
			this.smart.getFiles().getFile(index).saveAs(filePath);
		}
	}
	
	/**
	 * 实现单个文件删除功能;
	 * @param fileName 要删除的文件名称;
	 */
	public void deleteFile(String fileName) {
		String filePath = super.getServletContext().getRealPath(this.getUploadDirectory()) + fileName;
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
	}
	
	/**
	 * 实现多个文件删除功能;
	 * @param fileName 要删除的文件名称;
	 */
	public void deleteFile(Set<String> all) {
		Iterator<String> iter = all.iterator();
		while(iter.hasNext()) {
			this.deleteFile(iter.next());
		}
	}
	
	/**
	 * 上传文件为单个文件时执行此上传操作;
	 * @param fileName 文件名称;
	 */
	public void upload(String fileName) {
		try {
			this.saveFile(0, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传文件为多个文件时执行此上传操作;
	 * @param fileName 文件名称;
	 */
	public void upload(Map<Integer,String> fileName) {
		Iterator<Map.Entry<Integer,String>> iter = fileName.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer,String> me = iter.next();
			try {
				this.saveFile(me.getKey(),me.getValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 若上传的文件是单个文件,实现对上传的单个文件进行文件命名操作;
	 * @return 创建好的文件名称
	 */
	public String createSingleFileName() {
		String fileName = null;
		if (isUpload()) {
			if(this.smart.getFiles().getFile(0).getContentType().contains("image")){
				fileName = UUID.randomUUID() + "." + this.smart.getFiles().getFile(0).getFileExt();
			}
		}
		return fileName;
	}
	
	public Map<Integer,String> createMultiFileName() {
		Map<Integer,String> all = new HashMap<Integer,String>();
		if (this.isUpload()) {
			for(int x = 0 ; x < this.smart.getFiles().getCount() ; x ++) {
				if(this.smart.getFiles().getFile(x).getContentType().contains("image")){
					String fileName = UUID.randomUUID() + "." + this.smart.getFiles().getFile(x).getFileExt();
					all.put(x, fileName);
				}
			}
		}
		return all;
	}
	
	/**
	 * 取得父类中SmartUpload对象;
	 * @return
	 */
	public SmartUpload getSmart() {
		return this.smart;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private void handleRequest() {
		if (request.getContentType() != null){
			//当前使用了表单封装,意味着有文件上传,赢使用"SmartUpload"接收数据
			if (request.getContentType().contains("multipart/form-data")) {
		    	//取得全部请求参数名称,之后才能确定自动赋值的操作
		    	Enumeration<String> enu = this.smart.getRequest().getParameterNames();
		    	while (enu.hasMoreElements()) {
		    		String paramName = enu.nextElement();
		    		//如果JSP传来的数据包含".",按照定好的规则,说明此数据是需要简单Java类处理的数据;
		    		if (paramName.contains(".")){
		    			UtilAttributeType uat = new UtilAttributeType(this,paramName);
		    			if (uat.getFiledType().contains("[]")) { //按照处理数组的方式处理;
		    				UtilBeanOperate ubo = new UtilBeanOperate(this, paramName, this.smart.getRequest().getParameterValues(paramName));
		    			} else { //按照单个字符串的方式进行处理
		    				UtilBeanOperate ubo = new UtilBeanOperate(this, paramName, this.smart.getRequest().getParameter(paramName));
		    			}
		//System.out.println("paramName的VO类型 = " + at.getFiledType());
		//System.out.println("[Bean处理]-参数名称 = " + paramName + " , 参数内容 = " + request.getParameter(paramName));
		//        		} else if(request.getParameter(paramName).contains("|")) {	//如果JSP传来的数据包含"|",需要进行拆分数据操作;
		    			//System.out.println("[拆分处理]参数名称 = " + paramName + " , 参数内容 = " + request.getParameter(paramName));
		    		}
		    	}
			}
		} else { //当前没有使用表单封装,意味着没有文件上传,应使用普通的"request"对象进行数据的接收
	    	//取得全部请求参数名称,之后才能确定自动赋值的操作
	    	Enumeration<String> enu = request.getParameterNames();
	    	while (enu.hasMoreElements()) {
	    		String paramName = enu.nextElement();
	    		//如果JSP传来的数据包含".",按照定好的规则,说明此数据是需要简单Java类处理的数据;
	    		if (paramName.contains(".")){
	    			UtilAttributeType uat = new UtilAttributeType(this,paramName);
	    			if (uat.getFiledType().contains("[]")) { //按照处理数组的方式处理;
	    				UtilBeanOperate ubo = new UtilBeanOperate(this, paramName, request.getParameterValues(paramName));
	    			} else { //按照单个字符串的方式进行处理
	    				UtilBeanOperate ubo = new UtilBeanOperate(this, paramName, request.getParameter(paramName));
	    			}
	//        		} else if(request.getParameter(paramName).contains("|")) {	//如果JSP传来的数据包含"|",需要进行拆分数据操作;
	    			//System.out.println("[拆分处理]参数名称 = " + paramName + " , 参数内容 = " + request.getParameter(paramName));
	    		}
	    	}
		}
	}
	
	public void setMsgAndUrl(String msgKey,String urlKey){
		this.request.setAttribute("msg", this.getMsg(msgKey, this.getTitle()));
		this.request.setAttribute("url", this.getPath(urlKey));
	}
	
	/**
	 * 此方法交由不同的子类实现,可以由子类设置统一的占位符提示信息名称标记;
	 * @return 返回不同子类的描述信息;
	 */
	public abstract String getTitle();
	
	/**
	 * 取得上传文件的保存目录;
	 * @return
	 */
	public abstract String getUploadDirectory();
	/**
	 * 取得分页搜索条的数据列;
	 * @return
	 */
	public abstract String getColumnData();
	/**
	 * 取得默认查询的数据列;
	 * @return
	 */
	public abstract String getDefaultColumn();
}
