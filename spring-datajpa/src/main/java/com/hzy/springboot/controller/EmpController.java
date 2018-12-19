package com.hzy.springboot.controller;

import com.hzy.springboot.entity.Dept;
import com.hzy.springboot.entity.Emp;
import com.hzy.springboot.repository.DeptRepository;
import com.hzy.springboot.repository.EmpRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

// @Controller
@RestController // 自动将所有方法返回的对象json化，而不是返回视图
@RequestMapping(value = "/emp")
public class EmpController {

	@Autowired
	private EmpRepository empRepository;
	@Autowired
	private DeptRepository deptRepository;

	@GetMapping("/{id}")
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true) // 关闭事务
	public Emp findById(@PathVariable("id") Integer id) {

		Optional<Emp> opt = empRepository.findById(id);
		Emp emp = null;

		if (opt.isPresent()) {

			emp = opt.get();

		}
		return emp;
	}

	@GetMapping("/create")
	@Transactional(rollbackFor = Exception.class)
	public Emp create() {

		Emp emp = new Emp();
		emp.setComm(0f);
		emp.setEname("Jam");
		emp.setHiredate(new Date());
		emp.setJob("SALES");
		emp.setMgr(null);
		emp.setSal(3000f);
		Dept dept = deptRepository.findById(20).get();
		emp.setDept(dept);
		empRepository.save(emp);
		return emp;
	}

	@GetMapping("/find")
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true) // 关闭事务回滚
	public List<Emp> findEmps(String dname) {

		return empRepository.findEmps(dname);

	}

	@GetMapping("/imp")
	@Transactional(rollbackFor = Exception.class) // 修改至当出现任何错误时，进行事务回滚，默认只接收RuntimeException及其子类的异常
	public void imp() {

		for (int i = 0; i < 10; i++) {

			if (i == 5) {
				throw new RuntimeException();
			}

			Emp emp = new Emp();
			emp.setComm(0f);
			emp.setEname("Jam" + i);
			emp.setHiredate(new Date());
			emp.setJob("SALES");
			emp.setMgr(null);
			emp.setSal(i * 1000f);
			Dept dept = deptRepository.findById(20).get();
			emp.setDept(dept);
			empRepository.save(emp);

		}
	}
}
