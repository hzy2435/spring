package com.springmvc.user.common;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.springmvc.user.entities.Address;

/*
 * 属性编辑器类
 */
public class AddressPropertyEditor extends PropertyEditorSupport {

	public AddressPropertyEditor() {
	}
	
	@Override
	public String getAsText() {
		
		Address address = (Address) getValue();
		
		return "[" + address.getProvince() + "," + address.getCity() + "]";
		
	}
	
	@Override
	public void setAsText(String text) {
		
		Pattern pattern = Pattern.compile("\\[(.*),(.*)\\]");
		Matcher matcher = pattern.matcher(text);
		
		if(matcher.matches()) {
			
			String province = matcher.group(0);
			String city = matcher.group(1);
			
			Address address = new Address();
			address.setCity(city);
			address.setProvince(province);
			
			setValue(address);
			
		}
		
	}
	
}
