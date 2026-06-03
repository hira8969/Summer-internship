package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyCalciServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int n1= Integer.parseInt(req.getParameter("first"));
		int n2=  Integer.parseInt(req.getParameter("sencond")) ;
		int sum = n1+ n2;
		PrintWriter pw= res.getWriter();
		pw.println("Sum is: "+ pw);
	}

}
