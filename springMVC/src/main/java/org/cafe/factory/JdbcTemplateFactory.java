package org.cafe.factory;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class JdbcTemplateFactory {

	private DataSource dataSource;
	
	public abstract JdbcTemplate createJdbcTemplate(String branch);

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
