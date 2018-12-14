package _00_Java.AJAX;

public class DemoAJAX {
	public static void main(String[] args) {
	}
}

/*
====================AJAX
==========AJAX(异步JavaScript和XML)=Asynchronous JavaScript And XML
	说明=传统MVC数据传输=页面->业务层->数据层,如果页面有多块内容展示,如果仅变更了其中一块内容,传统的方法会整个页面全部加载;
		AJAX实现数据的局部更新,AJAX技术实现与服务器的数据交互,客户端页面利用"JavaScript + DOM解析"的方式重新生成要显示的内容;
		AJAX的主要作用就是局部刷新;搭配AJAX、JavaScript、DOM、XML使用,目前主流使用AJAX与JSON(替换XML)结合使用开发;

==========AJAX基础开发=搭配JavaScript、Servlet;
	说明=操作AJAX,须先取得[XMLHttpRequest]对象,[XMLHttpRequest]对象用于在后台与服务器交换数据,因为所有的异步处理交互及数据回调处理,都是通过XMLHttpRequest对象完成的;
=====[XMLHttpRequest]对象
	说明=所有浏览器都内建了XMLHttpRequest对象,通过JavaScript代码创建XMLHttpRequest对象;例=[xmlhttp=new XMLHttpRequest();]
	方法=
		[XMLHttpRequest.abort()]=取消当前所发出的请求;
		[XMLHttpRequest.getAllResponseHeaders()]=取得所有的HTTP头(报头)信息,以字符串的形式返回,如果没有,则返回null;
		[XMLHttpRequest.getResponseHeader()]=取得一个指定的HTTP头信息,以字符串的形式返回,如果没有,则返回null;
		*[XMLHttpRequest.open()]=创建一个HTTP请求,并指定请求模式,如GET请求POST请求;
			相当于设置请求路径及请求模式(如GET请求POST);
		*[XMLHttpRequest.send()]=将创建的请求发送到服务器端,并接收回应信息;
			表示进行请求的发送,一般设置的内容为null;
		[XMLHttpRequest.setRequestHeader()]=设置一个指定请求的HTTP头信息,须先使用[open()]和[send()]方法之后调用此方法;
	属性=
		以下属性均指客户端接收到的服务器端的返回=
		[XMLHttpRequest.onreadystatechange]=指定当readState状态改变时使用的操作,一般用于指定具体的回调函数;
		[XMLHttpRequest.readyState]=返回当前请求的状态,只读;
			0=请求没有发出(在调用open()函数之前);
			1=请求已建立但还未发出(在调用send()函数之前);
			2=请求已发出正在处理中(这里通常可以从响应得到内容头部);
			3=请求已处理,正在接受服务器信息,响应中通常有部分数据可用,但服务器还没有完成响应;
			4=响应已完成,可以访问服务器响应并使用它;
		[XMLHttpRequest.responseBody]=将回应信息正文以unsigned byte数组形式返回,只读;
		[XMLHttpRequest.responseStream]=以Ado Stream对象的形式返回响应信息,只读;
		[XMLHttpRequest.responseText]=客户端接收服务器端以普通文本形式返回的数据,只读;
			当请求发送到服务器端并成功处理完毕之后,服务器端返回给客户端的数据有两种类型=文本=[responseText],文本形式适用于接收JSON数据;
		[XMLHttpRequest.responseXML]=客户端接收服务器端以XML文档形式回应的数据,只读;
			当请求发送到服务器端并成功处理完毕之后,服务器端返回给客户端的数据有两种类型=XML=[responseXML],XML形式可以直接转化为XML的DOM对象;
		[XMLHttpRequest.status]=返回当前请求的http状态码,只读;
			常见状态码=200(成功访问)、404(无此访问路径)、500(服务器端错误);
		[XMLHttpRequest.statusText]=返回当前请求的响应行状态,只读;
=====总结=详见[DemoAJAXServlet.java]
	此Servlet不再使用[web.xml]配置,使用Annotation;
	通过此程序可以发现,利用AJAX可以方便的进行局部刷新操作,服务器端和客户端的交互不在局限于表单上;但将页面各个局部分别进行处理,页面对应的Servlet程序处理验证就会相应的变的复杂;

==========AJAX开发,搭配数据库;
=====开发要求=实现用户注册功能;
	使用AJAX实现异步验证;验证内容=用户名是否重复 + 验证码;使用工具类=[MD5Code.java]进行密码加密;





*/