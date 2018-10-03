package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.rowset.CachedRowSetImpl;

import JavaBean.*;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
        super();
        // TODO Auto-generated constructor stub
        try{
       	 Class.forName("com.mysql.jdbc.Driver"); 
       }
       catch(Exception e){
       	e.getMessage();
       }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession(true);
		Connection con = null;
		StringBuffer presentPageResult =new StringBuffer();
		Cart cartBean =null;
		Login loginBean=null;
		loginBean=(Login)session.getAttribute("login");
		String owner=loginBean.getLogname();
		try{
			cartBean=(Cart)session.getAttribute("cart");
			if(cartBean==null){
				cartBean = new Cart();
				session.setAttribute("cart", cartBean);
			}
		}
		catch(Exception exp){
			cartBean=new Cart();
			session.setAttribute("cart", cartBean);
		}
		
		cartBean.setPageSize(5);
		//int showPage=Integer.parseInt(request.getParameter("showPage"));
		int showPage=1;
		if(showPage>cartBean.getPageAllCount()){
			showPage=1;
		}
		if(showPage<=0){
			showPage=cartBean.getPageAllCount();
		}
		cartBean.setShowPage(showPage);
		int pageSize=cartBean.getPageSize();
		String uri = "jdbc:mysql://localhost:3306/Test"; 
		try{
			con=DriverManager.getConnection(uri, "root", "root");
			Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query="select * from Test.cart where owner='"+owner+"'";
			ResultSet rs=sql.executeQuery(query);
			CachedRowSetImpl rowSet = new CachedRowSetImpl();
			rowSet.populate(rs);
			con.close();
			cartBean.setRowSet(rowSet);
			rowSet.last();
			int m=rowSet.getRow();
			int n=pageSize;
			int pageAllCount=((m%n)==0?(m/n):(m/n)+1);
			cartBean.setPageAllCount(pageAllCount);
			presentPageResult= show(showPage,pageSize,rowSet);
			cartBean.setPresentPageResult(presentPageResult);			
		}
		catch(SQLException exp){
			exp.getMessage();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("shoppingcart.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
	
	public StringBuffer show(int page,int pageSize,CachedRowSetImpl rowSet){
		StringBuffer str=new StringBuffer();
		try{
			rowSet.absolute((page-1)*pageSize+1);
			String pic="";
			String pic_sub="";
			int num=0;
			int price=0;
			for(int i=1;i<=pageSize;i++){
				pic=rowSet.getString(4);
				pic_sub=pic.substring(0, pic.length()-4);
				String pic_src="<a href=showitem?Pic="+pic_sub+"><img src = pic_item/"+rowSet.getString(4)+"  width =100 height =100/></a>";
				num=Integer.parseInt(rowSet.getString(5));
				price=Integer.parseInt(rowSet.getString(3));
				String total=String.valueOf(num*price);
				String button="<input type=submit name=delete value=删除 style=\"box-sizing: content-box;width:80px;line-height:50px;padding:20px 8px 20px 8px;margin:0px\">";
				//System.out.println(rowSet.getString(4)+"\n");
				str.append("<tr><form action=subtocart method=post>");
				str.append("<td>"+pic_src+"</td>");
				str.append("<td><center>"+rowSet.getString(1)+"<input type=hidden name=Pid value="+rowSet.getString(1)+"></center></td>");
				str.append("<td><center>"+rowSet.getString(2)+"</center></td>");
				str.append("<td><center>￥"+rowSet.getString(3)+"</center></td>");
				str.append("<td><center>"+rowSet.getString(5)+"<input type=hidden name=Pnum value="+rowSet.getString(5)+"></center></td>");
				str.append("<td><center>￥"+total+"</center></td>");
				str.append("<td>"+button+"</td>");
				str.append("</form></tr>");
				rowSet.next();
			}
			return str;
			
		}
		catch(SQLException exp){
			return str;
		}
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession(true);
		Connection con = null;
		StringBuffer presentPageResult =new StringBuffer();
		Cart cartBean =null;
		Login loginBean=null;
		loginBean=(Login)session.getAttribute("login");
		String owner=loginBean.getLogname();
		try{
			cartBean=(Cart)session.getAttribute("cart");
			if(cartBean==null){
				cartBean = new Cart();
				session.setAttribute("cart", cartBean);
			}
		}
		catch(Exception exp){
			cartBean=new Cart();
			session.setAttribute("cart", cartBean);
		}
		
		cartBean.setPageSize(5);
//		int showPage;
//		if(request.getParameter("showPage")!=null){
//			showPage=1;
//		}
//		else{
		int showPage=Integer.parseInt(request.getParameter("showPage"));
//		}
		//int showPage=1;
		if(showPage>cartBean.getPageAllCount()){
			showPage=1;
		}
		if(showPage<=0){
			showPage=cartBean.getPageAllCount();
		}
		cartBean.setShowPage(showPage);
		int pageSize=cartBean.getPageSize();
		String uri = "jdbc:mysql://localhost:3306/Test"; 
		try{
			con=DriverManager.getConnection(uri, "root", "root");
			Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query="select * from Test.cart where owner='"+owner+"'";
			ResultSet rs=sql.executeQuery(query);
			CachedRowSetImpl rowSet = new CachedRowSetImpl();
			rowSet.populate(rs);
			con.close();
			cartBean.setRowSet(rowSet);
			rowSet.last();
			int m=rowSet.getRow();
			int n=pageSize;
			int pageAllCount=((m%n)==0?(m/n):(m/n)+1);
			cartBean.setPageAllCount(pageAllCount);
			presentPageResult= show(showPage,pageSize,rowSet);
			cartBean.setPresentPageResult(presentPageResult);
		}
		catch(SQLException exp){
			exp.getMessage();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("shoppingcart.jsp");
		dispatcher.forward(request, response);
	}

}
