package JavaBean;

import com.sun.rowset.CachedRowSetImpl;

public class Cart {
	String owner = null;
	CachedRowSetImpl reSet = null;
	int pageSize = 10;
	int pageAllCount = 0;
	int showPage = 1;
	int sumMoney=0;
	StringBuffer presentPageResult;
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
	
	public void setPageSize(int size){
		this.pageSize=size;
	}
	
	public int getPageSize(){
		return this.pageSize;
	}
	
	public void setPageAllCount(int count){
		this.pageAllCount=count;
	}
	
	public int getPageAllCount(){
		return this.pageAllCount;
	}
	
	public void setShowPage(int n){
		this.showPage=n;
	}
	
	public int getShowPage(){
		return this.showPage;
	}
	
	public void setSumMoney(int sum){
		this.sumMoney=sum;
	}
	
	public int getSumMoney(){
		return this.sumMoney;
	}
	
	public void setPresentPageResult(StringBuffer p1){
		this.presentPageResult=p1;
	}
	
	public StringBuffer getPresentPageResult(){
		return this.presentPageResult;
	}
	
	public void setAllPageResult(StringBuffer p2){
		this.allPageResult=p2;
	}
	
	public StringBuffer getAllPageResult(){
		return this.allPageResult;
	}
}
