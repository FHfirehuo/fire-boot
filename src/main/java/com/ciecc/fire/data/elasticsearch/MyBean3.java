package com.ciecc.fire.data.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyBean3 {

//	private ElasticsearchTemplate template;
//
//	@Autowired
//	public MyBean3(ElasticsearchTemplate template) {
//		// 如果添加您自己的@Bean类型ElasticsearchTemplate它将替换默认值。
//		this.template = template;
//	}

	// Spring Data包括对Elasticsearch的存储库支持。 与之前讨论的JPA存储库一样，基本原则是根据方法名自动构建查询。

	// 事实上,pring Data JPA和Spring Data
	// Elasticsearch共享相同的公共基础设施;所以你可以从前面的JPA示例，假设City现在是一个Elasticsearch
	// @Document类，而不是JPA @Entity，它将以相同的方式工作。
}
