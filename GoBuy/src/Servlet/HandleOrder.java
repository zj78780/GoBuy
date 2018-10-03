package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.*;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/HandleOrder")
public class HandleOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleOrder() {
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

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String ordernumber=request.getParameter("orderNumber");
		String owner;
		
		
		HttpSession session=request.getSession(true);
		Login loginBean=null;
		loginBean=(Login)session.getAttribute("login");
		owner=loginBean.getLogname();
//		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(time.format(new Date()));
		
		 Date date = new Date();//获得系统时间.
         String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
//       Timestamp time = Timestamp.valueOf(nowTime);//把时间转换
		
		
//		boolean Success=false;
		try{

			Connection con;
			Statement sql;

			String uri="jdbc:mysql://localhost:3306/Test";
			con=DriverManager.getConnection(uri,"root","root");
//			String insertCondition="insert into Test.cart values('"+id+"','"+name+"',"+price+",'"+pic+"',"+num+",'"+owner+"')";
			String insertCondition="insert into Test.order values('"+ordernumber+"','"+owner+"','"+nowTime+"')";
			System.out.println(insertCondition);
			sql=con.createStatement();
			int m=sql.executeUpdate(insertCondition);
//			if(m!=0){
//				Success=true;
//			}
//			else{
//				Success=false;
//			}
			RequestDispatcher dispatcher=request.getRequestDispatcher("user.jsp");
			dispatcher.forward(request, response);
		
		}
		catch(SQLException exp){
			exp.getMessage();
		}

				

		
		
		
		
		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json; charset=utf-8");
		
	}

}
