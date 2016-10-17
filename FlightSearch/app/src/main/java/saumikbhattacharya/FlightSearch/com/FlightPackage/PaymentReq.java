package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;

public class PaymentReq implements Serializable{

	private static final long serialVersionUID = 3581778537815059336L;
	
	private int gatewayId;
	private double amount;
	public int getGatewayId() {
		return gatewayId;
	}
	public void setGatewayId(int gatewayId) {
		this.gatewayId = gatewayId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
