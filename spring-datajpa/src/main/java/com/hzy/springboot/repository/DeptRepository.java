package com.hzy.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hzy.springboot.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
	// SELECT * FROM dept WHERE dname = ?
	List<Dept> findByDname(String dname);
	// SELECT * FROM dept WHERE deptno <= ? AND dname LIKE '%..%' ORDER BY dname asc
//	List<Dept> findByDeptnoLessThanEqualsAndDnameContainingOrderByDname(Integer deptno, String dname);
	
	// JPQL
//	@Query("select d from Dept d where d.dname='AAAA'")
	@Query("select d from Dept d where d.dname=:dn order by deptno desc")
	List<Dept> findDepts(@Param("dn")String dname);
}
