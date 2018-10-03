<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=1 style="width:1168px;height:800px;">
	<div id=1_1 style="float:left;width:310px;margin:150px 0px 150px 250px;padding-right:60px;border-right-style:solid">
		<img src="pic_icon/ICON.jpg" style="height:280px;width:310px;">
	
	</div>
	<div id=1_2 style="float:right;width:245px;margin:200px 250px 150px 50px">
		<form name="loginform" action="helpLogin" method="post" >
			<div>
				<table>
					<tr>
						<td>用户名：</td><td><input type="text" name="logname"></td>					
					</tr>
					<tr>
						<td>密码：</td><td><input type="password" name="password"></td>
					</tr>
				</table>
			</div><BR><BR>
			<div style="float:left"><input type="submit" name="submitbutton" value=" 立即登录！ " style="box-sizing:content-box;font-size:20px"></div><BR><BR><BR><BR>		
			<div><a href="register.jsp">没有账户？点击注册！</a></div>
		</form>
	</div>
	</div>
</body>
</html>


