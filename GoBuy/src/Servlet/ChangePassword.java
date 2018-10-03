package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.Login;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		
		
		String pd_1="";
		String pd_2="";
		String logname="";
		pd_1=request.getParameter("newPassword");
		pd_2=request.getParameter("confirmPassword");
		Login loginBean=null;
		
		HttpSession session=request.getSession(true);
		loginBean=(Login)session.getAttribute("login");
		logname=loginBean.getLogname();
		
//		System.out.println("new: "+pd_1+"|confirm: "+pd_2+"|logname: "+logname);
		
		if(pd_1.equals(pd_2)==true)
		{
			Connection con;
			Statement sql;
			String uri="jdbc:mysql://localhost:3306/Test";
			try{
				con=DriverManager.getConnection(uri,"root","root");
				String updateCondition="UPDATE Test.user SET password = '"+pd_1+"' WHERE logname = '"+logname+"' ";
				sql=con.createStatement();
				int m=sql.executeUpdate(updateCondition);
				if(m!=0){
					loginBean.setPassword(pd_1);
					String backnews="密码修改成功";
					PrintWriter out = response.getWriter();
					out.write("<script language='javascript'>alert('"+backnews+"');window.location.href='user.jsp';</script>");
				}
				else{
					String backnews="警告：密码修改失败！";
					PrintWriter out = response.getWriter();
					out.write("<script language='javascript'>alert('"+backnews+"');window.location.href='changepassword.jsp';</script>");
				}
			}
			catch(SQLException exp){
				loginBean.setSuccess(false);
				exp.getMessage();
			}
		}
		else{
			String backnews="警告：两次密码输入不匹配，请重新输入！";
			PrintWriter out = response.getWriter();
			out.write("<script language='javascript'>alert('"+backnews+"');window.location.href='changepassword.jsp';</script>");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
