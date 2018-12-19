package com.hzy.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity	// 实体类，在sb启动时自动加载
@Table(name="dept")	// 映射的表
public class Dept {
	@Id	// 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	// 自动增长策略
	@Column(name="deptno")
	private Integer deptno;
	@Column(name="dname")
	private String dname;
	@Column(name="loc")
	private String location;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
