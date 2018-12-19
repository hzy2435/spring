package com.hzy.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.StatViewFilter;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringDataJpa {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druid() {
		
		DruidDataSource druidds = new DruidDataSource();
		
		return druidds;
	}
	
	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet() {
		
		ServletRegistrationBean<StatViewServlet> servletBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
		Map<String, String> params = new HashMap<>();
		params.put("loginUsername", "admin");
		params.put("loginPassword", "123456");
		params.put("allow", "");
		params.put("deny", "33.31.51.88");
		servletBean.setInitParameters(params);
		
		return servletBean;
	}
	
	public FilterRegistrationBean<StatViewFilter> statViewFilter() {
		
		FilterRegistrationBean<StatViewFilter> filterBean = new FilterRegistrationBean<>();
		filterBean.setFilter(new StatViewFilter());
		filterBean.addUrlPatterns("/*");
		
		Map<String, String> param = new HashMap<>();
		// 排除静态资源
		param.put("exclusions", "*.png,*.woff,*.js,*.css, /druid/*");
		filterBean.setInitParameters(param);
		
		return filterBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa.class, args);
	}
}
