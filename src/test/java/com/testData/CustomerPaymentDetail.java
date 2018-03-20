package com.testData;

public class CustomerPaymentDetail {
	
	public String customerId;
	public String cardholdername;
	public String cardnumber;
	public String expirymonth;
	public String expiryyear;
	public String startmonth;
	public String startyear;
	public String issuenumber;
	public String cvvnumber;
	
	public CustomerPaymentDetail(String customerId,String cardholdername,String cardnumber,String expirymonth,String expiryyear,String startmonth,String startyear,String issuenumber,String cvvnumber)
	{
		this.customerId    = customerId;
		this.cardholdername= cardholdername;
		this.cardnumber    = cardnumber;
		this.expirymonth   = expirymonth;
		this.expiryyear    = expiryyear;
		this.startmonth    = startmonth;
		this.startyear     = startyear;
		this.issuenumber   = issuenumber;
		this.cvvnumber     = cvvnumber;
	}

}
