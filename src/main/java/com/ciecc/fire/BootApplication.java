package com.ciecc.fire;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciecc.fire.domain.Person;
import com.ciecc.fire.setting.AuthorSettings;

@Controller
@SpringBootApplication
// @ImportResource({"classpath:some-context.xml","classpath:another-context.xml"})
// //加载xml配置
public class BootApplication {

	// 只需要定义属性然后注入值，不需要指明文件位置
	@Value("${book.author}")
	private String bookAuther;

	@Value("${book.name}")
	private String bookNmae;

	@Autowired
	private AuthorSettings authorSettings;

	/*@RequestMapping("/")
	  @ResponseBody
	String index() {
		return "book-name: " + bookNmae + " book-author " + bookAuther + " author-name: " + authorSettings.getName()
				+ " author-age " + authorSettings.getAge();
	}*/
	
	@RequestMapping("/")
	public String index(Model model) {
		Person single = new Person("aa", 11);
		
		List<Person> people = new ArrayList<>();
		Person p1 = new Person("xx", 11);
		Person p2 = new Person("yy", 12);
		Person p3 = new Person("zz", 14);
		
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		
		return "index";
	}

	public static void main(String[] args) {
		// SpringApplication.run(BootApplication.class, args); // 1

		// SpringApplication app = new SpringApplication(BootApplication.class);
		// //2
		// app.setBannerMode(Banner.Mode.OFF); //关闭banner
		// app.run(args);

		new SpringApplicationBuilder(BootApplication.class) // 3
				.bannerMode(Banner.Mode.OFF) // 关闭banner
				.run(args);

	}
	
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(){

			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
	    	
	    };
	    /*factory.setPort(9000);
	    factory.setSessionTimeout(10, TimeUnit.MINUTES);
	    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));*/
	    return factory;
	}
	
	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}
	
	/*@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new XxServlet(), "/xx/*");
		
	}*/
	
	
	/***
	 * 
	 * @return
	 */
	/*@Bean
	public FilterRegistrationBean myFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setDispatcherTypes(DispatcherType.REQUEST);
	    //registration.setFilter(new YYfilter());
	    registration.setOrder(2);
	    return registration;
	}*/
	
	/***
	 *  要禁用特定过滤器或Servlet bean的注册，请为其创建注册bean并将其标记为禁用。 例如：
	 * @param filter 要禁用的filter
	 * @return
	 */
	/*@Bean
	public FilterRegistrationBean registration(MyFilter filter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
	    registration.setEnabled(false);
	    return registration;
	}*/

	
	/*@Bean
	public ServletListenerRegistrationBean<Zzlistener> zzListenerServletRegistrationBean{
	    
	    return new ServletListenerRegistrationBean<Zzlistener>(new Zzlistener());
	}*/
	
}
