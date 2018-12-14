<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>AJAX</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("sendBut").addEventListener("click",sendEcho,false);
	}

	var xmlHttpRequest; // 定义一个用于保存AJAX的核心处理对象
	// 定义一个操作函数,功能是进行xmlHttpRequest的对象实例化;
	function createXMLHttpRequest() {
		if(window.XMLHttpRequest) {	// 非IE浏览器对象实例化
			xmlHttpRequest = new XMLHttpRequest();
		} else { // IE浏览器对象实例化
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHttp");
		}
	}
	
	function sendEcho(){
		//取出用户输入的数据
		var info = document.getElementById("info").value;
		if(info != "") {	// 判断info的值是否为空
			createXMLHttpRequest();	// 调用创建xmlHttpRequest对象的函数;
			//设置要提交数据的路径及数据的提交模式,而后使用地址重写的方式传递数据
//var basePath = "<%=basePath%>";
//alert("basePath 1" + basePath);
			xmlHttpRequest.open("post", "<%=basePath%>EchoServlet?msg=" + info);
//alert("basePath 2" + basePath);
			xmlHttpRequest.onreadystatechange = sendEchoCallback;
			xmlHttpRequest.send(null); //发送请求,此次设置为null即可;
		}
		//回应完成后将输入框情况
		document.getElementById("info").value = "";
	}
	function sendEchoCallback() {	//AJAX回调函数
//alert(xmlHttpRequest.responseText);
//alert("status = " + xmlHttpRequest.status + " ;readyState = " + xmlHttpRequest.readyState + " ; 回应数据 = " + xmlHttpRequest.responseText);
		if(xmlHttpRequest.status == 200) { // 判断服务器端是否处理正常
			if(xmlHttpRequest.readyState == 2 || xmlHttpRequest.readyState == 3) {// 2 或 3的状态表明服务器还在处理,还未返回
//alert("请稍后,服务器正在处理数据!");
			}
			if(xmlHttpRequest.readyState == 4) { // 4状态表示服务器端已处理完成,可以进行页面处理了;
				var data = xmlHttpRequest.responseText; //取得服务器端回应的数据;
//alert("data = " +data);
				// 利用DOM操作,将取得的回应数据显示在页面上;
				var divElement = document.createElement("div");
/* var inputElement = document.createElement("input");
inputElement.setAttribute("type","text");
inputElement.setAttribute("value",data);
divElement.appendChild(inputElement);
document.getElementById("echoDiv").appendChild(divElement); */
				divElement.appendChild(document.createTextNode(data));
				document.getElementById("echoDiv").appendChild(divElement);
			}
		}
	}
	
</script>
</head>
<body>
	<div id="inputDiv">
		<input type="text" name="info" id="info">
		<input type="button" name="sendBut" id="sendBut" value="发送信息">
	</div>
	<div id="echoDiv">
		
	</div>
</body>
</html>