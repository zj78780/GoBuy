<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@page import="JavaBean.*"%>
<jsp:useBean id="login" class="JavaBean.Login" scope="session"/>
<jsp:useBean id="cart" class="JavaBean.Cart" scope="session"/>
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>My JSP 'shoppingcart.jsp' starting page</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/mainpage.css">
	</head>
	<body style="background-color:#F5F5F5">
		<div align="center" style="length:25px;width:1200px;background-color:white">
			<div style="float:left;width:158px;length:59px;"><a href="mainpage.jsp"><img src="pic_icon/ICON.jpg" style="height:54px;width:156px;"></a></div>
			<div style="float:right;width:1038px;height:54px;background-color:#00CCFF"><p>上GoBuy，就购了!</p></div>
		</div>		
		<div style="width:1198px;length:544px;">
		
			<div id=1 style="width:988px;length:544px;float:left;">
			<div id=1_1 style="width:986px"><center>
			<BR>当前您的购物车内容
				<table border=1>
					<tr>
						<th>商品图片</th>
						<th>商品ID</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>商品数量</th>
						<th>商品总价</th>
						<th>删除商品</th>
					</tr>
					<jsp:getProperty name="cart" property="presentPageResult"/>
				</table>
				<BR>每页最多显示 <Font color=blue><jsp:getProperty name="cart" property="pageSize"/></Font> 条商品信息
				<BR>当前显示第<Font color=blue>
					<jsp:getProperty name="cart" property="showPage"/>
					</Font>页，共有
					<Font color=blue><jsp:getProperty name="cart" property="pageAllCount"/>
					</Font>页。
				<BR>单击“上一页”或“下一页”按钮查看信息
				<table>
					<tr>
						<td>
							<form action="showcart" method="post">
							<input type=hidden name="showPage" value="<%=cart.getShowPage()-1 %>">
							<input type=submit name="g" value="上一页">
							</form>
						</td>
						<td>
							<form action="showcart" method="post">
							<input type=hidden name="showPage" value="<%=cart.getShowPage()+1 %>">
							<input type=submit name="g" value="下一页">
							</form>
						</td>
						<td>
							<form action="showcart" method="post">
							输入页码：<input type=text name="showPage" size=5>
							<input type=submit name="g" value="提交">
							</form>
						</td>
					</tr>
				</table>
			</center></div>
			<div id=1_2 style="width:986px;height:40px">
				<form action="showorder" method="post">
				<div style="float:left;width:420px;height:38px;border:0px;margin-left:120px;"><center>
					<Font size=3px>付款方式：</Font>
					<select name="pay">
  						<option value ="支付宝">支付宝</option>
  						<option value ="微信支付">微信支付</option>
  						<option value="银联支付">银联支付</option>
  						<option value="信用卡">信用卡</option>
					</select></center>
				</div>
				<div style="float:right;width:420px;height:38px;background-color:orange"><center style="height:38px"><input type=submit value="去结算！" style="height:18px;width:200px;padding:10px 10px;margin:7px 15px;box-sizing:content-box;"></center></div>
				</form>		
			</div>
			</div>
						
			
			
			
			
			
			<div id=3 style="width:204px;length:544px;float:left;">
				<div style="length:5px;">当前用户： <a href="user.jsp"><Font color=blue><jsp:getProperty name="login" property="logname"/></Font></a></div>
				<div style="length:5px;"><p align="center"><a href="mainpage.jsp">回到首页</a></p></div>
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