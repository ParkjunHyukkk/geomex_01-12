package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/loginService")
public class loginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id+","+pw);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		
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
		

				
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id, pw);
		MemberDTO info = dao.login(dto);

		if (info != null) {
			Cookie cookie1 = new Cookie("id", URLEncoder.encode(info.getId(),"utf-8"));
			Cookie cookie2 = new Cookie("pw", URLEncoder.encode(info.getPw(),"utf-8"));
			Cookie cookie3 = new Cookie("tel",URLEncoder.encode(info.getTel(),"utf-8"));

			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);

			//response.sendRedirect("loginSuccess.jsp");
			
			response.sendRedirect("loginSuccess.jsp");

		}
		else {
			PrintWriter out = response.getWriter();
			response.sendRedirect("login.jsp");
		}
	}

}
