package com.kitri.di.step06;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	
	private DBConnection dbc;
	
	public MemberDao(DBConnection dbc) {
		this.dbc = dbc;
	}

	public int register(MemberDto memberDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbc.getConnection();	
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

	public List<MemberDto> getList() {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbc.getConnection();	
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
	
}
