package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;


public class Itinerary implements Serializable{
	private static final long serialVersionUID = -4350737423329995402L;
	private String carrier;
   	private boolean refundable;
   	private GroupOfFlights dept;
   	private GroupOfFlights ret;
 	public String getCarrier(){
		return this.carrier;
	}
	public void setCarrier(String carrier){
		this.carrier = carrier;
	}
 	public boolean getRefundable(){
		return this.refundable;
	}
	public void setRefundable(boolean refundable){
		this.refundable = refundable;
	}
	public GroupOfFlights getDept() {
		return dept;
	}
	public GroupOfFlights getRet() {
		return ret;
	}
	public void setDept(GroupOfFlights dept) {
		this.dept = dept;
	}
	public void setRet(GroupOfFlights ret) {
		this.ret = ret;
	}
}
