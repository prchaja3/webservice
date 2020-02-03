package webservice.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


@WebListener
public class AppContextListener implements ServletContextListener {
	
	private static final Logger LOGGER = Logger.getLogger(AppContextListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		PropertyConfigurator.configure("C:/dev/tomcat/apache-tomcat/logs/log.properties");
		LOGGER.debug("Webservice deployed");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		LOGGER.debug("Webservice undeployed");
	}
}
