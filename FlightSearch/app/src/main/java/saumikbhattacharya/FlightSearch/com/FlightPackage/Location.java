package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;

public class Location implements Serializable{
	private static final long serialVersionUID = 8746253797666933819L;
	private String date;
   	private String code;
   	private String terminal;
   	private String time;

 	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
 	public String getCode(){
		return this.code;
	}
	public void setCode(String code){
		this.code = code;
	}
 	public String getTerminal(){
		return this.terminal;
	}
	public void setTerminal(String terminal){
		this.terminal = terminal;
	}
 	public String getTime(){
		return this.time;
	}
	public void setTime(String time){
		this.time = time;
	}
}
