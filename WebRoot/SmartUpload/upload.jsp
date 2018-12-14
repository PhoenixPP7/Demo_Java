<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.*"%>
<%@ page import="java.util.*" %>
<html>
<head>
<title>SmartUpload上传</title>
</head>
<%
	//1.实例化SmartUpload类对象;
	SmartUpload smart = new SmartUpload();
	//2.初始化上传环境;
	smart.initialize(config, request, response);
	//3.接受所有的上传数据;
	smart.upload();
	//4.进行文件保存;
	
/* 
	smart.save("/upload");//将上传文件保存在此目录下;
	//取得MIME类型;
	String contentType = smart.getFiles().getFile(x).getContentType();
	//取得单个上传文件的大小;
	int size = smart.getFiles().getFile(x).getSize();
	//取得上传文件的扩展名;
	String ext  = smart.getFiles().getFile(x).getFileExt();
*/
	 
/* 	 
	//上传的文件信息已经保存在了smart对象中,通过方法将其保存在指定位置并随机命名;
	if (smart.getFiles().getSize() > 0 ){//判断上传文件有内容
		for (int x = 0 ; x < smart.getFiles().getCount() ; x ++) {
			if (smart.getFiles().getFile(x).getContentType().contains("image")){//判断是否图片类型
				if (smart.getFiles().getFile(x).getSize() > 0 ){//判断文件大小
					String fileName = UUID.randomUUID() + "." + smart.getFiles().getFile(x).getFileExt();//取得文件扩展名;
					String filePath = getServletContext().getRealPath("/upload/") + fileName;//定义文件保存位置路径;
					smart.getFiles().getFile(x).saveAs(filePath);//保存文件;
				}
			}
		}
	}
*/

	String fileName = null;
	if (smart.getFiles().getSize() > 0 ){//判断上传文件有内容
		if (smart.getFiles().getFile(0).getContentType().contains("image")){
			if (smart.getFiles().getFile(0).getSize() > 0 ){
				fileName = UUID.randomUUID() + "." + smart.getFiles().getFile(0).getFileExt();//取得文件扩展名;
				String filePath = getServletContext().getRealPath("/upload/") + fileName;//定义文件保存位置路径;
				smart.getFiles().getFile(0).saveAs(filePath);//保存文件;
			}
		}
	}
	 
	String name = smart.getRequest().getParameter("name");
	int age = Integer.parseInt(smart.getRequest().getParameter("age"));
%>
<h1>姓名=<%=name%></h1>
<h1>年龄=<%=age%></h1>
<img src="<%=request.getContextPath()%>/upload/<%=fileName%>" width="50%">

<body>
</body>
</html>
