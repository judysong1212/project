package com.msfgwt.gen.reflection.vistors;

import com.google.gwt.core.ext.typeinfo.JAnnotationType;
import com.google.gwt.core.ext.typeinfo.JArrayType;
import com.google.gwt.core.ext.typeinfo.JEnumType;
import com.google.gwt.core.ext.typeinfo.JGenericType;
import com.google.gwt.core.ext.typeinfo.JParameterizedType;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JRawType;
import com.google.gwt.core.ext.typeinfo.JTypeParameter;
import com.google.gwt.core.ext.typeinfo.JWildcardType;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JArrayTypeVistor;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JEnumTypeVisitor;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JGenericTypeVisitor;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JParameterizedTypeVisitor;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JRawTypeVisitor;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JTypeParameterVisitor;
import com.msfgwt.gen.reflection.vistors.TypesVisitor.JWildcardTypeVisitor;

/**
 * 
 * @author James Luo
 *
 * 20/08/2010 4:05:47 PM
 */
public interface TypeVisitor {
		
	/**
	 * return null if this visitor don't care
	 * @param type
	 * @return
	 */
	JPrimitiveTypeVisitor visitPrimitiveType(JPrimitiveType type);
	
	JArrayTypeVistor visitArrayType(JArrayType type);
	
  JTypeParameterVisitor visitTypeParameter(JTypeParameter type);
	
	JWildcardTypeVisitor visitWildcardType(JWildcardType type);
	
	JParameterizedTypeVisitor visitParameterizedType(JParameterizedType type);
	
	JRawTypeVisitor visitRawType(JRawType type);
	
	JAnnotationTypeVisitor visitAnnotationType(JAnnotationType type);
	
	JEnumTypeVisitor visitEnumType(JEnumType type);
	
	JGenericTypeVisitor visitGenericType(JGenericType type);
	
}
