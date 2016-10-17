package saumikbhattacharya.FlightSearch.com.FlightPackage;

/**
 * Class representing the Prices details from the recommendations broken, its the element of recommendtaion
 * @since 0.37.0
 * @author Laxman Manandhar
 * */
import java.io.Serializable;
import java.math.BigDecimal;

public class PaxFareDetails implements Serializable{
	private static final long serialVersionUID = 3079256387690559824L;
	BigDecimal actualCommission;
	BigDecimal appliedCommission;
	BigDecimal b2bmargin;  
	BigDecimal b2cmargin;   
	BigDecimal apiReturnedFare;
	BigDecimal costPriceActual;     
	BigDecimal costPriceForAgent;
	BigDecimal sellingPriceUniform;
	BigDecimal quotedPrice; //payable price.
	BigDecimal totalTaxAmount;
    boolean refundable;
    int paxType;
    
	public BigDecimal getB2bmargin() {
		return b2bmargin;
	}
	public void setB2bmargin(BigDecimal b2bmargin) {
		this.b2bmargin = b2bmargin;
	}
	public BigDecimal getB2cmargin() {
		return b2cmargin;
	}
	public void setB2cmargin(BigDecimal b2cmargin) {
		this.b2cmargin = b2cmargin;
	}
	public BigDecimal getActualCommission() {
		return actualCommission;
	}
	public void setActualCommission(BigDecimal actualCommission) {
		this.actualCommission = actualCommission;
	}
	public BigDecimal getAppliedCommission() {
		return appliedCommission;
	}
	public void setAppliedCommission(BigDecimal appliedCommission) {
		this.appliedCommission = appliedCommission;
	}
	
	public boolean isRefundable() {
		return refundable;
	}
	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}
	
	public BigDecimal getTotalTaxAmount() {
		return totalTaxAmount;
	}
	public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}
	public BigDecimal getApiReturnedFare() {
		return apiReturnedFare;
	}
	public void setApiReturnedFare(BigDecimal apiReturnedFare) {
		this.apiReturnedFare = apiReturnedFare;
	}
	public BigDecimal getCostPriceActual() {
		return costPriceActual;
	}
	public void setCostPriceActual(BigDecimal costPriceActual) {
		this.costPriceActual = costPriceActual;
	}
	public BigDecimal getCostPriceForAgent() {
		return costPriceForAgent;
	}
	public void setCostPriceForAgent(BigDecimal costPriceForAgent) {
		this.costPriceForAgent = costPriceForAgent;
	}
	public BigDecimal getSellingPriceUniform() {
		return sellingPriceUniform;
	}
	public void setSellingPriceUniform(BigDecimal sellingPriceUniform) {
		this.sellingPriceUniform = sellingPriceUniform;
	}
	public BigDecimal getQuotedPrice() {
		return quotedPrice;
	}
	public void setQuotedPrice(BigDecimal quotedPrice) {
		this.quotedPrice = quotedPrice;
	}
	public int getPaxType() {
		return paxType;
	}
	public void setPaxType(int paxType) {
		this.paxType = paxType;
	}
	
}
