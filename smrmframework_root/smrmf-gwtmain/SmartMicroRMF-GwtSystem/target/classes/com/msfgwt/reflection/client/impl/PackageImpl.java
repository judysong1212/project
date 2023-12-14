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


package com.msfgwt.reflection.client.impl;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.msfgwt.reflection.client.ClassType;
import com.msfgwt.reflection.client.HasAnnotations;
import com.msfgwt.reflection.client.NotFoundException;
import com.msfgwt.reflection.client.Package;


public class PackageImpl implements HasAnnotations, Package {

  private final Annotations annotations = new Annotations();
	  private final String name;

	  private final Map types = new HashMap();

	  public PackageImpl(String name) {
	    this.name = name;
	  }

	  /* (non-Javadoc)
	 * @see com.msfgwt.client.reflection.Package#findType(java.lang.String)
	 */
	public ClassType findType(String typeName) {
	    String[] parts = typeName.split("\\.");
	    return findType(parts);
	  }

	  /* (non-Javadoc)
	 * @see com.msfgwt.client.reflection.Package#findType(java.lang.String[])
	 */
	public ClassType findType(String[] typeName) {
	    return findTypeImpl(typeName, 0);
	  }

	  /* (non-Javadoc)
	 * @see com.msfgwt.client.reflection.Package#getName()
	 */
	public String getName() {
	    return name;
	  }

	  /* (non-Javadoc)
	 * @see com.msfgwt.client.reflection.Package#getType(java.lang.String)
	 */
	public ClassType getType(String typeName) {
	    ClassType result = findType(typeName);
	    if (result == null) {
	      throw new NotFoundException();
	    }
	    return result;
	  }

	  /* (non-Javadoc)
	 * @see com.msfgwt.client.reflection.Package#getTypes()
	 */
	public ClassType[] getTypes() {
	    return (ClassType[]) types.values().toArray(TypeOracleImpl.NO_JCLASSES);
	  }

	  /* (non-Javadoc)
	 * @see com.msfgwt.client.reflection.Package#isDefault()
	 */
	public boolean isDefault() {
	    return "".equals(name);
	  }

	  public String toString() {
	    return "package " + name;
	  }

	  void addType(ClassTypeImpl type) {
	    types.put(type.getSimpleSourceName(), type);
	  }

	  ClassType findTypeImpl(String[] typeName, int index) {
	    ClassTypeImpl found = (ClassTypeImpl) types.get(typeName[index]);
	    if (found == null) {
	      return null;
	    } else if (index < typeName.length - 1) {
	      return found.findNestedTypeImpl(typeName, index + 1);
	    } else {
	      return found;
	    }
	  }

	  void remove(ClassTypeImpl type) {
	    Object removed = types.remove(type.getSimpleSourceName());
	    // JDT will occasionally remove non-existent items, such as packages.
	  }
	  
	  public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
	    return annotations.getAnnotation(annotationClass);
	  }
	  
	  public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
	    return annotations.isAnnotationPresent(annotationClass);
	  }
	  
	  /**
	   * NOTE: This method is for testing purposes only.
	   */
	  public Annotation[] getAnnotations() {
	    return annotations.getAnnotations();
	  }

	  /**
	   * NOTE: This method is for testing purposes only.
	   */
	  public Annotation[] getDeclaredAnnotations() {
	    return annotations.getDeclaredAnnotations();
	  }

		public void addAnnotation(Annotation ann) {
			annotations.addAnnotation(ann);
		}
}
