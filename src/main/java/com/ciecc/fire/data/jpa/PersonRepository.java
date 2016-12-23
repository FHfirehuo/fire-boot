package com.ciecc.fire.data.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ciecc.fire.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	List<Person> findByName(String name);
	
	
	List<Person> findByNameAndAddress(String name, String address);
	
	@Query("select p from Person p where p.address = ?1")
	List<Person> findByAddress(String address);

	@Query("select p from Person p where p.address = :address")
	List<Person> findByAddress2(@Param("address") String address);
	
	@Modifying // 表示一个方法应该被视为修改查询。
	@Transactional
	@Query("update Person p set p.name=?1")
	int setName(String name);
	
	
	//Page<Person> findByName(String name, Pageable pageable);
	
	@Query(value = "SELECT * FROM person WHERE EMAIL = ?1", nativeQuery = true)
	Person findByEmail(String email);
	
	//虽然是官网示例但依然不能运行
	//使用@Query的查询方法中声明本机计数查询以进行分页
	//@Query(value = "SELECT * FROM person WHERE name = ?1", countQuery = "SELECT count(*) FROM person WHERE name = ?1", nativeQuery = true)
	//Page<Person> findByNameLike(String name, Pageable pageable);
	
	
	@Query(value = "SELECT * FROM person WHERE p.address = ?1 \n#pageable\n", 
			countQuery = "SELECT count(*) FROM person AS p WHERE p.address = ?1", 
			nativeQuery = true)
	Page<Person> queryByAddress(String address, Pageable pageable);
	
	//使用@Query的查询方法中声明本机计数查询以进行分页
	@Query(value = "SELECT * FROM person WHERE city = ?1 \n#pageable\n", nativeQuery = true)
	Page<Person> queryByCity(String city, Pageable pageable);
	

}
