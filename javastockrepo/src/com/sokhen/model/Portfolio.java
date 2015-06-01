package com.sokhen.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

//this class : portfolio of stocks
public class Portfolio implements PortfolioInterface {
	
 	public enum ALGO_RECOMMENDATION {
 		BUY, SELL, REMOVE , HOLD 
 	}
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private StockInterface[] stocks;
	private int portfolioSize ;
	private float balance ;
	
	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}
	
	public StockInterface[] getStocks() {
		return (StockInterface[]) stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public void setPortfolioSize (int size) {
		this.portfolioSize = size;
	}	
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	//empty ctor
	public Portfolio () {
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.title = new String("Temporary Title");
		this.balance = 0;
	}
	
	//copy-ctor
	public Portfolio (StockInterface[] arr) {
		this.title = new String("Temporary Title") ;
		this.portfolioSize = arr.length;
		for (int i=0 ; i<portfolioSize ; i++ ){
			this.stocks[i] = new Stock((Stock)arr[i]);
		}
		this.balance = 0 ;
	}

	//ctor
	public Portfolio (String title) {
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.title = title ;
		this.balance = 0;
	}	
	//updating the balance with the amount
	public void updateBalance (float amount) {
		this.balance += amount ;
		if (this.balance < 0) {
			System.out.println("Balance is negative!");
		}
	}
	
	//copy-ctor
 	public Portfolio(Portfolio portfolio) {
 		this(portfolio.getTitle());
 		this.portfolioSize = portfolio.getPortfolioSize();
 		this.updateBalance(portfolio.getBalance()); 
 		
 		for (int i=0; i<portfolioSize; i++){
 			this.stocks[i] = new Stock((Stock) portfolio.getStocks()[i]);
 			}
 		}
 	
	//adding stock to the array
	public void addStock (Stock stock){
		if (stock == null) {
			System.out.println("Stock is null!");
			return ;
		}
		
		else if (portfolioSize == MAX_PORTFOLIO_SIZE) {
			System.out.println("Portfolio is full!");
			return ;
		}
		
		for (int i = 0 ; i < this.portfolioSize ; i ++) {
			if (stock.getSymbol().equals(stocks[i].getSymbol())) {
				System.out.println("Stock already exists!");
				return ;
			}
		}
		
		//if i got here - means: stock is not null, porfolio not full, stock is not exist already in portfolio
		stocks[portfolioSize] = stock ;
		portfolioSize ++ ;
		
		
		if (portfolioSize == MAX_PORTFOLIO_SIZE) {
			System.out.println("Stock added but portfolio is now full!");
		}
	}
	
	//returning string with details of all the stocks
	public String getHtmlString () {
		String str = new String ("<h1>Portfolio title: " + title + "</h1> <br>") ;
		for (int i=0 ; i<portfolioSize ; i++) {
			str = str + ((Stock) this.stocks[i]).getHtmlDescription() + "<br>" ;
		}
		str += "<b>Total Portfolio value:</b> " +getTotalValue() + "$, " ;
		str += "<b>Total Stocks value:</b> " +getStocksValue() + "$, " ;
		str += "<b>Balance:</b> " +getBalance() + "$." ;
		return str;
	}
	
	
	//removing stock from array
	public boolean removeStock (String symbol){
		boolean bool = false ;
		
		if (symbol == null) {
			System.out.println("Stock is null!");
			return bool ;
		}
		
		for (int i = 0 ; i < portfolioSize ; i++ ) {
			if ( this.stocks[i].getSymbol().equals(symbol)) {
				
				this.sellStock (this.stocks[i].getSymbol(), -1) ;
				if (i != 0 && i != portfolioSize -1 ) {
					this.stocks[i] = new Stock ((Stock) this.stocks [portfolioSize-1]) ;
				}
				bool = true ;
				this.portfolioSize -- ;
			}
		}
		
		if (bool == false) {
			System.out.println("Cannot find the stock!") ;
		}
		
		else {
			System.out.println("Stock was removed!") ;
		}
		 return bool ;
	}
	
	//selling some/all holdings in stock
	public boolean sellStock(String symbol , int quantity) {
		if (quantity < -1 ) {
			System.out.println("Invalid quantity!") ;
			return false ;
		}
		if (symbol == null) {
			System.out.println("Stock is null!") ;
			return false ;
		}
		
		for (int i = 0 ; i < this.portfolioSize ; i ++) {
			if (symbol.equals(this.stocks[i].getSymbol())) {
				if (((Stock) this.stocks[i]).getStockQuantity() < quantity) {
					System.out.println("Not enough stocks to sell!") ;
					return false ;
				}
				
				if (quantity == -1) {
					balance += ((Stock) this.stocks[i]).getStockQuantity() * this.stocks[i].getBid() ;
					((Stock) this.stocks[i]).setStockQuantity(0) ;
					System.out.println("The stock is sold!") ;
					return true ;
				}
				
				//if i got here means the user want to sell valid num of stocks
				balance += quantity * this.stocks[i].getBid() ;
				((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity() - quantity) ;
				System.out.println(+quantity+ "The holdings are sold!") ;
				return true ;
			}
		}
		System.out.println("Stock not found!") ;
		return false;
	}
	
	//buying some/all holdings in stock
	public boolean buyStock(Stock stock , int quantity) {
		if (quantity < -1 ) {
			System.out.println("Invalid quantity!") ;
			return false ;
		}
		if (stock == null) {
			System.out.println("Stock is null!") ;
			return false ;
		}			
		if (stock.getAsk() * quantity > balance) {
			System.out.println("“Not enough balance to complete purchase!") ;
			return false ;
		}
		
		int i ;
		for (i = 0 ; i < portfolioSize ; i ++) {
			if (stock.getSymbol().equals(this.stocks[i].getSymbol())) {
				if (quantity == -1) {
					int temp = (int)balance / (int)this.stocks[i].getAsk() ;
					balance -= temp * this.stocks[i].getAsk() ;
					((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity() + temp) ;
					System.out.println("You purchased the stock!") ;
					return true ;
				}
				else {
			        balance -= quantity * this.stocks[i].getAsk() ;
				    ((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity() + quantity) ;
			     	System.out.println("You purchased" +quantity+ "holdings!") ;
			        return true ;
				}
			}	
		}
		
		if (i == MAX_PORTFOLIO_SIZE - 1) {
			System.out.println("Stock not exists int the portfolio, and portfolio is full!") ;
			return false ;
		}
		if (quantity == -1) {
			addStock(stock) ;
 			int temp = (int)balance / (int)this.stocks[i].getAsk() ;
			balance -= temp * this.stocks[i].getAsk() ;
			((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity() + temp) ;
			System.out.println("You purchased the stock!") ;
			return true ;
		}
		else {
			addStock(stock) ;
	        balance -= quantity * this.stocks[i].getAsk() ;
		    ((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity() + quantity) ;
	     	System.out.println("You purchased" +quantity+ "holdings!") ;
	        return true ;
		}		
	}

	//getting the value of the stocks
	public float getStocksValue() {
		float res = 0 ;
		for (int i = 0 ; i < this.portfolioSize ; i ++) {
			res += this.stocks[i].getBid() * ((Stock) this.stocks[i]).getStockQuantity() ;
		}
		return res ;
	}
	
	//getting the total value
	public float getTotalValue() {
		return this.getStocksValue() + getBalance() ;
	}
	
	//finding a stock and returning its place or -1 if not found
	public int findStock (String stockToFind) {
 		for (int i = 0 ; i < this.portfolioSize ; i++) {
 			if (stockToFind.equals (this.stocks[i].getSymbol() )) {
 				return i ;
 			}
 		}
 		return -1 ;
 	}
	//finding the place of a stock
 	public StockInterface findStockPlace (String stockToFind) {
 		int i = 0 ;
 		for (i = 0 ; i < this.portfolioSize ; i++) {
 			if (stockToFind.equals (this.stocks[i].getSymbol() )) {
 				return this.stocks[i] ;
 			}
 		}
 		return null ;
 	}
}
