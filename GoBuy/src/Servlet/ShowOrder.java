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
@WebServlet("/ShowOrder")
public class ShowOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrder() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
				
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
		
		String pay = request.getParameter("pay").trim();
		String ordernumber="";
		
		HttpSession session=request.getSession(true);
		request.setAttribute("pay",pay);
		
		Connection con = null;
		StringBuffer presentPageResult =new StringBuffer();
		StringBuffer allPageResult=new StringBuffer();
		int sumMoney=0;
		Cart cartBean =null;
		Login loginBean=null;
		loginBean=(Login)session.getAttribute("login");
		String owner=loginBean.getLogname();
		int k;
		for(int i=0;i<=6;i++){
			k=(int)(Math.random()*10);
			ordernumber=ordernumber+k;
		}
		ordernumber=ordernumber+"/"+loginBean.getLogname();
		request.setAttribute("ordernumber",ordernumber);
		
		
		
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
			sumMoney=getSum(showPage,rowSet);
//			System.out.println("sumMoney:"+sumMoney);
			cartBean.setSumMoney(sumMoney);
			allPageResult=showAll(showPage,rowSet);
			cartBean.setAllPageResult(allPageResult);
		}
		catch(SQLException exp){
			exp.getMessage();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("order.jsp");
		dispatcher.forward(request, response);
	}
	
	public StringBuffer showAll(int page,CachedRowSetImpl rowSet){
		StringBuffer str=new StringBuffer();
		int pageSize=20;
		try{
			rowSet.absolute((page-1)*pageSize+1);
			int num=0;
			int price=0;
			do{
				num=Integer.parseInt(rowSet.getString(5));
				price=Integer.parseInt(rowSet.getString(3));
				String total=String.valueOf(num*price);
				str.append("<tr>");
				str.append("<td><center>"+rowSet.getString(1)+"</center></td>");
				str.append("<td><center>"+rowSet.getString(2)+"</center></td>");
				str.append("<td><center>￥"+rowSet.getString(3)+"</center></td>");
				str.append("<td><center>"+rowSet.getString(5)+"</center></td>");
				str.append("<td><center>￥"+total+"</center></td>");
				str.append("<tr>");	
			}while(rowSet.next());
			return str;
			
		}
		catch(SQLException exp){
			return str;
		}
	}
	
	public int getSum(int page,CachedRowSetImpl rowSet){
		int pageSize=20;
		int sum=0;
		try{
			rowSet.absolute((page-1)*pageSize+1);
			int num=0;
			int price=0;			
			do{
				num=Integer.parseInt(rowSet.getString(5));
				price=Integer.parseInt(rowSet.getString(3));
				sum=sum+num*price;					
//				System.out.println("sum- : "+sum);
			}while(rowSet.next());
//			System.out.println("Sum-final:"+sum);
			return sum;			
		}
		catch(SQLException exp){
			return sum;
		}
	}

}
