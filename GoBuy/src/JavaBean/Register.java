package JavaBean;

public class Register {
	String regname;
	String password;
	String email;
	
	public void setRegname(String name){
		this.regname=name;
	}
	
	public String getRegname(){
		return this.regname;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return this.email;
	}

}
