package JavaBean;

import com.sun.rowset.CachedRowSetImpl;

public class Order {
	String owner;
	CachedRowSetImpl reSet = null;
	StringBuffer allPageResult;
	
	public void setOwner(String owner){
		this.owner=owner;
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public void setRowSet(CachedRowSetImpl set){
		this.reSet=set;
	}
	
	public CachedRowSetImpl getRowSet(){
		return this.reSet;
	}
	
	public void setAllPageResult(StringBuffer p2){
		this.allPageResult=p2;
	}
	
	public StringBuffer getAllPageResult(){
		return this.allPageResult;
	}
	

}
