package com.sokhen;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stock {
	
	private String symbol ;
	private float ask, bid ;
	private Date date ;
	
	public Stock (String symbol, float ask, float bid, Date date){
			this.symbol = symbol ;
			this.ask = ask ;
			this.bid = bid ;
			this.date = date ;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHtmlDescription () {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy") ;
		String dateStr = new String() ;
		dateStr = dateFormat.format( getDate() );
		
		String resultStr = new String ("<b>Stock symbol</b>: " +getSymbol()+ " <b>Bid</b>: " +getBid()+ " <b>Ask</b>: " +getAsk()+ "<b>Date</b>: " +dateStr+ "<br>") ;
		return resultStr ;
	}
}
