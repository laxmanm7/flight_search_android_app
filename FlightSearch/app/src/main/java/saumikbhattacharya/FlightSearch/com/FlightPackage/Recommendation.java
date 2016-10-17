package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;

public class Recommendation implements Serializable{
	private static final long serialVersionUID = 5552497767064869237L;
	private int seq;
   	private String provider;
   	private Itinerary itinerary;
   	private Fare fare;
   	private Extras extras;
   	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	public Extras getExtras() {
		return extras;
	}
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
}
