package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.StringConcatFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.PostDao;
import com.entities.Post;
import com.entities.User;

import blog.helper.ConnectionProvider;
import blog.helper.Helper;

/**
 * Servlet implementation class SavePost
 */
@WebServlet("/SavePostServlet")
@MultipartConfig
public class SavePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String code = request.getParameter("code");
		String category = request.getParameter("category");
		int catId = Integer.parseInt(category);
		Part part = request.getPart("pic");
		String pic = part.getSubmittedFileName();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		int userId = user.getId();
		
		Post post = new Post();
		post.setTitle(title);
		post.setCat_id(catId);
		post.setCode(code);
		post.setContent(content);
		post.setPic(pic);
		post.setUser_id(userId);
		
		PostDao dao = new PostDao(ConnectionProvider.getConnection());
		boolean a = dao.savePost(post);
		if(a)
		{
			out.print("Success");
			String path = request.getRealPath("/") + "blog_pics"+ File.separator + pic;
			Helper.saveFile(part.getInputStream(), path);
		} else {
			out.print("Failed");
		}
	}

}
 