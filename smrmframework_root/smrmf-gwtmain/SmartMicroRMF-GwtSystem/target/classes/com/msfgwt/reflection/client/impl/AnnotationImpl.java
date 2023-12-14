package com.msfgwt.reflection.client.impl;

import java.lang.annotation.Annotation;

/**
 * 
 * @author JamesLuo.au@gmail.com
 *
 */
public abstract class AnnotationImpl<T extends Annotation> implements java.lang.annotation.Annotation {
	
	private final Class<T> clazz;
	
	public AnnotationImpl(Class<T> clazz){
		this.clazz = clazz;
	}

	public Class<T> annotationType() {
		return clazz;
		
	}

}
