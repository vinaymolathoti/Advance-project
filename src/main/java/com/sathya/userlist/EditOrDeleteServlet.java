package com.sathya.userlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.register.UserDao;
import com.sathya.register.UserData;

@WebServlet("/EditOrDeleteServlet")
public class EditOrDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditOrDeleteServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("Edit")) {
			int userId=Integer.parseInt(request.getParameter("userid"));
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			String qualification = request.getParameter("qualification");
			String gender = request.getParameter("gender");
			String technologies = request.getParameter("technologies");
			String address = request.getParameter("address");
			UserData user = new UserData(null,null, null, null, null, null, null, null, null, null);
			user.setUserId(userId);
			user.setUsername(username);
			user.setEmail(email);
			user.setCountry(country);
			user.setQualification(qualification);
			user.setGender(gender);
			user.setTechnologies(technologies);
			user.setAddress(address);
			boolean res=UserDao.updateUser(user);
			if(res) {
				List<UserData> users=UserDao.userList();
				request.setAttribute("users", users);
				RequestDispatcher dispatcher = request.getRequestDispatcher("updatesuccesss.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("updatefail.jsp");
				dispatcher.forward(request, response);
			}

		}
		else {
			int userId=Integer.parseInt(request.getParameter("userid"));
			boolean res=UserDao.deleteUser(userId);
			if(res) {
				List<UserData> users=UserDao.userList();
				request.setAttribute("users", users);
				RequestDispatcher dispatcher = request.getRequestDispatcher("deletesuccesss.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("deletefail.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}