package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;
import java.util.List;

public class GroupOfFlights implements Serializable{
	private static final long serialVersionUID = -5076809842372782372L;
	private List<FlightDetail> flightList;
	private int stops;
	private String duration;
	public List<FlightDetail> getFlightList() {
		return flightList;
	}
	public void setFlightList(List<FlightDetail> flightList) {
		this.flightList = flightList;
	}
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
