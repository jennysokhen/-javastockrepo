package com.sokhen.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sokhen.model.Portfolio;
import com.sokhen.service.PortfolioManager;

@SuppressWarnings("serial")

//the main servlet which prints the results
public class PortfolioServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		
		Portfolio portfolio2 = new Portfolio (portfolio);
		portfolio2.setTitle("Portfolio #2");
		
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println("<br>");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println("<br>");
		
		portfolio.removeStock(portfolio.getStocks()[0]);
		
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println("<br>");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println("<br>");
		
		portfolio2.getStocks()[2].setBid(55.55F);
		
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println("<br>");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println("<br>");			
	}
}
