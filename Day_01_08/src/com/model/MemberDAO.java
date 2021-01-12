package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class MemberDAO {

	private ResultSet rs; // 필드는 기본적으로 객체를 생성하면 NULL값이 들어간다.
	private PreparedStatement psmt;
	private Connection conn;
	private static MemberDAO dao;
	
	public static MemberDAO getDAO() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}


	private void getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			String db_url = "jdbc:postgresql://localhost/login?useUnicode=true& useUnicode=true&characterEncoding=euc_kr";
			String db_id = "postgres";
			String db_pw = "1234";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) { // 찾을 수 없는 DB 값의 예외 처리
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean isExisted(MemberDTO dto) {
		boolean result = false;
		String id = dto.getId();
		String pw = dto.getPw();
		
		try {
			//db - servlet 연결
			getConnection();
			
			//조회하는 ID가 있으면  'true', 없으면 'false' (as result는 레코드 이름)
			String sql = "SELECT IF(COUNT(*) = 1 , 'true', 'false') AS RESULT"
					+ " FROM mymember"
					+" WHERE id = ? AND pw = ?";
			
			//SQL문을 PrepareStatement에 등록하고 각각의 자리(?)를 채운다.
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);			
			psmt.setString(2, pw);
			
			//DB에 쿼리를 전송하고, 결과 값을 받는다.
			ResultSet rs = psmt.executeQuery();

			rs.next();	//커서를 첫 번째 레코드에 위치한다.
			
			//'result'라는 레코드의  값을 boolean으로 변환
			result = Boolean.parseBoolean(rs.getString("result"));
			
			System.out.println("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int join(MemberDTO dto) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "insert into mymember values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { // 모든 DB관련 SQL문의 오류를 처리
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	

	  public MemberDTO getMember(String id) {
	        String query = "select * from users where id = ?";
	        MemberDTO dto = null;
	        
	        try {
	            getConnection();
	            psmt = conn.prepareStatement(query);
	            psmt.setString(1, id);
	            rs= psmt.executeQuery();
	            
	            if(rs.next()) {
	                dto = new MemberDTO();
	                dto.setId(rs.getString("id"));
	                dto.setPw(rs.getString("pw"));
	                dto.setTel(rs.getString("name"));
	      
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	            close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        
	        return dto;
	        
	    }
	  
	  
	
	
	public MemberDTO login(MemberDTO dto) {

		MemberDTO info = null;

		String l_id = null;
		String l_pw = null;
		String l_tel = null;
		String l_food = null;

		try {
			getConnection();

			String sql = "select * from mymember where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				l_id = rs.getString(1);
				l_pw = rs.getString(2);
				l_tel = rs.getString(3);

				info = new MemberDTO(l_id, l_pw, l_tel,l_food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return info;
	}
	
	public int delete(MemberDTO dto) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "delete from mymember where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { // 모든 DB관련 SQL문의 오류를 처리
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	
	public ArrayList<MemberDTO> memberSearchAll() {
		String sql = "SELECT * FROM mymember";
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String l_id = rs.getString(1);
				String l_pw = rs.getString(2);
				String l_tel = rs.getString(3);
				String l_food = rs.getString(4);
				MemberDTO dto = new MemberDTO(l_id, l_pw, l_tel,l_food);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberSearchAll() Exception!!!");
		} finally {
			close();
		}
		return list;
	} // memberSearchAll()
	
	public int update(MemberDTO dto) {

		int cnt = 0;
		try {
			getConnection();
			String sql = "update mymember set food=? where id=?";

			psmt = conn.prepareStatement(sql); // SQL 문장을 자바에서 설정해주는 객체
			psmt.setString(1, dto.getPw());
	//		psmt.setString(2, dto.getTel());
			psmt.setString(2, dto.getId());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}

		return cnt;
	}


	
	
}
