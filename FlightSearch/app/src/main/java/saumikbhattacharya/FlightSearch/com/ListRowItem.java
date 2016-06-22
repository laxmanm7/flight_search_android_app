package saumikbhattacharya.FlightSearch.com;

import java.io.Serializable;

public class ListRowItem implements Serializable{
    String carrier,number,arrival,departure,origin,destination,saletotal,arrivaldate,departuredate,totalbasefare,totalsalefare,totaltax,currentdate,adult,infant;

    public String getCarrier(){
        return carrier;
    }

    public String getNumber(){
        return number;
    }

    public String getArrival(){
        return arrival;
    }

    public String getDeparture(){
        return departure;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public String getSaletotal(){
        return saletotal;
    }

    public String getArrivalDate(){
        return arrivaldate;
    }

    public String getDepartureDate(){
        return departuredate;
    }

    public String getCurrentdate(){
        return currentdate;
    }

    public String getBaseFare(){
        return totalbasefare;
    }

    public String getSaleFare(){
        return totalsalefare;
    }

    public String getTotalTax(){
        return totaltax;
    }

    public String getAdult(){
        return adult;
    }

    public String getInfant(){
        return infant;
    }

    public void setCarrier(String ba_carrier){
        carrier = ba_carrier;
    }

    public void setNumber(String ba_number){
        number = ba_number;
    }

    public void setArrival(String ba_arrival){
        arrival = ba_arrival;
    }

    public void setDeparture(String ba_departure){
        departure = ba_departure;
    }

    public void setOrigin(String ba_origin){
        origin = ba_origin;
    }

    public void setDestination(String ba_dest){
        destination = ba_dest;
    }

    public void setSaletotal(String ba_saletotal){
        saletotal = ba_saletotal;
    }

    public void setArrivalDate (String ba_arrivaldate){
        arrivaldate = ba_arrivaldate;
    }

    public void setDepartureDate (String ba_departuredate){
        departuredate = ba_departuredate;
    }

    public void setBaseFare (String ba_totalbasefare){
        totalbasefare = ba_totalbasefare;
    }

    public void setSaleFare (String ba_salefare){
        totalsalefare = ba_salefare;
    }

    public void setTotalTax (String ba_totaltax){
        totaltax = ba_totaltax;
    }

    public void setCurrentDate (String ba_currentdate){
        currentdate = ba_currentdate;
    }

    public void setAdult (String ba_adult){
        adult = ba_adult;
    }

    public void setInfant (String ba_infant){
        infant = ba_infant;
    }
}
