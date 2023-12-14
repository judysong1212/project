package com.msfgwt.test.gen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import junit.framework.TestCase;

import org.aspectj.lang.annotation.Aspect;

import com.msfgwt.gen.GenUtils;
import com.msfgwt.reflection.client.Reflectable;

public class TestGenUtils extends TestCase {

  @Reflectable
  public class A {
    
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Reflectable
  public @interface MyReflectionable {

  }
  
  @MyReflectionable
  @Aspect
  public class B{
    
  }
  
  public void testGetClassTypeAnnotationWithMataAnnotation(){
    Reflectable result = GenUtils.getAnnotationFromAnnotation(B.class.getAnnotation(MyReflectionable.class), Reflectable.class);
    
    assertTrue(result != null);
    
    result = GenUtils.getAnnotationFromAnnotation(B.class.getAnnotation(Aspect.class), Reflectable.class);
    assertTrue(result == null);
  }
  
}
