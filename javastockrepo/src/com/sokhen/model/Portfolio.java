package com.sokhen.model;

//this class : portfolio of stocks
public class Portfolio {
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
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
	
	//ctor
	public Portfolio (String title) {
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.title = title;
	}
	
	//copy-ctor
	public Portfolio (Portfolio portfolio) {
		this(portfolio.getTitle());
		this.setPortfolioSize (portfolio.getPortfolioSize());
		for (int i=0 ; i<portfolio.getPortfolioSize() ; i++ ){
			this.stocks[i] = new Stock(portfolio.getStocks()[i]);
		}
	}

	//adding stock to the array
	public void addStock (Stock stock){
		if (portfolioSize < MAX_PORTFOLIO_SIZE){
			this.stocks[this.portfolioSize] = stock ;
			this.portfolioSize ++;
		}
		else
			return;
	}
	
	//returning string with details of all the stocks
	public String getHtmlString () {
		String str = new String ("<h1>" + title + "</h1> <br>");
		for (int i=0 ; i<portfolioSize ; i++) {
			str = str + stocks[i].getHtmlDescription() + "<br>";
		}
		return str;
	}
	
	//removing stock from array
	public void removeStock (Stock stock){
		for (int i=0 ; i<portfolioSize ; i++ ){
			if (stock.getSymbol().equals(stocks[i].getSymbol())){
				stocks[i] = stocks[portfolioSize - 1];
				stocks[portfolioSize -1] = null;
				portfolioSize --;
			}
		}
	}	
}
