package com.spring.jdbc;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class JdbcTest {

	private ApplicationContext ctx;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	
	@Test
	public void testJdbcDataSource() throws SQLException {
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		
	}
	
	/*
	 * 测试 update
	 */
	@Test
	public void testUpdate() {

		String sql = "UPDATE employee SET emp_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "xiaobai", 1);
		
	}
	
	/*
	 * 测试批量更新
	 */
	@Test
	public void testBatchUpdate() {
		
		String sql = "INSERT INTO employee(emp_name, dept_no) VALUES (?, ?)";
		
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] {"aaa", 2});
		batchArgs.add(new Object[] {"bbb", 3});
		batchArgs.add(new Object[] {"ccc", 1});
		batchArgs.add(new Object[] {"ddd", 2});
		batchArgs.add(new Object[] {"eee", 3});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
		
	}
	
	/*
	 * 从数据库中获取一条记录, 实际得到对应的一个对象
	 * 不是调用 queryForObject(String sql, class<Employee> requiredType, Object... args) 方法
	 * 而是调用 queryForObject(String sql, RowMapper rowMapper, Object... args)
	 * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
	 * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射, 例如 last_name lastName
	 * 3. 不支持级联属性
	 */
	@Test
	public void testQueryForObject() {
		
		String sql = "SELECT id, emp_name empName FROM employee WHERE id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 5);
		
		System.out.println("employee: " + employee);
	}
	
	/*
	 * 获取实体类的集合 
	 */
	@Test
	public void testQueryForList() {
		
		String sql = "SELECT id, emp_name empName FROM employee WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 1);
		employees.forEach(employee -> System.out.println(employee));
	}
	
	/*
	 * 获取某一列
	 */
	@Test
	public void testQueryForObject2() {
		
		String sql = "SELECT COUNT(id) FROM employee";
		
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println("count: " + count);
		
	}
	
	/*
	 * 测试 NamedParamJdbcTemplate
	 * 可以使用具名参数
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		
		String sql = "INSERT INTO employee(emp_name, dept_no) VALUES (:name, :dno)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", "GGG");
		paramMap.put("dno", 1);
		namedParameterJdbcTemplate.update(sql, paramMap);
		
	}
	
	/*
	 * 使用 bean 对象赋值给具名参数
	 */
	@Test
	public void testByObject() {
		
		String sql = "INSERT INTO employee(emp_name, dept_no) VALUES (:empName, :deptNo)";
		
		Employee employee = new Employee();
		employee.setEmpName("abc");
		employee.setDeptNo(3);
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);
		
	}
	
}
