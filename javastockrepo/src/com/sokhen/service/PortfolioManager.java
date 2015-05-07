package com.sokhen.service;

import java.util.Calendar;
import java.util.Date;

import com.sokhen.model.Portfolio; 
import com.sokhen.model.Stock;

//this class : managing portfolio and his stocks
public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		Portfolio newPortfolio= new Portfolio("Portfolio #1");
		
		Calendar cal = Calendar.getInstance() ;
		cal.set (2014, 11, 15) ;
			
		Date date1 = cal.getTime() ;
		Date date2 = cal.getTime() ;
		Date date3 = cal.getTime() ;		
		
		Stock stock1 = new Stock ( "PIH", 13.1f, 12.4f, date1, 0, 0 ) ;
		newPortfolio.addStock(stock1);
		
		Stock stock2 = new Stock ( "AAL", 5.78f, 5.5f, date2, 0, 0 ) ;
		newPortfolio.addStock(stock2);
		
		Stock stock3 = new Stock ( "CAAS", 32.2f, 31.5f, date3, 0, 0 ) ;
		newPortfolio.addStock(stock3);
		
		return newPortfolio;
	}

}
