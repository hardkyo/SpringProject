package com.kitri.di.step11;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	
	private DataSource dataSource; 
	
	public MemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void homin(){
		System.out.println("222222객체 생성하자 마자 반드시 실행되어야 한다.");
	}
	

	public int register(MemberDto memberDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();	
			String sql = "";
			sql += "insert into springtest (id, name, joindate) \n";
			sql += "values (?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getName());
			cnt = pstmt.executeUpdate();
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

	public List<MemberDto> getList() {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();	
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
	
}
