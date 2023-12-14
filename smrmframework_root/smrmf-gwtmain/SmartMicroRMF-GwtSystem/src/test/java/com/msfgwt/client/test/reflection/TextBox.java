package com.msfgwt.client.test.reflection;

import com.msfgwt.reflection.client.Reflectable;

@Reflectable(relationTypes=false, superClasses=true, assignableClasses=true)
public class TextBox extends com.google.gwt.user.client.ui.TextBox{
	
	public String getSomething(){
		return this.getName();
	}
	
} 
