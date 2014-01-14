package org.cafe.factory;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

<<<<<<< HEAD
public abstract class JdbcTemplateFactory {

	private DataSource dataSource;
	
	public abstract JdbcTemplate createJdbcTemplate(String branch);

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
=======
public class JdbcTemplateFactory {

	private String branch = "common";
	private DataSourceFactory dataSourceFactory;
	private DataSource ds;
	
	public JdbcTemplate buildJdbcTemplate() throws Exception{
		return new JdbcTemplate(ds);
	}
	
	public JdbcTemplate createJdbcTemplate() throws Exception{
		return new JdbcTemplate(dataSourceFactory.getDataSource(branch));
	}
	
	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}  

	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
		this.dataSourceFactory = dataSourceFactory;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
>>>>>>> 2c310380cd354f23053bc6074bbb9d8642c6eea2
	}

}
