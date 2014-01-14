package org.cafe.service;

import junit.framework.TestCase;

import org.cafe.domain.Contact;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactServiceTest extends TestCase {

	@Test
	public void testSave() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath*:spring/root-context.xml;spring/app-servlet/servlet-context.xml");
		ContactService service = ctx.getBean("contactService", org.cafe.service.ContactServiceImpl.class);
		Contact contact = new Contact();
		contact.setFirstName("anders");
		contact.setLastName("adu");
		service.add(contact);
		
	}
}
