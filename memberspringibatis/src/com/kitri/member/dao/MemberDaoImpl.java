package com.kitri.member.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;

@Repository
public class MemberDaoImpl extends SqlMapClientDaoSupport implements MemberDao {

	@Override
	public int idCheck(String id) {
		try {
			return (int) getSqlMapClient().queryForObject("rg.idcount", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		try {
			return getSqlMapClient().queryForList("rg.zipsearch", dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		try {
			return getSqlMapClient().update("rg.join", memberDetailDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		try {
			return (MemberDto) getSqlMapClient().queryForObject("lg.login", map);
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;
	}

	@Override
	public MemberDetailDto getMember(String id) {

		return null;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		int cnt = 0;

		return cnt;
	}

	@Override
	public int delete(String id) {
		int cnt = 0;

		return cnt;
	}

}
