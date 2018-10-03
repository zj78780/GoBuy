package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.sql.*;

import JavaBean.Item;

/**
 * Servlet implementation class ShowItem
 */
@WebServlet("/ShowItem")
public class ShowItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowItem() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String id;
	int price;
	String name;
	String pic;
	String class1;
	String class2;
	
	
	
	
	public static Connection getConnection() throws SQLException, java.lang.ClassNotFoundException 
	{ 
		//第一步：加载MySQL的JDBC的驱动 
        Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost:3306/Test"; 
		String username = "root"; 
		String password = "root"; 
		//System.out.println("!\n");

		//第二步：创建与MySQL数据库的连接类的实例 
		Connection con = DriverManager.getConnection(url, username, password); 
		return con; 
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
		
		try 
		{ 

			Connection con = getConnection(); 			
			Statement sql_statement = con.createStatement(); 			
			Item itembean=new Item();
			HttpSession session=request.getSession(true);
			session.setAttribute("itembean", itembean);
						
			String PIC=request.getParameter("Pic");
			itembean.setpic(PIC+".jpg");
			//System.out.println("PID:"+PID+"\n"+"itemBean.pic="+itemBean.getpic()+"\n");
			
			//System.out.println(itemBean.getpic()+" !\n");
			String query = "select * from Test.item where pic='"+itembean.getpic()+"'"; 
			//System.out.println(query+" !\n");
			ResultSet result = sql_statement.executeQuery(query);
			
			
			
			while (result.next()) 
			{ 
				id=result.getString("id"); 
				price=result.getInt("price");
				name=result.getString("name"); 
				class1=result.getString("class1"); 
				class2=result.getString("class2");
				pic=result.getString("pic");
				
				
				//System.out.println("从item表中获得的数据如下:"); 
				//System.out.println("------------------------"); 
				//System.out.println("id" + " | " + "name" + " | " + "price"+" | " +"pic"+" | " +"class1"+" | " +"class2"); 
				//System.out.println("------------------------");
				//System.out.println(" "+ id+ " | " + name + " | " + price+ " | "+pic+ " | "+class1+ " | "+class2+"\n"); 
			}
			
			itembean.setid(id);
			itembean.setname(name);
			itembean.setpic(pic);
			itembean.setprice(price);
			itembean.setclass1(class1);
			itembean.setclass2(class2);
			
//			System.out.println("从itemBean中获得的数据如下:"); 
//			System.out.println("------------------------"); 
//			System.out.println("id" + " | " + "name" + " | " + "price"+" | " +"pic"+" | " +"class1"+" | " +"class2"); 
//			System.out.println("------------------------");
//			System.out.println(" "+ itembean.getid()+ " | " +itembean.getname()+ " | " +itembean.getprice()+ " | "+itembean.getpic()+ " | "+itembean.getclass1()+ " | "+itembean.getclass2()); 
//			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("itemdetail.jsp");
			dispatcher.forward(request, response);


			//关闭连接和声明 
			sql_statement.close(); 
			con.close(); 

		} 
		catch(java.lang.ClassNotFoundException e) { 
			//加载JDBC错误,所要用的驱动没有找到 
			System.err.print("ClassNotFoundException"); 
			//其他错误 
			System.err.println(e.getMessage()); 
			} 
		catch(SQLException ex) { 
			//显示数据库连接错误或查询错误 
			System.err.println("SQLException: " + ex.getMessage()); 
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
