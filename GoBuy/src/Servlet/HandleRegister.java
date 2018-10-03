package Servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

import JavaBean.Register;

/**
 * Servlet implementation class HandleRegister
 */
@WebServlet("/HandleRegister")
public class HandleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleRegister() {
        super();
        // TODO Auto-generated constructor stub
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
    }
    
    public String handleString(String s){
		try{
			byte bb[]=s.getBytes("utf-8");
			s=new String(bb);
		}
		catch(Exception ee){}
			return s;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection con;
		Statement sql;
		Register reg=new Register();
		request.setAttribute("register",reg);
		String regname=request.getParameter("regname").trim();
		String password=request.getParameter("password").trim();
		String email=request.getParameter("email").trim();
		String uri="jdbc:mysql://localhost:3306/Test";
		if(regname==null){
			regname="";
		}
		if(password==null){
			password="";
		}
		boolean isLD=true;
		for(int i=0;i<regname.length();i++){
			char c=regname.charAt(i);
			if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0'))){
				isLD=false;
			}
		}
		boolean boo=regname.length()>0&&password.length()>0&&isLD;
		String backnews="";
		boolean Success=false;
		
		try{
			con=DriverManager.getConnection(uri,"root","root");
			String insertCondition="insert into user values('"+regname+"','"+password+"','"+email+"','无')";
			sql=con.createStatement();
			if(boo){
				int m=sql.executeUpdate(insertCondition);
				if(m!=0){
					backnews="注册成功";
					reg.setRegname(regname);
					reg.setPassword(handleString(password));
					reg.setEmail(handleString(password));
					Success=true;
				}
				else{
					Success=false;
					backnews="信息填写不完整或名字中有非法字符";
				}
				con.close();
			}
		}
		catch(SQLException exp){
			exp.getMessage();
			backnews="该会员名已被使用，请更换用户名";

		}
		if(Success==true){
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);			
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.write("<script language='javascript'>alert('"+backnews+"');window.location.href='register.jsp';</script>");

		}
				
		
		
		
		
		
		
		
	}

}
