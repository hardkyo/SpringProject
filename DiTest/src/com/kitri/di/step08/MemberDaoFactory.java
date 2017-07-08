package com.kitri.di.step08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class MemberDaoFactory {
	
	
	@Bean(name={"membeDao", "mdao"}, initMethod="homin")
	public MemberDao getMemberDao() {
		return new MemberDao(makeOraConnection());
	}
	
	@Bean
	public DBConnection makeOraConnection(){
		return new OraDBConnection();
	}
	
	@Bean
	public DBConnection makeMsConnection(){
		return new MsDBConnection();
	}
	
}
