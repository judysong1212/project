package com.msfgwt.reflection.client;


public interface EnumType<T> extends ClassType<T> {
	public EnumConstant[] getEnumConstants();
}
