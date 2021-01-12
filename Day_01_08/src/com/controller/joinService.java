package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/JoinService")
public class joinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String food = request.getParameter("food");

		
	 	if(id != null) {
			id = id.replaceAll("<", "&lt;");
			id = id.replaceAll(">", "&lt;");
		}else {
			return;
		}
		
		if(pw != null) {
			pw = pw.replaceAll("<", "&lt;");
			pw = pw.replaceAll(">", "&lt;");
		}else {
			return;
		}
		
		if(tel != null) {
			tel = tel.replaceAll("<", "&lt;");
			tel = tel.replaceAll(">", "&lt;");
		}else {
			return;
		}
		
		System.out.println(request.getParameter("tel"));
		MemberDTO dto = new MemberDTO(id, pw, tel,food);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);

		if (cnt > 0) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("");
		}
	}

}