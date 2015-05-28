package boot.dubbo.simple.client.starter;

//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.env.Environment;

//@SpringBootApplication
//@ComponentScan(basePackages = "boot")
//public class SpringBootStarter extends SpringBootServletInitializer {
//	private Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
//
//	@Autowired
//	private Environment env;
//
//	@Override
//	protected SpringApplicationBuilder configure(
//			SpringApplicationBuilder application) {
//		log.info("=============容器启动（Spring Boot Container Start...）=============");
//		return application.sources(WebConfig.class);
//	}
//
//	/**
//	 * Config ServletListener, ServletFilter
//	 */
//	@Override
//	public void onStartup(ServletContext servletContext)
//			throws ServletException {
//		log.info("+++++++++++++容器启动（Web Container Servetlet Start...）+++++++++++++");
//		log.info("++++++++++++++++++++++++++{}" + (env == null));
//
//		super.onStartup(servletContext);
//	}
//
//}
