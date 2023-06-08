package com.sathya.resetpassword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.register.UserDao;


@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PasswordResetServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting client data
				String email=	request.getParameter("email");
				String newPassword=	request.getParameter("newpassword");
				String confPassword=	request.getParameter("confpassword");

				if(newPassword.equals(confPassword)) {

				int res =	UserDao.passwordreset(email, confPassword);

				if(res==1) {
					RequestDispatcher dispatcher=request.getRequestDispatcher("Passwordresetsuccess.jsp");
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher=request.getRequestDispatcher("Passwordresetfail.jsp");
					dispatcher.forward(request, response);
				}
				}
				else {
					RequestDispatcher dispatcher=request.getRequestDispatcher("Passwordresetfail.jsp");
					dispatcher.forward(request, response);
				}
	}

}