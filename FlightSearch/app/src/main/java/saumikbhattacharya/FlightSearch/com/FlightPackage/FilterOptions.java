package saumikbhattacharya.FlightSearch.com.FlightPackage;

public class FilterOptions {

	private String airline;
	private boolean refundable ;
	private boolean nonRefundable;
	private boolean stops;

	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}

	public boolean isRefundable() {
		return refundable;
	}
	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}
	public boolean isNonRefundable() {
		return nonRefundable;
	}
	public void setNonRefundable(boolean nonRefundable) {
		this.nonRefundable = nonRefundable;
	}
	public boolean isStops() {
		return stops;
	}
	public void setStops(boolean stops) {
		this.stops = stops;
	}
}
