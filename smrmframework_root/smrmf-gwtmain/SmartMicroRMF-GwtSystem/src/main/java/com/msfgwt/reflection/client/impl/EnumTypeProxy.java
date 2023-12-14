package com.msfgwt.reflection.client.impl;

import java.lang.annotation.Annotation;

import com.msfgwt.reflection.client.EnumConstant;
import com.msfgwt.reflection.client.EnumType;


public class EnumTypeProxy<T> extends ClassTypeProxy<T> implements EnumType<T> {

	public EnumConstant[] getEnumConstants() {
		EnumType <?> t = (EnumType<?>) classType;
		return   t.getEnumConstants();
	}

	public void addAnnotation(Annotation ann) {
		// TODO Auto-generated method stub
		
	}

 
	 
}
