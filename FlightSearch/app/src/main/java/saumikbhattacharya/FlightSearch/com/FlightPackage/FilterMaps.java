package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class FilterMaps {
	HashMap<String, String> fare;
	HashMap<String, String> outDeptTime;
	HashMap<String, String> inDeptTime;
	
	HashMap<String, String> outArrTime;
	HashMap<String, String> inArrTime;
	
	HashMap<String, String> outDuration;
	HashMap<String, String> inDuration;
	
	TreeMap<String, BigDecimal> cheapest;
	TreeMap<String, String> fastest;
	List<String> inTransits;
	List<String> outTransits;
	public HashMap<String, String> getFare() {
		return fare;
	}
	public HashMap<String, String> getOutDeptTime() {
		return outDeptTime;
	}
	public HashMap<String, String> getInDeptTime() {
		return inDeptTime;
	}
	public HashMap<String, String> getOutArrTime() {
		return outArrTime;
	}
	public HashMap<String, String> getInArrTime() {
		return inArrTime;
	}
	public HashMap<String, String> getOutDuration() {
		return outDuration;
	}
	public HashMap<String, String> getInDuration() {
		return inDuration;
	}
	public TreeMap<String, BigDecimal> getCheapest() {
		return cheapest;
	}
	public TreeMap<String, String> getFastest() {
		return fastest;
	}
	public List<String> getInTransits() {
		return inTransits;
	}
	public List<String> getOutTransits() {
		return outTransits;
	}
	public void setFare(HashMap<String, String> fare) {
		this.fare = fare;
	}
	public void setOutDeptTime(HashMap<String, String> outDeptTime) {
		this.outDeptTime = outDeptTime;
	}
	public void setInDeptTime(HashMap<String, String> inDeptTime) {
		this.inDeptTime = inDeptTime;
	}
	public void setOutArrTime(HashMap<String, String> outArrTime) {
		this.outArrTime = outArrTime;
	}
	public void setInArrTime(HashMap<String, String> inArrTime) {
		this.inArrTime = inArrTime;
	}
	public void setOutDuration(HashMap<String, String> outDuration) {
		this.outDuration = outDuration;
	}
	public void setInDuration(HashMap<String, String> inDuration) {
		this.inDuration = inDuration;
	}
	public void setCheapest(TreeMap<String, BigDecimal> cheapest) {
		this.cheapest = cheapest;
	}
	public void setFastest(TreeMap<String, String> fastest) {
		this.fastest = fastest;
	}
	public void setInTransits(List<String> inTransits) {
		this.inTransits = inTransits;
	}
	public void setOutTransits(List<String> outTransits) {
		this.outTransits = outTransits;
	}
	
	
}
