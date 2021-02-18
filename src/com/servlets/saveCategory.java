package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CategoryDao;
import com.entities.Category;
import com.entities.Message;

import blog.helper.ConnectionProvider;

/**
 * Servlet implementation class saveCategory
 */
@WebServlet("/saveCategory")
public class saveCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public saveCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String description = request.getParameter("description");

		Category cat = new Category();
		cat.setName(name);
		cat.setDescription(description);

		CategoryDao dao = new CategoryDao(ConnectionProvider.getConnection());
		boolean result = dao.saveData(cat);

		if (result) {
			Message msg = new Message("Successfully Saved", "success", "successs");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
		} else {
			Message msg = new Message("Something have issued", "fail", "danger");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
		}

		RequestDispatcher rd = request.getRequestDispatcher("catAdd.jsp");
		rd.include(request, response);
	}

}
