package com.kitri.di.step11;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class MemberDaoFactory {

	public DataSource getDataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@192.168.18.31:1521:orcl");
		dataSource.setUsername("kitri");
		dataSource.setPassword("kitri");
		return dataSource;
	}
	
	@Bean(name={"memberDao","mdao"},initMethod="homin")
	public MemberDao getMemberDao() {
		return new MemberDao(getDataSource());
	}
	
}
