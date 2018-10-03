<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@page import="JavaBean.*"%>
<jsp:useBean id="login" class="JavaBean.Login" scope="session"/>
<jsp:useBean id="order" class="JavaBean.Order" scope="session"/>

    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>My JSP 'showorder.jsp' starting page</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/mainpage.css">
	
	</head>
	<body style="background-color:#F5F5F5" onload="ReturnSum()">
		<div align="center" style="length:25px;width:1200px;background-color:white">
			<div style="float:left;width:158px;length:59px;"><a href="mainpage.jsp"><img src="pic_icon/ICON.jpg" style="height:54px;width:156px;"></a></div>
			<div style="float:right;width:1038px;height:54px;background-color:#00CCFF"><p>上GoBuy，就购了!</p></div>
		</div>		
		<div style="width:1198px;length:544px;">
		
			<div id=1 style="width:988px;length:544px;float:left;">
			<div id=1_1 style="width:988px;length:200px;border:0px;padding-bottom:40px;border-bottom:2px;border-bottom-style:solid">
					<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<Font size=25px;><i><b>Hi!</b></i></Font>&nbsp&nbsp&nbsp&nbsp&nbsp<Font size=6px color=blue><jsp:getProperty name="login" property="logname"/></Font></p>
				</div>
			<div id=1_2 style="width:986px">
			<center>
			<BR><font size="5" color="red">我的订单</font>
			<table border=1>
					<table border=1>
						<tr>
							<th>订单号</th>
							<th>订单生成时间</th>
							<th>订单状态</th>
						</tr>
						<jsp:getProperty name="order" property="allPageResult"/>
					</table>
			</center>
			</div>
			</div>
						
			
			
			
			
			
			<div id=3 style="width:204px;length:544px;float:left;">
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
		
	</body>
	
	
	
	
	
</html>