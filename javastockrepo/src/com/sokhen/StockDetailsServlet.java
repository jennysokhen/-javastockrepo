package com.sokhen;
import java.io.IOException;

import java.util.Date;
import com.sokhen.Stock;
import java.util.Calendar;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html") ;
		
		Calendar cal = Calendar.getInstance() ;
		cal.set (2014, 11, 15) ;
			
		Date date1 = cal.getTime() ;
		Date date2 = cal.getTime() ;
		Date date3 = cal.getTime() ;		
		
		Stock stock1 = new Stock ( "PIH", 13.1f, 12.4f, date1 ) ;
		Stock stock2 = new Stock ( "AAL", 5.78f, 5.5f, date2 ) ;
		Stock stock3 = new Stock ( "CAAS", 32.2f, 31.5f, date3 ) ;
		
		String str1 = new String ( stock1.getHtmlDescription() );
		String str2 = new String ( stock2.getHtmlDescription() );
		String str3 = new String ( stock3.getHtmlDescription() );
		
		String strRes = str1 +"<br>"+ str2 +"<br>"+ str3 ;
		resp.getWriter().println(strRes) ;
	}
}
