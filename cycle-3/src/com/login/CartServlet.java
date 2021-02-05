package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc = getServletContext();
		
		String  credit= sc.getInitParameter("creditCardNumber");
		String[] book_price = request.getParameterValues("test");
		System.out.println(book_price.length);
		int totalPrice = 0;
		for (int i = 0; i < book_price.length; i++) {
			totalPrice += Integer.parseInt(book_price[i]);
		}
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd=request.getRequestDispatcher("/Homepage.html");
		rd.include(request, response);
		
		out.println("Total Price : " + totalPrice + "<br>Credit Card Number : " + credit + "<br>");
		out.println(session.getAttribute("email"));
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}