package com.msfgwt.client.test.common.annotations;

import com.msfgwt.client.test.common.MsfGwtTestCase;

public class AnnotationTestCase extends MsfGwtTestCase{
	
	@Override
  public String getModuleName() {
    return "com.msfgwt.client.test.common.Common";
  }
	
	public void testAnnotation(){
		UniqueConstraint u = new UniqueConstraintImpl();
		assertTrue(u.columnNames().length == 2);
	}
}
