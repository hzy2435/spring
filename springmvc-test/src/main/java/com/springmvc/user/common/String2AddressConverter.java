package com.springmvc.user.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

import com.springmvc.user.entities.Address;

/*
 * 自定义转换器
 */
public class String2AddressConverter implements Converter<String, Address>{

	@Override
	public Address convert(String source) {

		Pattern pattern = Pattern.compile("\\[(.*),(.*)\\]");
		Matcher matcher = pattern.matcher(source);
		
		if(matcher.matches()) {
			String province = matcher.group(0);
			String city = matcher.group(1);
			
			Address address = new Address();
			address.setProvince(province);
			address.setCity(city);
			
			return address;
		} else {
			throw new RuntimeException("地址转换失败.");
		}
		
	}

}
