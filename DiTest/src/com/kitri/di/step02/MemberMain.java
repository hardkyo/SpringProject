package com.kitri.di.step02;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import com.kitri.di.model.MemberDto;

public class MemberMain {

	private Connection Connection() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.31:1521:orcl", "kitri", "kitri");
		return conn;
	}
	
	private int register(MemberDto memberDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Connection();	
			String sql = "";
			sql += "insert into springtest (id, name, joindate) \n";
			sql += "values (?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getName());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}


	
	private List<MemberDto> getList() {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Connection();	
			String sql = "";
			sql += "select id, name, joindate \n";
			sql += "from springtest";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setName(rs.getString("name"));
				memberDto.setId(rs.getString("id"));
				memberDto.setJoindate(rs.getString("joindate"));
				
				list.add(memberDto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		MemberMain mm = new MemberMain();
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId("hardkyo1");
		memberDto.setName("강상국1");
		
		int cnt = mm.register(memberDto);
		System.out.println("유저 등록 " + (cnt != 0 ? "성공!!!" : "실패!!!"));
		
		List <MemberDto> list = mm.getList();
		System.out.println("아이디\t이름\t가입일");
		System.out.println("-----------------------------------");
		for (MemberDto memberDto2 : list) {
			System.out.println(memberDto2.getId() + "\t" + memberDto2.getName() + "\t" + memberDto2.getJoindate());
		}
	}
	
}
