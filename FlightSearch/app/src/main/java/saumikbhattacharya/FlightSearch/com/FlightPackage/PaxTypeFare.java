package saumikbhattacharya.FlightSearch.com.FlightPackage;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaxTypeFare implements Serializable{
	private static final long serialVersionUID = -487606371337605996L;
	private BigDecimal apif;
   	private BigDecimal cp;
   	private BigDecimal cpa;
   	private BigDecimal spu;
   	private BigDecimal tx;
   	private boolean rf;

 	public BigDecimal getApif(){
		return this.apif;
	}
	public void setApif(BigDecimal apif){
		this.apif = apif;
	}
 	public BigDecimal getCp(){
		return this.cp;
	}
	public void setCp(BigDecimal cp){
		this.cp = cp;
	}
 	public BigDecimal getCpa(){
		return this.cpa;
	}
	public void setCpa(BigDecimal cpa){
		this.cpa = cpa;
	}
 	public boolean getRf(){
		return this.rf;
	}
	public void setRf(boolean rf){
		this.rf = rf;
	}
 	public BigDecimal getSpu(){
		return this.spu;
	}
	public void setSpu(BigDecimal spu){
		this.spu = spu;
	}
 	public BigDecimal getTx(){
		return this.tx;
	}
	public void setTx(BigDecimal tx){
		this.tx = tx;
	}
}
