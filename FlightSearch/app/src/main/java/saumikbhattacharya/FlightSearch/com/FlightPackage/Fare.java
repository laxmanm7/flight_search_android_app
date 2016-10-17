package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;

public class Fare implements Serializable{
	private static final long serialVersionUID = -4307045377628271681L;
	private PaxTypeFare adultFare;
   	private PaxTypeFare childFare;
   	private PaxTypeFare infantFare;
   	
	public PaxTypeFare getAdultFare() {
		return adultFare;
	}
	public void setAdultFare(PaxTypeFare adultFare) {
		this.adultFare = adultFare;
	}
	public PaxTypeFare getChildFare() {
		return childFare;
	}
	public void setChildFare(PaxTypeFare childFare) {
		this.childFare = childFare;
	}
	public PaxTypeFare getInfantFare() {
		return infantFare;
	}
	public void setInfantFare(PaxTypeFare infantFare) {
		this.infantFare = infantFare;
	}
}
