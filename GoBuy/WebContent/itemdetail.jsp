<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>   
<%@ page import="java.sql.*"%>  


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@page import="JavaBean.*"%>
<jsp:useBean id="itembean" class="JavaBean.Item" scope="session"/>
<jsp:useBean id="login" class="JavaBean.Login" scope="session"/>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--  
<?php
  date_default_timezone_set("PRC");
  $nowtime = time();
  $rq = date("Y-m-d",$nowtime);
?>
-->



<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>My JSP 'itemdetail.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/itemdetail.css">
<!-- 	<script language="JavaScript" type="text/javascript" src="js/mydate.js"></script> -->
	<script language="JavaScript" type="text/javascript" src="js/add_and_sub.js" charset="utf-8"></script>
	<script type="text/Javascript" src="js/jquery-2.2.3.min.js"></script>
	
	
  </head>
  
  <body style="background-color:#F5F5F5">
		<div align="center" style="length:25px;width:1200px;background-color:white">
			<div style="float:left;width:158px;length:59px;"><a href="mainpage.jsp"><img src="pic_icon/ICON.jpg" style="height:54px;width:156px;"></a></div>
			<div style="float:right;width:1038px;height:54px;background-color:#00CCFF"><p>上GoBuy，就购了!</p></div>
		</div>		
		<div style="width:1198px;length:544px;">
		
			<div id=1 style="width:988px;length:564px;float:left;">
				<div id="left" style="border:0px;width:505;length:542;float:left">
					<img src="pic_item/<%=itembean.getpic() %>" style="height:340px;width:340px;margin:80px 81px 91px 81px;">
				</div>
				<div id="right" style="border:0px;width:446;length:542;float:right;padding-top:150px">				
					<table>
						<tr>
							<td>商品名称：</td>
							<td><input type="text" id="item_name" value="<%=itembean.getname() %>" readonly="true"></td>
						</tr>
						<tr>
							<td>商品编号：</td>
							<td><input type="text" id="item_ID" value="<%=itembean.getid() %>" readonly="true"></td>
						</tr>
						<tr>
							<td>价格：￥</td>
							<td><input type="text" id="item_price" value="<%=itembean.getprice() %>" readonly="true" ></td>
						</tr>
						<tr>
							<td>数量：</td>
							<td><input type="button" value="-" onClick="subNum()"><input type="text" style="width:30px;" id="num" value=0><input type="button" value="+" onClick="addNum()"></td>
						</tr>
					</table><BR><BR>
					<input type="button" id="addtocart" value="添加到购物车!" style="box-sizing:content-box;font-size:20px">
					<input type="hidden" id="logname" value="<%=login.getLogname() %>">
					<input type="hidden" id="item_pic" value="<%=itembean.getpic() %>">
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
		
		
<script type="text/Javascript">
	$('#addtocart').click(function(){
		var item_id = $("#item_ID").val(); 
		var item_name = $("#item_name").val();
		var item_price = $("#item_price").val();
		var item_pic = $("#item_pic").val();
		var item_num = $("#num").val();
		var item_owner = $("#logname").val();		
		var data = {
				"id":item_id, 
				"name": item_name,
				"price":item_price,
				"pic":item_pic, 
				"num":item_num,
				"owner":item_owner
		}
	    $.ajax({  
	        type:"post",//请求方式  
	        url:"addtocart",//发送请求地址  
	        dataType:"json",  
	        data:data,
	        	//发送给数据库的数据 
	        //请求成功后的回调函数有两个参数  
	        success:function(data,textStatus){ 
	        	alert(JSON.stringify(data.message));
	        }
	});
	    });
</script>



	</body>
</html>
