package com.sokhen.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//this class : stock and his details
public class Stock {
	
 	public final static int BUY = 0;
 	public final static int SELL = 1;
 	public final static int REMOVE = 2;
 	public final static int HOLD = 3;
	
	private String symbol ;
	private float ask, bid ;
	private Date date ;
	private int recommendation = 0;
	private int stockQuantity = 0;
	
	//ctor
	public Stock (String symbol, float ask, float bid, Date date, int recommendation, int stockQuantity){
			this.symbol = symbol ;
			this.ask = ask ;
			this.bid = bid ;
			this.date = date ;
			this.recommendation = recommendation ;
			this.stockQuantity = stockQuantity ;
	}
	
	//copy-ctor
	public Stock (Stock stock){
		this.symbol = stock.getSymbol() ;
		this.ask = stock.getAsk() ;
		this.bid = stock.getBid() ;
		this.date = stock.getDate() ;
		this.recommendation = stock.getRecommendation() ;
		this.stockQuantity = stock.getStockQuantity() ;
	}
	
	//getters and setters
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
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
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public int getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
	
	//returning string with stock details
	public String getHtmlDescription () {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy") ;
		String dateStr = new String() ;
		dateStr = dateFormat.format( getDate() );
		
		String resultStr = new String ("<b>Stock symbol</b>: " +getSymbol()+ " <b>Bid</b>: " +getBid()+ " <b>Ask</b>: " +getAsk()+ "<b>Date</b>: " +dateStr+ "<br>") ;
		return resultStr ;
	}
}
