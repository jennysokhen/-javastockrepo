package com.sokhen.model;

import com.sokhen.Stock;

public class Portfolio {
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize;
	
	public Portfolio (String title) {
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.title = title;
	}
	
	public void addStock (Stock stock){
		if (portfolioSize < MAX_PORTFOLIO_SIZE){
			this.stocks[this.portfolioSize] = stock ;
			this.portfolioSize ++;
		}
		else
			return;
	}
	
	public Stock[] getStocks() {
		return this.stocks;
	}
	
	public String getHtmlString () {
		String str = new String ("<h1>" + title + "</h1> <br>");
		for (int i=0 ; i<portfolioSize ; i++) {
			str = str + stocks[i].getHtmlDescription() + "<br>";
		}
		return str;
	}
	
}

