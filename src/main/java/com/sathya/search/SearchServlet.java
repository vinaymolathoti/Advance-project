package com.sathya.search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.register.UserDao;
import com.sathya.register.UserData;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		UserData user=UserDao.getUser(username); 
		if(user != null) {
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("searchsuccess.jsp");
			dispatcher.forward(request, response);

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("searchfail.jsp");
			dispatcher.include(request, response);

		}
	}

}