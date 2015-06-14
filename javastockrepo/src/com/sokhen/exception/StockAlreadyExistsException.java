package com.sokhen.exception;

import org.algo.exception.PortfolioException;

public class StockAlreadyExistsException extends PortfolioException {
	
	public StockAlreadyExistsException() {
		super("Stock is already exists!") ;
	}
	
	public StockAlreadyExistsException(String symbol) {
		super("Stock " +symbol+ " is already exists!") ;
	}
}