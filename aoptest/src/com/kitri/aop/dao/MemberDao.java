package com.kitri.aop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kitri.aop.model.MemberDto;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int registerMember(MemberDto memberDto){
		System.out.println("dao registerMember");
		String sql = "insert into springtest (id, name, joindate) \n";
		sql += "values (?, ?, sysdate) ";
		return jdbcTemplate.update(sql, memberDto.getId(), memberDto.getName());
	}
	
	public List<MemberDto> listMember(){
		System.out.println("dao listMember");
		String sql = "select name, id, joindate from springtest";
		List<MemberDto> list = jdbcTemplate.query(sql, new MemberRowMapper());
		return list;
 	}

	public MemberDto searchMember(String id) {
		System.out.println("dao searchMember");
		String sql = "select * from springtest \n";
		sql += "where id = ?";
		MemberDto memberDto = (MemberDto) jdbcTemplate.queryForObject(sql, new MemberRowMapper(), id);
		return memberDto;
	}
	
	class MemberRowMapper implements RowMapper<MemberDto>{
		@Override
		public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDto memberDto = new MemberDto();
			memberDto.setId(rs.getString("id"));
			memberDto.setName(rs.getString("name"));
			memberDto.setJoindate(rs.getString("joindate"));
			return memberDto;
		}
	}
}
