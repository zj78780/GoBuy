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
    	<title>My JSP 'mainpage.jsp' starting page</title>
    	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/mainpage.css">
		<script language="JavaScript">
		startList = function() {  
		if (document.all&&document.getElementById) {  
		navRoot = document.getElementById("nav");  
		for (i=0; i<navRoot.childNodes.length; i++) {  
		node = navRoot.childNodes[i];  
		if (node.nodeName=="LI") {  
		node.onmouseover=function() {  
		this.className+=" over";  
  								}  
  		node.onmouseout=function() {  
  		this.className=this.className.replace(" over", "");  
   								}  
   							}  
  						}  
 					}  
			}  
		window.onload=startList;
		</script>
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
		
			<div id=1 style="width:160px;length:544px;float:left;">
				<div style="length:20px;"><p align="center">商品分类</p></div>
				<div style="length:520px;">
				<ul id="nav">
					<li><a href="showlist_class1?class=家用电器">家用电器</a>
						<ul>
							<li><a href="showlist_class2?class=空调">空调</a></li>
							<li><a href="showlist_class2?class=洗衣机">洗衣机</a></li>
							<li><a href="showlist_class2?class=电视机">电视机</a></li>
							<li><a href="showlist_class2?class=油烟机">油烟机</a></li>
							<li><a href="showlist_class2?class=音响">音响</a></li>
							<li><a href="showlist_class2?class=家庭影院">家庭影院</a></li>
							<li><a href="showlist_class2?class=电饭煲">电饭煲</a></li>
							<li><a href="showlist_class2?class=微波炉">微波炉</a></li>
							<li><a href="showlist_class2?class=电热水器">电热水器</a></li>
							<li><a href="showlist_class2?class=电风扇">电风扇</a></li>
							<li><a href="showlist_class2?class=电烤箱">电烤箱</a></li>
							<li><a href="showlist_class2?class=酒柜">酒柜</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=家具">家具</a>
						<ul>
							<li><a href="showlist_class2?class=卧室">卧室</a></li>
							<li><a href="showlist_class2?class=餐厅">餐厅</a></li>
							<li><a href="showlist_class2?class=客厅">客厅</a></li>
							<li><a href="showlist_class2?class=卫浴">卫浴</a></li>
							<li><a href="showlist_class2?class=厨房">厨房</a></li>
							<li><a href="showlist_class2?class=书房">书房</a></li>
							<li><a href="showlist_class2?class=办公">办公</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=男装">男装</a>
						<ul>
							<li><a href="showlist_class2?class=衬衫">衬衫</a></li>
							<li><a href="showlist_class2?class=牛仔裤">牛仔裤</a></li>
							<li><a href="showlist_class2?class=休闲裤">休闲裤</a></li>
							<li><a href="showlist_class2?class=卫衣">卫衣</a></li>
							<li><a href="showlist_class2?class=西服">西服</a></li>
							<li><a href="showlist_class2?class=羽绒服">羽绒服</a></li>
							<li><a href="showlist_class2?class=夹克">夹克</a></li>
							<li><a href="showlist_class2?class=风衣">风衣</a></li>
							<li><a href="showlist_class2?class=运动">运动</a></li>
							<li><a href="showlist_class2?class=内衣裤">内衣裤</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=女装">女装</a>
						<ul>
							<li><a href="showlist_class2?class=连衣裙">连衣裙</a></li>
							<li><a href="showlist_class2?class=T恤">T恤</a></li>
							<li><a href="showlist_class2?class=针织衫">针织衫</a></li>
							<li><a href="showlist_class2?class=打底裤">打底裤</a></li>
							<li><a href="showlist_class2?class=风衣">风衣</a></li>
							<li><a href="showlist_class2?class=短裙">短裙</a></li>
							<li><a href="showlist_class2?class=礼服">礼服</a></li>
							<li><a href="showlist_class2?class=半身裙">半身裙</a></li>
							<li><a href="showlist_class2?class=牛仔裤">牛仔裤</a></li>
							<li><a href="showlist_class2?class=内衣裤">内衣裤</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=个人化妆">个人化妆</a>
						<ul>
							<li><a href="showlist_class2?class=护肤">护肤</a></li>
							<li><a href="showlist_class2?class=剃须">剃须</a></li>
							<li><a href="showlist_class2?class=面膜">面膜</a></li>
							<li><a href="showlist_class2?class=沐浴">沐浴</a></li>
							<li><a href="showlist_class2?class=护法">护法</a></li>
							<li><a href="showlist_class2?class=牙膏牙粉">牙膏牙粉</a></li>
							<li><a href="showlist_class2?class=牙刷牙线">牙刷牙线</a></li>
							<li><a href="showlist_class2?class=香水">香水</a></li>
							<li><a href="showlist_class2?class=美甲">美甲</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=运动户外">运动户外</a>
						<ul>
							<li><a href="showlist_class2?class=跑步机">跑步机</a></li>
							<li><a href="showlist_class2?class=哑铃">哑铃</a></li>
							<li><a href="showlist_class2?class=踏步机">踏步机</a></li>
							<li><a href="showlist_class2?class=健身单车">健身单车</a></li>
							<li><a href="showlist_class2?class=帐篷">帐篷</a></li>
							<li><a href="showlist_class2?class=滑雪装备">滑雪装备</a></li>
							<li><a href="showlist_class2?class=登山攀岩">登山攀岩</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=鞋子">鞋子</a>
						<ul>
							<li><a href="showlist_class2?class=帆布鞋">帆布鞋</a></li>
							<li><a href="showlist_class2?class=皮鞋">皮鞋</a></li>
							<li><a href="showlist_class2?class=休闲鞋">休闲鞋</a></li>
							<li><a href="showlist_class2?class=运动鞋">运动鞋</a></li>
							<li><a href="showlist_class2?class=靴子">靴子</a></li>
							<li><a href="showlist_class2?class=拖鞋">拖鞋</a></li>
							<li><a href="showlist_class2?class=高跟鞋">高跟鞋</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=皮具">皮具</a>
						<ul>
							<li><a href="showlist_class2?class=手提包">手提包</a></li>
							<li><a href="showlist_class2?class=斜挎包">斜挎包</a></li>
							<li><a href="showlist_class2?class=手包">手包</a></li>
							<li><a href="showlist_class2?class=钱包">钱包</a></li>
							<li><a href="showlist_class2?class=双肩包">双肩包</a></li>
							<li><a href="showlist_class2?class=卡包">卡包</a></li>
							<li><a href="showlist_class2?class=钥匙包">钥匙包</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=图书">图书</a>
						<ul>
							<li><a href="showlist_class2?class=文艺">文艺</a></li>
							<li><a href="showlist_class2?class=儿童">儿童</a></li>
							<li><a href="showlist_class2?class=历史">历史</a></li>
							<li><a href="showlist_class2?class=小说">小说</a></li>
							<li><a href="showlist_class2?class=传记">传记</a></li>
							<li><a href="showlist_class2?class=政治军事">政治军事</a></li>
							<li><a href="showlist_class2?class=社会科学">社会科学</a></li>
						</ul>
					</li>
					<li><a href="showlist_class1?class=其他">其他</a></li>
				</ul>
			
				</div>
			</div>
						
			
			<div id=2 style="width:828px;length:544px;float:left;">				
				<table border="1">
					<tr>
						<td><a href="showitem?Pic=Aux1"><img src="pic_item/Aux1.jpg" style="height:163px;width:200px;"></a></td>	
						<td><a href="showitem?Pic=Aux2"><img src="pic_item/Aux2.jpg" style="height:163px;width:200px;"></a></td>	
						<td><a href="showitem?Pic=Gree1"><img src="pic_item/Gree1.jpg" style="height:163px;width:200px;"></a></td>	
						<td><a href="showitem?Pic=Haier1"><img src="pic_item/Haier1.jpg" style="height:163px;width:200px;"></a></td>	
					</tr>
					<tr>
						<td><a href="showitem?Pic=LG1"><img src="pic_item/LG1.jpg" style="height:163px;width:200px;"></a></td>
						<td><a href="showitem?Pic=Little1"><img src="pic_item/Little1.jpg" style="height:163px;width:200px;"></a></td>
						<td><a href="showitem?Pic=Midea1"><img src="pic_item/Midea1.jpg" style="height:163px;width:200px;"></a></td>
						<td><a href="showitem?Pic=Midea2"><img src="pic_item/Midea2.jpg" style="height:163px;width:200px;"></a></td>
					</tr>
					<tr>
						<td><a href="showitem?Pic=Midea3"><img src="pic_item/Midea3.jpg" style="height:163px;width:200px;"></a></td>
						<td><a href="showitem?Pic=Panasonic1"><img src="pic_item/Panasonic1.jpg" style="height:163px;width:200px;"></a></td>
						<td><a href="showitem?Pic=Siemens1"><img src="pic_item/Siemens1.jpg" style="height:163px;width:200px;"></a></td>
						<td><a href="showitem?Pic=TCL1"><img src="pic_item/TCL1.jpg" style="height:163px;width:200px;"></a></td>
					</tr>			
				</table>			
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