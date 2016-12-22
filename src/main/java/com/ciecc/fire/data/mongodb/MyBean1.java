package com.ciecc.fire.data.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

//import com.mongodb.DB;

@Component
public class MyBean1 {

	// 您可以设置spring.data.mongodb.uri属性以更改URL并配置其他设置，如副本集：
	// spring.data.mongodb.uri=mongodb://user:secret@mongo1.example.com:12345,mongo2.example.com:23456/test
	// 或者，只要使用Mongo 2.x，请指定主机/端口。 例如，您可以在application.properties中声明以下内容：
	// spring.data.mongodb.host=mongoserver
	// spring.data.mongodb.port=27017
	// 如果您使用Mongo 3.0
	// Java驱动程序，则不支持spring.data.mongodb.host和spring.data.mongodb.port。
	// 在这种情况下，应该使用spring.data.mongodb.uri来提供所有的配置。
	//如果未指定spring.data.mongodb.port，则使用缺省值27017。 您可以从上面的示例中删除此行。
	//private final MongoDbFactory mongo;

	//@Autowired
	//public MyBean1(MongoDbFactory mongo) {
	//	// 默认情况下，实例将尝试使用URL mongodb：// localhost / test连接到MongoDB服务器：
	//	this.mongo = mongo;
	//}

	//public void example() {
	//	DB db = mongo.getDb();
	//}
	
	//如果你不使用Spring Data Mongo，你可以注入com.mongodb.Mongo bean而不是使用MongoDbFactory。见MyFactory
	
	
	

}