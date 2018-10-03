package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.*;

/**
 * Servlet implementation class SubToCart
 */
@WebServlet("/SubToCart")
public class SubToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubToCart() {
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
		
		String id=request.getParameter("Pid");
		int num=Integer.parseInt(request.getParameter("Pnum"));
		String owner=null;
		
		HttpSession session=request.getSession(true);
//		Connection con = null;
		Login loginBean=null;
		loginBean=(Login)session.getAttribute("login");
		owner=loginBean.getLogname();
		
//		boolean Success=false;
//		String backnews="";
		try{

			Connection con;
			Statement sql;

			String uri="jdbc:mysql://localhost:3306/Test";
			con=DriverManager.getConnection(uri,"root","root");
			String deleteCondition="DELETE FROM Test.cart WHERE id='"+id+"' and num="+num+" and owner='"+owner+"'";
			sql=con.createStatement();
			int m=sql.executeUpdate(deleteCondition);
//			if(m!=0){
//				Success=true;
//				backnews="删除成功！";
//			}
//			else{
//				Success=false;
//				backnews="删除失败！";
//			}
		
		}
		catch(SQLException exp){
			exp.getMessage();
		}
//		request.serAttribute("showPage", 1);
		RequestDispatcher dispatcher=request.getRequestDispatcher("showcart?showPage=1");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
