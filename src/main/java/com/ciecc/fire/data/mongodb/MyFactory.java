package com.ciecc.fire.data.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyFactory {

	//// 如果你不使用Spring Data Mongo，你可以注入com.mongodb.Mongo bean而不是使用MongoDbFactory。
	//private final MongoTemplate mongoTemplate;

	//@Autowired
	//public MyFactory(MongoTemplate mongoTemplate) {
	//	this.mongoTemplate = mongoTemplate;
	//}

	// Spring数据包括对MongoDB的存储库支持。 与之前讨论的JPA存储库一样，基本原则是根据方法名自动构建查询。

	// 事实上，Spring Data JPA和Spring Data MongoDB共享相同的公共基础设施;
	// 所以你可以从早期的JPA示例，并假设城市现在是一个Mongo数据类，而不是一个JPA @Entity，它将以相同的方式工作。
	
	
}


// package com.example.myapp.domain;
//
// import org.springframework.data.domain.*;
// import org.springframework.data.repository.*;
//
// public interface CityRepository extends Repository<City, Long> {
//
// Page<City> findAll(Pageable pageable);
//
// City findByNameAndCountryAllIgnoringCase(String name, String country);
//
// }