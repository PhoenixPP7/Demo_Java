<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分页页面</title>
    <base href="<%=basePath %>">
    <link type="text/css" rel="stylesheet" href="css/ppcss.css">
    
  </head>
  <body>
  <h1>分页页面</h1>
  	<div id="splitSearchDiv">
	    <jsp:include page="/pages/split_page_plugin_search.jsp"/>
	</div>

	  <h1>分页页面</h1>
  	
  	<div id="splitBarDiv" style="float:right">
	    <jsp:include page="/pages/split_page_plugin_bars.jsp"/>
	</div>
  </body>
</html>
