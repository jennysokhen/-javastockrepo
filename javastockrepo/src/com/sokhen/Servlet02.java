package com.sokhen;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		double radius = 50.0;
		double areaOfCircle;
		areaOfCircle = Math.PI * Math.pow(radius,2);
		double angleInDegrees = 30;
		double hypotenuseLength = 50;
		double angleInRadians = Math.toRadians (angleInDegrees);
		double oppositeLength = hypotenuseLength * Math.sin(angleInRadians);
		double powerResult = Math.pow(20,13);
		
		String Str1 = new String ("<h1>Calculation 1: Area of circle with radius "+radius+" is: "+areaOfCircle+" square­cm</h1>");
		String Str2 = new String ("<h1>Calculation 2: Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: "+oppositeLength+" cm</h1>");
		String Str3 = new String ("<h1>Calculation 3: Power of 20 with exp of 13 is "+powerResult+"</h1>");
		
		String ResultStr = Str1+"<br>"+Str2+"<br>"+Str3; 
		resp.getWriter().println(ResultStr);		
	}
}
