<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>雇员管理程序</title>
  </head>
  <body>
  <h1>首页</h1>
  	<form action="dept/insert" method="post" enctype="multipart/form-data">
		部门编号=	<input type="text" id="dept.deptno" name="dept.deptno" value="1111">${errors['dept.deptno']}<br>
		部门名称=	<input type="text" id="dept.dname" name="dept.dname" value="部门名称A">${errors['dept.dname']}<br>
		部门位置=	<input type="checkbox" id="dept.loc" name="dept.loc" value="1">位置1
					<input type="checkbox" id="dept.loc" name="dept.loc" value="2">位置2
					<input type="checkbox" id="dept.loc" name="dept.loc" value="3">位置3${errors['dept.loc']}<br>
		公司名字=	<input type="text" id="dept.company.title" name="dept.company.title" value="8888">${errors['dept.company.title']}<br>
		上传文件=	<input type="file" id="photo" name="photo"><br>
					<input type="hidden" name="ids" id="ids" value="1|2|3|4|5">
		<input type="submit" value="提交">
		<input type="reset" value="重置">
  	</form>
  </body>
</html>
