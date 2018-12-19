package com.springmvc.user.common;

import org.springframework.core.convert.converter.Converter;

import com.springmvc.user.entities.Address;

public class Address2StringConverter implements Converter<Address, String> {

	@Override
	public String convert(Address source) {
		return "[" + source.getProvince() + "," + source.getCity() + "]";
	}

}
