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

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		int price=Integer.parseInt(request.getParameter("price"));
		String pic=request.getParameter("pic");
		int num=Integer.parseInt(request.getParameter("num"));
		String owner=request.getParameter("owner");
		
		//System.out.println(id+"|"+name+"|"+price+"|"+pic+"|"+num+"|"+owner);
		boolean Success=false;
		try{

			Connection con;
			Statement sql;

			String uri="jdbc:mysql://localhost:3306/Test";
			con=DriverManager.getConnection(uri,"root","root");
			String insertCondition="insert into Test.cart values('"+id+"','"+name+"',"+price+",'"+pic+"',"+num+",'"+owner+"')";
			sql=con.createStatement();
			int m=sql.executeUpdate(insertCondition);
			if(m!=0){
				Success=true;
			}
			else{
				Success=false;
			}
		
		}
		catch(SQLException exp){
			exp.getMessage();
		}
		if(Success==true){
			String jsonStr = "{\"message\":\"成功添加到购物车！\"}";
			PrintWriter out = null;
			try {
			    out = response.getWriter();
			    out.write(jsonStr);
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (out != null) {
			        out.close();
			    }
			}
		}
		else{
			String jsonStr = "{\"message\":\"添加到购物车失败！\"}";
			PrintWriter out = null;
			try {
			    out = response.getWriter();
			    out.write(jsonStr);
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (out != null) {
			        out.close();
			    }
			}
		}
		
		
		
		
		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json; charset=utf-8");
		
	}

}
