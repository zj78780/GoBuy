<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@page import="JavaBean.*"%>
<jsp:useBean id="login" class="JavaBean.Login" scope="session"/>
<jsp:useBean id="show_1" class="JavaBean.ItemList" scope="session"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">    
    	<title>My JSP 'itemlist_class1.jsp' starting page</title>
    	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/mainpage.css">
	</head>
	<body style="background-color:#F5F5F5">
		<!-- <div style="c;length:580px" align="center"> -->
		<div align="center" style="length:25px;width:1200px;background-color:white">
			<div style="float:left;width:158px;length:59px;"><a href="mainpage.jsp"><img src="pic_icon/ICON.jpg" style="height:54px;width:156px;"></a></div>
			<div style="float:right;width:1038px;height:54px;background-color:#00CCFF"><p>上GoBuy，就购了!</p></div>
		</div>		
		<div style="width:1198px;length:544px;">
		
			<div id=1 style="width:988px;length:544px;float:left;">
			<center>
			<BR>当前显示内容
				<table border=1>
					<tr>
						<th>商品图片</th>
						<th>商品ID</th>
						<th>商品名称</th>
						<th>商品价格</th>
					</tr>
					<jsp:getProperty name="show_1" property="presentPageResult"/>
				</table>
				<BR>每页最多显示 <Font color=blue><jsp:getProperty name="show_1" property="pageSize"/></Font> 条商品信息
				<BR>当前显示第<Font color=blue>
					<jsp:getProperty name="show_1" property="showPage"/>
					</Font>页，共有
					<Font color=blue><jsp:getProperty name="show_1" property="pageAllCount"/>
					</Font>页。
				<BR>单击“上一页”或“下一页”按钮查看信息
				<table>
					<tr>
						<td>
							<form action="showlist_class1" method="post">
							<input type=hidden name="showPage" value="<%=show_1.getShowPage()-1 %>">
							<input type=submit name="g" value="上一页">
							</form>
						</td>
						<td>
							<form action="showlist_class1" method="post">
							<input type=hidden name="showPage" value="<%=show_1.getShowPage()+1 %>">
							<input type=submit name="g" value="下一页">
							</form>
						</td>
						<td>
							<form action="showlist_class1" method="post">
							输入页码：<input type=text name="showPage" size=5>
							<input type=submit name="g" value="提交">
							</form>
						</td>
					</tr>
				</table>
			</center>
			
			
			
			
			
				
			
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