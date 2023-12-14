/*******************************************************************************
 *  Copyright 2001, 2007 JamesLuo(JamesLuo.au@gmail.com)
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 * 
 *  Contributors:
 *******************************************************************************/


/**
 * FileName: AllTests.java
 * Date:			04/09/2008 3:47:02 PM
 * Author:		JamesLuo.au@gmail.com
 * purpose:
 * 
 * History:
 * 
 */


package com.msfgwt.client.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.tools.GWTTestSuite;
import com.msfgwt.client.test.allmodules.AllModulesTestCase;
import com.msfgwt.client.test.aop.AOPTestCase;
import com.msfgwt.client.test.common.CommonTestCase;
import com.msfgwt.client.test.common.annotations.AnnotationTestCase;
import com.msfgwt.client.test.i18n.I18NTestCase;
import com.msfgwt.client.test.json.SerializationTestCase;
import com.msfgwt.client.test.reflection.ClassTypeGenTestCase;
import com.msfgwt.client.test.reflection.ReflectionTestCase;

public class AllClientGWTTestSuite extends GWTTestSuite {

  public static Test suite() {
    TestSuite suite = new TestSuite("Test for com.msfgwt.client");
    //$JUnit-BEGIN$
    suite.addTestSuite(ClassTypeGenTestCase.class);
    suite.addTestSuite(ReflectionTestCase.class);
    
    suite.addTestSuite(CommonTestCase.class);
    suite.addTestSuite(I18NTestCase.class);
    suite.addTestSuite(AnnotationTestCase.class);
    suite.addTestSuite(SerializationTestCase.class);
    
    
    suite.addTestSuite(AOPTestCase.class);
    suite.addTestSuite(AllModulesTestCase.class);
    //$JUnit-END$
    return suite;
  }

}