package org.pandaria.cafe.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.pandaria.cafe.domain.Contact;
import org.pandaria.cafe.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class ContactServiceTest extends TestCase {

	private static Logger logger = (Logger) LoggerFactory
			.getLogger(ContactServiceTest.class);

	@Before
	public void testLogger() {
		logger.info("Successfully!");
	}

	@Test
	public void testSave() throws DataAccessException, Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath*:spring/root-context.xml");
		ContactService service = ctx.getBean("contactService",
				org.pandaria.cafe.service.ContactServiceImpl.class);
		Contact contact = new Contact();
		contact.setFirstName("anders");
		contact.setLastName("adu");
		service.add(contact);
		logger.info(service.getSysDate());

	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx;
		try {
			ctx = new ClassPathXmlApplicationContext(
					"classpath*:spring/root-context.xml");
			System.out.println(ctx.containsBean("dataSource"));
			 ContactService service = ctx.getBean("contactService",
			 org.pandaria.cafe.service.ContactServiceImpl.class);
			Contact contact = (Contact) ctx.getBean("contact");
			/*
			 * Contact contact = new Contact(); contact.setFirstName("anders");
			 * contact.setLastName("adu"); service.add(contact);
			 */
			logger.info(contact.getFirstName());
			 logger.info(String.format("The database sys date %s", service.getSysDate()));

			// testJdbc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testJdbc() {
		String url = "jdbc:mysql://127.0.0.1:3306/cafe";
		String user = "root";
		String pwd = "10086216";
		String driverClass = "org.mariadb.jdbc.Driver";

		String sql = "SELECT sysdate() as SYSDATE";

		ResultSet res = null;
		Statement st = null;
		Connection conn = null;

		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(url, user, pwd);
			st = conn.createStatement();
			res = st.executeQuery(sql);
			while (res.next()) {
				String sysdate = res.getString("SYSDATE");
				System.out.println(sysdate);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
