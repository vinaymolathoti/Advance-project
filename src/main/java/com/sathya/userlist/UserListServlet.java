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

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//call Dao layer
		List<UserData> users=UserDao.userList();
		if(users != null) {
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewsuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewfail.jsp");
			dispatcher.forward(request, response);
		}
	}

}