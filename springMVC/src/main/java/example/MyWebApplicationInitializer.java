package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * In a Servlet 3.0+ environment, you also have the option of configuring the Servlet container programmatically. 
 * Below is the code based equivalent of the above web.xml example.
 * @author duzhiwei
 *
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/example/*");
		
	}

}
