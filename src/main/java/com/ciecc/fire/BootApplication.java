package com.ciecc.fire;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
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
	
	@RequestMapping("")
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
}
