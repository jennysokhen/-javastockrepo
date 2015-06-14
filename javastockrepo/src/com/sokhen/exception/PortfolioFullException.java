package com.sokhen.exception;

import org.algo.exception.PortfolioException;

public class PortfolioFullException extends PortfolioException {
	public PortfolioFullException() {
		super("Can not add more stocks than max stocks limitation!") ;
	}
}
