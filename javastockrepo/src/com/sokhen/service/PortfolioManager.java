package com.sokhen.service;

import java.util.Calendar;
import java.util.Date;

import com.sokhen.model.Portfolio; 
import com.sokhen.model.Stock;

//this class : managing portfolio and his stocks
public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		Portfolio myPortfolio= new Portfolio("Exercise 7 Portfolio");
		myPortfolio.updateBalance(10000f);
		
		Calendar cal = Calendar.getInstance() ;
		cal.set (2014, 12, 15) ;
			
		Date date1 = cal.getTime() ;
		Date date2 = cal.getTime() ;
		Date date3 = cal.getTime() ;		
		
		Stock stock1 = new Stock ( "PIH", 10.0f, 8.5f, date1) ;
		myPortfolio.buyStock(stock1 , 20);
		
		Stock stock2 = new Stock ( "AAL", 30.0f, 25.5f, date2) ;
		myPortfolio.buyStock(stock2 , 30);
		
		Stock stock3 = new Stock ( "CAAS", 20.0f, 15.5f, date3) ;
		myPortfolio.buyStock(stock3 , 40);
		
		myPortfolio.sellStock("AAL" , -1) ;
		myPortfolio.removeStock("CAAS") ;
		
		return myPortfolio ;
	}

}
