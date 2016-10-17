package saumikbhattacharya.FlightSearch.com.FlightPackage;
import java.io.Serializable;
import java.math.BigDecimal;

public class Extras implements Serializable{
	private static final long serialVersionUID = -593296447468236875L;
	private BigDecimal acc;
   	private BigDecimal apc;
   	private BigDecimal b2bm;
   	private BigDecimal b2cm;

 	public BigDecimal getAcc(){
		return this.acc;
	}
	public void setAcc(BigDecimal acc){
		this.acc = acc;
	}
 	public BigDecimal getApc(){
		return this.apc;
	}
	public void setApc(BigDecimal apc){
		this.apc = apc;
	}
 	public BigDecimal getB2bm(){
		return this.b2bm;
	}
	public void setB2bm(BigDecimal b2bm){
		this.b2bm = b2bm;
	}
 	public BigDecimal getB2cm(){
		return this.b2cm;
	}
	public void setB2cm(BigDecimal b2cm){
		this.b2cm = b2cm;
	}
}
