package org.cafe.service;

import java.util.List;

import org.cafe.domain.Contact;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ContactServiceImpl implements ContactService{

	private JdbcTemplate jdbcTemplate;
	
	public Contact queryById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> retrieveAll() {
		String sql = "SELECT * FROM CONTACT";
		RowMapper<Contact> rowMapper = new BeanPropertyRowMapper<Contact>();
		((BeanPropertyRowMapper)rowMapper).setMappedClass(org.cafe.domain.Contact.class);
		List<Contact> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	public void add(Contact contact) {
		String sql = "insert into contact (first_name, last_name) values (?, ?);";
		jdbcTemplate.update(sql,new Object[]{contact.getFirstName(),contact.getLastName(),contact.getBirthDate()});
	}

	public void update(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	public boolean delete(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
