package JavaBean;

import com.sun.rowset.*;

public class ItemList {
	String pclass = null;
	CachedRowSetImpl reSet = null;
	int pageSize = 10;
	int pageAllCount = 0;
	int showPage = 1;
	StringBuffer presentPageResult;
	
	public void setPclass(String pclass){
		this.pclass=pclass;
	}
	
	public String getPclass(){
		return this.pclass;
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
	
	public void setPresentPageResult(StringBuffer p){
		this.presentPageResult=p;
	}
	
	public StringBuffer getPresentPageResult(){
		return this.presentPageResult;
	}

}
