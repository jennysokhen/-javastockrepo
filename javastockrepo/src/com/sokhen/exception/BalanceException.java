package com.sokhen.exception;

import org.algo.exception.PortfolioException;

public class BalanceException extends PortfolioException {

	public BalanceException() {
		super("The portfolio balance is negative!") ;
	}
	
	public BalanceException (String error) {
		super(error) ;
	}
}