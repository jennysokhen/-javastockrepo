package com.sokhen.exception;

import org.algo.exception.PortfolioException;

public class StockNotExistException extends PortfolioException {
		
		public StockNotExistException() {
			super("Stock is not found!") ;
		}
		
		public StockNotExistException(String stock) {
			super("Stock " +stock+ " is not found!") ;
		}
}
