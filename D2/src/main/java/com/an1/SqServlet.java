package com.an1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int k=Integer.parseInt(req.getParameter("k"));
		//int k=(int)req.getAttribute("k");
		PrintWriter out1=res.getWriter();
		out1.println("Hello to Square"+k*k);
		System.out.println("hello");
	}
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
//	{
//		int k=(int)req.getAttribute("k");
//		PrintWriter out12=res.getWriter();
//		out12.println("Hello to Addition"+k);
//		
//	}

}
