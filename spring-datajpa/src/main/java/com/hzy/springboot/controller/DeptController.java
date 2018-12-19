package com.hzy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzy.springboot.entity.Dept;
import com.hzy.springboot.repository.DeptRepository;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/dept")
public class DeptController {
	@Resource
	private DeptRepository deptRepository = null;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Dept selectById(@PathVariable("id") Integer id) {
		Optional<Dept> option = deptRepository.findById(id);
		Dept dept = null;
		if(option.isPresent()==true) {
			dept = option.get();
		}
		return dept;
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Dept create() {
		Dept dept = new Dept();
		dept.setDname("AAAA");
		dept.setLocation("New York");
		// Jpa 新增对象会将返回的主键回填到对象中
		deptRepository.save(dept);
		return dept;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Dept update() {
		Dept dept = deptRepository.findById(30).get();
		dept.setDname("(" + dept.getDname() + ")");
		deptRepository.save(dept);
		return dept;
	}
	
	@GetMapping("delete")
	@ResponseBody
	public Dept delete() {
		Dept dept = deptRepository.findById(40).get();
		deptRepository.delete(dept);
		return dept;
	}
	
	@GetMapping("/find")
	@ResponseBody
	public List<Dept> findDepts(String dname) {
		List<Dept> depts = deptRepository.findDepts(dname);
		return depts;
	}
}
