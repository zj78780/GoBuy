package Servlet;

import java.io.IOException;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

import JavaBean.Login;

/**
 * Servlet implementation class HandleLogin
 */
@WebServlet("/HandleLogin")
public class HandleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleLogin() {
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
//		RequestDispatcher dispatcher=request.getRequestDispatcher("mainpage.jsp");
//		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Statement sql;
		Connection con;
		Login loginBean=null;
		String backnews=null;
		HttpSession session=request.getSession(true);
		try{
			loginBean=(Login)session.getAttribute("login");
			if(loginBean==null){
				loginBean=new Login();
				session.setAttribute("login", loginBean);
			}
		}
		catch(Exception ee){
			loginBean =new Login();
			session.setAttribute("login", loginBean);
		}
		
		String logname=request.getParameter("logname").trim();
		String password=request.getParameter("password").trim();
		boolean ok=loginBean.getSuccess();
		logname=handleString(logname);			
		password=handleString(password);
		if(ok==true&&logname.equals(loginBean.getLogname())){
			
			backnews="账户已登录！";
			
		}
		else{
			String uri="jdbc:mysql://localhost:3306/Test";
			boolean boo=(logname.length()>0)&&(password.length()>0);
			try{
				con=DriverManager.getConnection(uri, "root", "root");
				String condition="select * from user where logname ='"+logname+"' and password ='"+password+"'";
				sql=con.createStatement();
				
				if(boo){
					ResultSet rs=sql.executeQuery(condition);
					boolean m=rs.next();
					if(m==true){

						loginBean.setSuccess(true);
						loginBean.setLogname(logname);
						loginBean.setPassword(password);
						loginBean.setEmail(rs.getString("email"));
						loginBean.setAddress(rs.getString("address"));
						
						backnews="登录成功！";
						
					}
					else{
						loginBean.setSuccess(false);
						loginBean.setLogname(logname);
						loginBean.setPassword(password);

						backnews="账户或密码错误！";
						
						
					}
				}
				else{
					loginBean.setSuccess(false);
					loginBean.setLogname(logname);
					loginBean.setPassword(password);
					
					backnews="账户或密码错误！";
			
				}
				con.close();
			}
			catch(SQLException exp){
				loginBean.setSuccess(false);
				exp.getMessage();
			}
			
			
		}
		if(loginBean.getSuccess()==true){
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("mainpage.jsp");
			dispatcher.forward(request, response);			
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.write("<script language='javascript'>alert('"+backnews+"');window.location.href='login.jsp';</script>");

		}
	}

}
