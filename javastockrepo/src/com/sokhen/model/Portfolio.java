package com.sokhen.model;

import com.sokhen.model.Stock.ALGO_RECOMMENDATION;

//this class : portfolio of stocks
public class Portfolio {
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize = 0;
	private float balance = 0 ;
	
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
	
	public Stock[] getStocks() {
		return stocks;
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
	
	//ctor
	public Portfolio (String title) {
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.title = title;
		this.balance = 0;
	}
	
	//copy-ctor
	public Portfolio (Portfolio portfolio) {
		this(portfolio.getTitle());
		this.setPortfolioSize (portfolio.getPortfolioSize());
		for (int i=0 ; i<portfolio.getPortfolioSize() ; i++ ){
			this.stocks[i] = new Stock(portfolio.getStocks()[i]);
		}
		this.balance = portfolio.balance ;
	}
	
	//updating the balance with the amount
	public void updateBalance (float amount) {
		this.balance += amount ;
		if (this.balance < 0) {
			System.out.println("Balance is negative!");
		}
	}

	//adding stock to the array
	public void addStock (Stock stock){
		if (stock == null) {
			System.out.println("Stock is null!");
			return ;
		}
		
		if (portfolioSize == MAX_PORTFOLIO_SIZE) {
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
			str = str + this.stocks[i].getHtmlDescription() + "<br>" ;
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
					this.stocks[i] = new Stock (this.stocks [portfolioSize-1]) ;
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
				if (this.stocks[i].getStockQuantity() < quantity) {
					System.out.println("Not enough stocks to sell!") ;
					return false ;
				}
				
				if (quantity == -1) {
					balance += this.stocks[i].getStockQuantity() * this.stocks[i].getBid() ;
					this.stocks[i].setStockQuantity(0) ;
					this.stocks[i].setRecommendation(ALGO_RECOMMENDATION.SELL) ;
					System.out.println("The stock is sold!") ;
					return true ;
				}
				
				//if i got here means the user want to sell valid num of stocks
				balance += quantity * this.stocks[i].getBid() ;
				this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() - quantity) ;
				this.stocks[i].setRecommendation(ALGO_RECOMMENDATION.SELL) ;
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
					this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() + temp) ;
					this.stocks[i].setRecommendation(ALGO_RECOMMENDATION.BUY) ;
					System.out.println("You purchased the stock!") ;
					return true ;
				}
				else {
			        balance -= quantity * this.stocks[i].getAsk() ;
				    this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() + quantity) ;
			     	this.stocks[i].setRecommendation(ALGO_RECOMMENDATION.BUY) ;					
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
			this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() + temp) ;
			this.stocks[i].setRecommendation(ALGO_RECOMMENDATION.BUY) ;
			System.out.println("You purchased the stock!") ;
			return true ;
		}
		else {
			addStock(stock) ;
	        balance -= quantity * this.stocks[i].getAsk() ;
		    this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() + quantity) ;
	     	this.stocks[i].setRecommendation(ALGO_RECOMMENDATION.BUY) ;					
	     	System.out.println("You purchased" +quantity+ "holdings!") ;
	        return true ;
		}		
	}

	//getting the value of the stocks
	public float getStocksValue() {
		float res = 0 ;
		for (int i = 0 ; i < this.portfolioSize ; i ++) {
			res += this.stocks[i].getBid() * this.stocks[i].getStockQuantity() ;
		}
		return res ;
	}
	
	//getting the total value
	public float getTotalValue() {
		return this.getStocksValue() + getBalance() ;
	}
}
