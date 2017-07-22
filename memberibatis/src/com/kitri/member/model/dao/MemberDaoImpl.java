package com.kitri.member.model.dao;

import java.sql.SQLException;
import java.util.*;

import com.kitri.ibatis.SqlMapConfig;
import com.kitri.member.model.*;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		try {
			return (int) SqlMapConfig.getSqlMapClient().queryForObject("rg.idcount", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		try {
			return SqlMapConfig.getSqlMapClient().queryForList("rg.zipsearch", dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		try {
			return SqlMapConfig.getSqlMapClient().update("rg.join", memberDetailDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		try {
			return (MemberDto) SqlMapConfig.getSqlMapClient().queryForObject("lg.login", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		try {
			return (MemberDetailDto) SqlMapConfig.getSqlMapClient().queryForObject("rg.getmember", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		try {
			cnt = SqlMapConfig.getSqlMapClient().update("rg.modify_detail", memberDetailDto);
			cnt += SqlMapConfig.getSqlMapClient().update("rg.modify", memberDetailDto);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete(String id) {
		int cnt =0;
		try {
			cnt = SqlMapConfig.getSqlMapClient().delete("rg.delete", id);
			cnt += SqlMapConfig.getSqlMapClient().delete("rg.delete_detail", id);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}














