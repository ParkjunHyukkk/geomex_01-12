package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response
	    ) throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
			System.out.println("doPost");
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        
	        
	        String id = new String(request.getParameter("id").getBytes("Cp1252"),"UTF-8");
	        String pw = request.getParameter("pw");
	        
	        
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
			
			
			
	        System.out.println("���̵�: " + id);
	        System.out.println("��й�ȣ: " + pw);
	        
	        if (id != null && (id.length() != 0) && (pw.length() == 7)) 
	        	// �α��ν� "admin" üũ
	     
	        	if (id.equals("localhost") && pw.equals("1234567")) {
	        		out.print("<html>");
	        		out.print("<body>");
	        		out.print("<font size='8'>�����ڷ� �α��� �ϼ̽��ϴ�!!</font>" );
	        		out.print("<br>");	        
	        		out.print("<a href=\"delete.jsp\"><button>ȸ������ ����</button></a>");
	        		out.print("<a href=\"search.jsp\"><button>ȸ������ ��ȸ</button></a>");
	        		
	        		out.print("</html>");
	        		out.print("</body>");
	        	} else{
	        		out.print("<html>");
	        		out.print("<body>");
	        		out.print( id +"���������� �����Դϴ�." );
	        		out.print("</html>");
	        		out.print("</body>");	   
	        	}
	        	
	        out.close();
	        
	        
	        
		}

}
