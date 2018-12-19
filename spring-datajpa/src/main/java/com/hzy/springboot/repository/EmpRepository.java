package com.hzy.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hzy.springboot.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	@Query("SELECT e FROM Emp e WHERE e.dept.dname = :dn")
	List<Emp> findEmps(@Param("dn") String dname);
}
