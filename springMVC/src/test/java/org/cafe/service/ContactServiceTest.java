package org.cafe.service;

import junit.framework.TestCase;
import org.cafe.domain.Contact;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactServiceTest extends TestCase {

    private Logger logger = (Logger) LoggerFactory.getLogger(ContactServiceTest.class);

    @Test
    public void testSave() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring/root-context.xml;spring/app-servlet/servlet-context.xml");
        ContactService service = ctx.getBean("contactService", org.cafe.service.ContactServiceImpl.class);
        Contact contact = new Contact();
        contact.setFirstName("anders");
        contact.setLastName("adu");
        service.add(contact);
    }

    @Test
    public void testLogger() {
        logger.info("Successfully!");
    }
}
