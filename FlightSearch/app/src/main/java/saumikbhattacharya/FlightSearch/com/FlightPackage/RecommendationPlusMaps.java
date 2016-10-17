package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.util.HashMap;
import java.util.List;

public class RecommendationPlusMaps {
	
	List<Recommendation> recommendationList;
	HashMap<String, String> airlineCodeToName;
	HashMap<String, String> cityCodeToName;
	FilterMaps filterMaps;
	Boolean makebooking;
	Boolean holdbooking;
	public List<Recommendation> getRecommendationList() {
		return recommendationList;
	}
	public void setRecommendationList(List<Recommendation> recommendationList) {
		this.recommendationList = recommendationList;
	}
	public Boolean isMakebooking() {
		return makebooking;
	}
	public void setMakebooking(Boolean makebooking) {
		this.makebooking = makebooking;
	}
	public Boolean isHoldbooking() {
		return holdbooking;
	}
	public void setHoldbooking(Boolean holdbooking) {
		this.holdbooking = holdbooking;
	}
	public HashMap<String, String> getAirlineCodeToName() {
		return airlineCodeToName;
	}
	public void setAirlineCodeToName(HashMap<String, String> airlineCodeToName) {
		this.airlineCodeToName = airlineCodeToName;
	}
	public HashMap<String, String> getCityCodeToName() {
		return cityCodeToName;
	}
	public void setCityCodeToName(HashMap<String, String> cityCodeToName) {
		this.cityCodeToName = cityCodeToName;
	}
	public FilterMaps getFilterMaps() {
		return filterMaps;
	}
	public void setFilterMaps(FilterMaps filterMaps) {
		this.filterMaps = filterMaps;
	}
	

}
