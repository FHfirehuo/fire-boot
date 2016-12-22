package com.ciecc.fire.data.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

	// pring Boot为Solr 5客户端库提供了基本的自动配置，并在Spring Data Solr的基础上提供了抽象。

	// 您可以像任何其他Spring bean一样注入自动配置的SolrClient实例。
	// 默认情况下，实例将尝试使用localhost:8983/solr:
	private SolrClient solr;

	@Autowired
	public MyBean2(SolrClient solr) {
		this.solr = solr;
	}

	// Spring Data包括Apache Solr的存储库支持。 与之前讨论的JPA存储库一样，基本原则是根据方法名自动构建查询。

	// 事实上，Spring Data JPA和Spring Data Solr共享相同的公共基础设施;
	// 所以你可以从前面的JPA示例，假设City现在是一个@SolrDocument类而不是JPA @Entity，它将以相同的方式工作。

}