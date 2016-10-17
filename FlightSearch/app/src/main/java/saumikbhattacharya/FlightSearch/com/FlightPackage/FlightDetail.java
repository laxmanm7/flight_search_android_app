package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;

public class FlightDetail implements Serializable{
	private static final long serialVersionUID = 4600447396777928132L;
	private String cls;
   	private String eqp;
   	private String flag;
   	private String fltno;
   	private Location from;
   	private Location to;
   	private String seatAvl;

 	public String getCls(){
		return this.cls;
	}
	public void setCls(String cls){
		this.cls = cls;
	}
 	public String getEqp(){
		return this.eqp;
	}
	public void setEqp(String eqp){
		this.eqp = eqp;
	}
 	public String getFlag(){
		return this.flag;
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
 	public String getFltno(){
		return this.fltno;
	}
	public void setFltno(String fltno){
		this.fltno = fltno;
	}
 	public Location getFrom(){
		return this.from;
	}
	public void setFrom(Location from){
		this.from = from;
	}
 	public Location getTo(){
		return this.to;
	}
	public void setTo(Location to){
		this.to = to;
	}
	public String getSeatAvl() {
		return seatAvl;
	}
	public void setSeatAvl(String seatAvl) {
		this.seatAvl = seatAvl;
	}
}
