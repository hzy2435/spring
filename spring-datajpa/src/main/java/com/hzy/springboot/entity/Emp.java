package com.hzy.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity		// 表明实体类
@Table(name="emp")
public class Emp {
	@Id	// 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	// 自动增长策略
	@Column(name="empno")
	private Integer empno;
	@Column(name="ename")
	private String ename;
	@Column(name="job")
	private String job;
	@Column(name="mgr")
	private Integer mgr;
	@Column(name="hiredate")
	private Date hiredate;
	@Column(name="sal")
	private Float sal;
	@Column(name="comm")
	private Float comm;
	// 多对一
	@ManyToOne
	@JoinColumn(name="deptno")
	private Dept dept;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	public Float getComm() {
		return comm;
	}

	public void setComm(Float comm) {
		this.comm = comm;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
