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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc = getServletContext();
		String username = sc.getInitParameter("email");
		String password = sc.getInitParameter("password");

		String user_name=request.getParameter("email");
		String pass_word=request.getParameter("psw");
		
		HttpSession session = request.getSession(true);
		
		System.out.println("user: " + username + "\npass: " + password);
		if(user_name.equalsIgnoreCase(username) && pass_word.equals(password)){
			session.setAttribute("email", request.getParameter("email"));
			RequestDispatcher rd=request.getRequestDispatcher("/Homepage.html");
			
			out.println("<body text='black'>");
			out.println("<h4><center>Login Success!</center></h4>");
			out.println("</body>");
			
			rd.include(request, response);
		}
		else {
			out.println("<body text='black'>");
			out.println("<h4><center>Invalid Credentials!</center></h4>");
			out.println("</body>");
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			
		}
		out.close();
	}
}