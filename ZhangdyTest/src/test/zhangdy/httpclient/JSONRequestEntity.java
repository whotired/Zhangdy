package test.zhangdy.httpclient;

public class JSONRequestEntity {

	private String  brand = "SWG";
	private String  clientName= "0041174";
	private String  country= "United States";
	private String  currency= "USD";
	private String  engagementOption= "BID";
	private String  offering= "Standard";
	private String  oppDescr= "New ShopZ order";
	private String  oppOwner= "marco_amg@us.ibm.com";
	private String  oppOwnerNotesId= "Marco A Marquez gomez/Raleigh/IBM";
	private String  rqcomments= "Order U01701626 from ShopzSeries.";
	private String  rqduedate= "2015-05-09 14:00:00 UTC";
	private String  rqtype= "Configuration or Quote Request / Processing";
	private String  rquser= "marco_amg@us.ibm.com";
	private String  sector= "None";
	private String  subBrand= "ESW";
	private String  tcvBillAmount= "0.00";
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getEngagementOption() {
		return engagementOption;
	}
	public void setEngagementOption(String engagementOption) {
		this.engagementOption = engagementOption;
	}
	public String getOffering() {
		return offering;
	}
	public void setOffering(String offering) {
		this.offering = offering;
	}
	public String getOppDescr() {
		return oppDescr;
	}
	public void setOppDescr(String oppDescr) {
		this.oppDescr = oppDescr;
	}
	public String getOppOwner() {
		return oppOwner;
	}
	public void setOppOwner(String oppOwner) {
		this.oppOwner = oppOwner;
	}
	public String getOppOwnerNotesId() {
		return oppOwnerNotesId;
	}
	public void setOppOwnerNotesId(String oppOwnerNotesId) {
		this.oppOwnerNotesId = oppOwnerNotesId;
	}
	public String getRqcomments() {
		return rqcomments;
	}
	public void setRqcomments(String rqcomments) {
		this.rqcomments = rqcomments;
	}
	public String getRqduedate() {
		return rqduedate;
	}
	public void setRqduedate(String rqduedate) {
		this.rqduedate = rqduedate;
	}
	public String getRqtype() {
		return rqtype;
	}
	public void setRqtype(String rqtype) {
		this.rqtype = rqtype;
	}
	public String getRquser() {
		return rquser;
	}
	public void setRquser(String rquser) {
		this.rquser = rquser;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getSubBrand() {
		return subBrand;
	}
	public void setSubBrand(String subBrand) {
		this.subBrand = subBrand;
	}
	public String getTcvBillAmount() {
		return tcvBillAmount;
	}
	public void setTcvBillAmount(String tcvBillAmount) {
		this.tcvBillAmount = tcvBillAmount;
	}
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append("{");
		 s.append("\"brand\"").append(":\"").append(brand).append("\",");
		 s.append("\"clientName\"").append(":\"").append(clientName).append("\",");
		 s.append("\"country\"").append(":\"").append(country).append("\",");
		 s.append("\"currency\"").append(":\"").append(currency).append("\",");
		 s.append("\"engagementOption\"").append(":\"").append(engagementOption).append("\",");
		 s.append("\"offering\"").append(":\"").append(offering).append("\",");
		 s.append("\"oppDescr\"").append(":\"").append(oppDescr).append("\",");
		 s.append("\"oppOwner\"").append(":\"").append(oppOwner).append("\",");
		 s.append("\"oppOwnerNotesId\"").append(":\"").append(oppOwnerNotesId).append("\",");
		 s.append("\"rqcomments\"").append(":\"").append(rqcomments).append("\",");
		 s.append("\"rqduedate\"").append(":\"").append(rqduedate).append("\",");
		 s.append("\"rqtype\"").append(":\"").append(rqtype).append("\",");
		 s.append("\"rquser\"").append(":\"").append(rquser).append("\",");
		 s.append("\"sector\"").append(":\"").append(sector).append("\",");
		 s.append("\"subBrand\"").append(":\"").append(subBrand).append("\",");
		 s.append("\"tcvBillAmount\"").append(":\"").append(tcvBillAmount).append("\"");
		s.append("}");
		return s.toString();
	}
}
