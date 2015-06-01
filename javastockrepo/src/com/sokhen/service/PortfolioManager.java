package com.sokhen.service;

import java.util.Calendar;
import java.util.Date;

import org.algo.dto.PortfolioDto;
import org.algo.dto.PortfolioTotalStatus;
import org.algo.exception.PortfolioException;
import org.algo.model.PortfolioInterface;
import org.algo.service.PortfolioManagerInterface;

import com.google.appengine.api.datastore.DatastoreService;
import com.sokhen.model.Portfolio; 
import com.sokhen.model.Stock;

//this class : managing portfolio and his stocks
public class PortfolioManager implements PortfolioManagerInterface {

 	public enum ALGO_RECOMMENDATION {
 		BUY(0), SELL(1), REMOVE(2), HOLD(3) ;
 		
 		private int num ;
 		private ALGO_RECOMMENDATION (int num) {
 			this.num = num ;
 		}
 		public int getNum () {
 			return num ;
 		}
 	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PortfolioInterface getPortfolio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBalance(float value) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PortfolioTotalStatus[] getPortfolioTotalStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStock(String symbol) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyStock(String symbol, int quantity) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellStock(String symbol, int quantity)
			throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStock(String symbol) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

}
