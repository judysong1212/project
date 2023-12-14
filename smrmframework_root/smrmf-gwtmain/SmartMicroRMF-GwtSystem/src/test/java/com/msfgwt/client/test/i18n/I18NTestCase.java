package com.msfgwt.client.test.i18n;

import com.google.gwt.core.client.GWT;
import com.msfgwt.client.test.common.MsfGwtTestCase;
import com.msfgwt.reflection.client.ClassType;
import com.msfgwt.reflection.client.Method;
import com.msfgwt.reflection.client.TypeOracle;

public class I18NTestCase extends MsfGwtTestCase{

	@Override
  public String getModuleName() {
    return "com.msfgwt.client.test.i18n.I18N";
  }

  public void testMessageReflection(){
  	ErrorMessages errorMessages = GWT.create(ErrorMessages.class);
  	
  	//ClassType type = TypeOracle.Instance.getClassType(ErrorMessages.class);
  	ClassType type = TypeOracle.Instance.getClassType(errorMessages.getClass());
  	assertTrue(type.getMethods().length == 1);
  	
  	Method permissionDenied = type.findMethod("permissionDenied", new String[]{"java.lang.String", "java.lang.String", "java.lang.String"});
  	String result = (String)permissionDenied.invoke(errorMessages, "James", "guest", "delete");
  	assertTrue(result.equals(errorMessages.permissionDenied("James", "guest", "delete")));
  }
  
}
