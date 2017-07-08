package com.kitri.di.step06;

public class MemberDaoFactory {

	public MemberDao getMemberDao(String kind) {
		MemberDao memberDao = null;
		if ("oracle".equals(kind)) {
			memberDao = new MemberDao(makeOraConnection());
		}else if ("ms".equals(kind))
			memberDao = new MemberDao(makeMsConnection());
		return memberDao;
	}
	
	private DBConnection makeOraConnection(){
		return new OraDBConnection();
	}
	
	private DBConnection makeMsConnection(){
		return new MsDBConnection();
	}
	
}
