package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.UserDao;
import com.entities.User;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import blog.helper.ConnectionProvider;
import blog.helper.Helper;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
@MultipartConfig
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserServlet() {
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
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String about = request.getParameter("about");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		user.setName(name);
		user.setEmail(email);
		user.setGender(gender);
		user.setAbout(about);
		String oldFile = user.getProfile();
		user.setProfile(imageName);

		// Update user
		UserDao dao = new UserDao(ConnectionProvider.getConnection());

		boolean status = dao.updateUser(user);
		PrintWriter out = response.getWriter();

		if (status) {
			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfile();
			
			if(!oldFile.equals("default.png"))
			{
				// Delete old pic
				String oldFilePath = request.getRealPath("/") + "pics" + File.separator + oldFile;
				Helper.deleteFile(oldFilePath);
			}

			if (Helper.saveFile(part.getInputStream(), path)) {
				out.println("Profile Updated...");

			} else {
				out.println("Profile Failed...");
			}

		} else {
			out.println("Failed");
		}

	}

}
