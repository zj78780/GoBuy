package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import com.sun.rowset.*;

import JavaBean.*;

/**
 * Servlet implementation class ShowItemList_class2
 */
@WebServlet("/ShowItemList_class2")
public class ShowItemList_class2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowItemList_class2() {
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
		ItemList showBean =null;
		try{
			showBean=(ItemList)session.getAttribute("show_2");
			if(showBean==null){
				showBean = new ItemList();
				session.setAttribute("show_2", showBean);
			}
		}
		catch(Exception exp){
			showBean=new ItemList();
			session.setAttribute("show_2", showBean);
		}
		showBean.setPageSize(5);
		String s=request.getParameter("class");
//		System.out.println("(before)class: "+s+"\n");
		
		s=new String(s.getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println("(after)class: "+s+"\n");
		showBean.setPclass(s);//class是否取出来？
		
//		System.out.println("class: "+showBean.getPclass()+"\n");//
		
		int showPage=1;
		if(showPage>showBean.getPageAllCount()){
			showPage=1;
		}
		if(showPage<=0){
			showPage=showBean.getPageAllCount();
		}
		showBean.setShowPage(showPage);
		int pageSize=showBean.getPageSize();
		String uri = "jdbc:mysql://localhost:3306/Test"; 
		try{
			con=DriverManager.getConnection(uri, "root", "root");
			Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query="select * from Test.item where class2='"+showBean.getPclass()+"'";
			ResultSet rs=sql.executeQuery(query);
			CachedRowSetImpl rowSet = new CachedRowSetImpl();
			rowSet.populate(rs);
			con.close();
			showBean.setRowSet(rowSet);
			rowSet.last();
			int m=rowSet.getRow();
			int n=pageSize;
			int pageAllCount=((m%n)==0?(m/n):(m/n)+1);
			showBean.setPageAllCount(pageAllCount);
			presentPageResult= show(showPage,pageSize,rowSet);
			showBean.setPresentPageResult(presentPageResult);
			
			
		}
		catch(SQLException exp){
			exp.getMessage();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("itemlist_class2.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
	public StringBuffer show(int page,int pageSize,CachedRowSetImpl rowSet){
		StringBuffer str=new StringBuffer();
		try{
			rowSet.absolute((page-1)*pageSize+1);
			String pic="";
			String pic_sub="";
			for(int i=1;i<=pageSize;i++){
				pic=rowSet.getString(4);
				pic_sub=pic.substring(0, pic.length()-4);
				String s="<a href=showitem?Pic="+pic_sub+"><img src = pic_item/"+rowSet.getString(4)+"  width =100 height =100/></a>";
				//System.out.println(rowSet.getString(4)+"\n");
				str.append("<tr>");
				str.append("<td>"+s+"</td>");
				str.append("<td><center>"+rowSet.getString(1)+"</center></td>");
				str.append("<td><center>"+rowSet.getString(2)+"</center></td>");
				str.append("<td><center>￥"+rowSet.getString(3)+"</center></td>");
				str.append("</tr>");
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
		ItemList showBean =null;
		try{
			showBean=(ItemList)session.getAttribute("show_2");
			if(showBean==null){
				showBean = new ItemList();
				session.setAttribute("show_2", showBean);
			}
		}
		catch(Exception exp){
			showBean=new ItemList();
			session.setAttribute("show_2", showBean);
		}
		showBean.setPageSize(5);
//		String s=request.getParameter("class");
//		System.out.println("(before)class: "+s+"\n");
		
//		s=new String(s.getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println("(after)class: "+s+"\n");
//		showBean.setPclass(s);//class是否取出来？
		
//		System.out.println("class: "+showBean.getPclass()+"\n");//
		int showPage=Integer.parseInt(request.getParameter("showPage"));
		if(showPage>showBean.getPageAllCount()){
			showPage=1;
		}
		if(showPage<=0){
			showPage=showBean.getPageAllCount();
		}
		showBean.setShowPage(showPage);
		int pageSize=showBean.getPageSize();
		String uri = "jdbc:mysql://localhost:3306/Test"; 
		try{
			con=DriverManager.getConnection(uri, "root", "root");
			Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query="select * from Test.item where class2='"+showBean.getPclass()+"'";
			ResultSet rs=sql.executeQuery(query);
			CachedRowSetImpl rowSet = new CachedRowSetImpl();
			rowSet.populate(rs);
			con.close();
			showBean.setRowSet(rowSet);
			rowSet.last();
			int m=rowSet.getRow();
			int n=pageSize;
			int pageAllCount=((m%n)==0?(m/n):(m/n)+1);
			showBean.setPageAllCount(pageAllCount);
			presentPageResult= show(showPage,pageSize,rowSet);
			showBean.setPresentPageResult(presentPageResult);
			
			
		}
		catch(SQLException exp){
			exp.getMessage();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("itemlist_class2.jsp");
		dispatcher.forward(request, response);
		
	}

}
