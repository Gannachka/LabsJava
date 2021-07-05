package jspclass;
 
import java.io.*; 
import javax.servlet.*; 

public class CBean {  
	
	protected String Value1;
	protected String Value2;
	protected String Value3;
	
	public CBean( String val1, String val2, String val3){   
		this.Value1 = val1;  
		this.Value2 = val2;
		this.Value3 = val3;
	}  
	public void SetValue1(String val1){
		this.Value1 = val1;
	}
	public void SetValue2(String val2){
		this.Value2 = val2;
	}
	public void SetValue3(String val3){
		this.Value3 = val3;
	}
	public String GetValue1(){
		return this.Value1;
	}
	public String GetValue2(){
		return this.Value2;
	}
	public String GetValue3(){
		return this.Value3;
	}
} 