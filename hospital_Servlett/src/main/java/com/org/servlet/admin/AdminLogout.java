package com.org.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/adminLogout")
public class AdminLogout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		hs.removeAttribute("adminObj");
		hs.setAttribute("succMsg", "Log out successfull");
		resp.sendRedirect("admin_login.jsp");
	}
	
}
