package JavaBean;

public class Login {
	String logname;
	String password;
	String email;
	String address;
	boolean success=false;
	
	public void setLogname(String Logname){
		this.logname=Logname;
	}
	
	public String getLogname(){
		return this.logname;
	}
	
	public void setPassword(String Password){
		this.password=Password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setEmail(String Email){
		this.email=Email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setSuccess(boolean b){
		this.success=b;
	}
	
	public boolean getSuccess(){
		return this.success;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getAddress(){
		return this.address;
	}

}
