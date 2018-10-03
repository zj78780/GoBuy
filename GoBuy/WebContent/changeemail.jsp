<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@page import="JavaBean.Login" %>
<jsp:useBean id="login" class="JavaBean.Login" scope="session"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">    
    	<title>My JSP 'changeemail.jsp' starting page</title>
    	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/mainpage.css">
	<title>Insert title here</title>
	</head>
	<body style="background-color:#F5F5F5">
		<!-- <div style="c;length:580px" align="center"> -->
		<div align="center" style="length:25px;width:1200px;background-color:white">
			<div style="float:left;width:158px;length:59px;"><a href="mainpage.jsp"><img src="pic_icon/ICON.jpg" style="height:54px;width:156px;"></a></div>
			<div style="float:right;width:1038px;height:54px;background-color:#00CCFF"><p>上GoBuy，就购了!</p></div>
		</div>		
		<!-- <div style="length:15px;"><p align="left">最新消息：   <a href="#" style="color:red;">品牌特卖</a>&nbsp;&nbsp;<a href="#" style="color:blue;">新品促销</a>&nbsp;&nbsp;<a href="#" style="color:green;">最新折扣</a></p></div> -->
		<div style="width:1198px;length:544px;">
		
			<div id=1 style="width:988px;length:544px;float:left;">
				<div id=1_1 style="width:988px;length:200px;border:0px;padding-bottom:40px;border-bottom:2px;border-bottom-style:solid">
					<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<Font size=25px;><i><b>Hi!</b></i></Font>&nbsp&nbsp&nbsp&nbsp&nbsp<Font size=6px color=blue><jsp:getProperty name="login" property="logname"/></Font></p>
				</div>
				<div id=1_2 style="width:988px;length:240px;border:0px;padding-left:150px;padding-bottom:60px;padding-top:30px;border-bottom:2px;border-bottom-style:solid">
					<table><form action="changeEm" method="post">
						<tr>
							<td>
								输入新邮箱：
							</td>
							<td>
								<input type="text"  name="newEmail">
							</td>
							<td>

							</td>
						</tr>
						<tr>
							<td>
								确认新邮箱：
							</td>
							<td>
								<input type="text" name="confirmEmail">
							</td>
							<td>
								<input type="submit" value="确认更改" style="box-sizing:content-box;font-size:20px">
							</td>
						</tr>
					</table>
				</div>
				<div id=1_3 style="width:988px;length:100px;border:0px;padding-left:150px;padding-bottom:31px;padding-top:13px">
					<p><a href="login.jsp">退出登录/更换账户</a></p>
					<p><a href="register.jsp">注册新账户</a></p>
					<p><a href="#">更多账户支持</a></p>
				</div>
				
			</div>			
			
			<div id=3 style="width:204px;length:500px;float:left;">
				<div style="length:5px;">当前用户： <a href="user.jsp"><Font color=blue><jsp:getProperty name="login" property="logname"/></Font></a></div>
				<div style="length:5px;"><p align="center"><a href="showcart">我的购物车</a></p></div>
				<div style="length:420px;width:200px">
					<table border="1">
					<tr>
						<td><a href="#"><img src="pic_icon/1.jpg" style="height:75px;width:94px;"></a></td>
						<td><a href="#"><img src="pic_icon/2.jpg" style="height:75px;width:94px;"></a></td>
					</tr>
					<tr>
						<td><a href="#"><img src="pic_icon/3.jpg" style="height:75px;width:94px;"></a></td>
						<td><a href="#"><img src="pic_icon/4.jpg" style="height:75px;width:94px;"></a></td>
					</tr>
					<tr>
						<td><a href="#"><img src="pic_icon/5.jpg" style="height:75px;width:94px;"></a></td>
						<td><a href="#"><img src="pic_icon/6.jpg" style="height:75px;width:94px;"></a></td>
					</tr>
					<tr>
						<td><a href="#"><img src="pic_icon/7.jpg" style="height:75px;width:94px;"></a></td>
						<td><a href="#"><img src="pic_icon/8.jpg" style="height:75px;width:94px;"></a></td>
					</tr>
					<tr>
						<td><a href="#"><img src="pic_icon/9.jpg" style="height:75px;width:94px;"></a></td>
						<td><a href="#"><img src="pic_icon/10.jpg" style="height:75px;width:94px;"></a></td>
					</tr>			
				</table>
				</div>
			</div>
		</div>
	</div>



	</body>
</html>