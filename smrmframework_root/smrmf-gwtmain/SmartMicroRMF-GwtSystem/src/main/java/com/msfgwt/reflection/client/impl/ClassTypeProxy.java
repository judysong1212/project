package com.msfgwt.reflection.client.impl;

import java.lang.annotation.Annotation;

import com.msfgwt.reflection.client.AnnotationType;
import com.msfgwt.reflection.client.ArrayType;
import com.msfgwt.reflection.client.ClassType;
import com.msfgwt.reflection.client.Constructor;
import com.msfgwt.reflection.client.EnumType;
import com.msfgwt.reflection.client.Field;
import com.msfgwt.reflection.client.FieldIllegalAccessException;
import com.msfgwt.reflection.client.Method;
import com.msfgwt.reflection.client.MethodInvokeException;
import com.msfgwt.reflection.client.ParameterizedType;
import com.msfgwt.reflection.client.PrimitiveType;
import com.msfgwt.reflection.client.ReflectionRequiredException;
import com.msfgwt.reflection.client.Type;

public abstract class ClassTypeProxy<T> implements ClassType<T> {

	protected ClassType<?> classType = null;


	public Constructor<T> findConstructor(String... paramTypes) {
		return (Constructor<T>) classType.findConstructor(paramTypes);
	}

	public Field findField(String name) {
		return classType.findField(name);
	}

	public Method findMethod(String name, Class<?>... paramTypes) {
		return classType.findMethod(name, paramTypes);
	}

	public Method findMethod(String name, Type[] paramTypes) {
		return classType.findMethod(name, paramTypes);
	}

	public Method findMethod(String name, String[] paramTypes) {
		return classType.findMethod(name, paramTypes);
	}

	public Class<T> getDeclaringClass() {
		return (Class<T>) classType.getDeclaringClass();
	}

	public Field getField(String name) {
		return classType.getField(name);
	}

	public Object getFieldValue(Object instance, String fieldName)
			throws FieldIllegalAccessException {
		return classType.getFieldValue(instance, fieldName);
	}

	public Field[] getFields() {
		return classType.getFields();
	}

	public ClassType<?>[] getImplementedInterfaces()
			throws ReflectionRequiredException {
		return classType.getImplementedInterfaces();
	}

	public Method getMethod(String name, Type[] paramTypes) {
		return classType.getMethod(name, paramTypes);
	}

	public Method[] getMethods() {
		return classType.getMethods();
	}

	public String getName() {
		return classType.getName();
	}

	public ClassType<? super T> getSuperclass()
			throws ReflectionRequiredException {
		return (ClassType<? super T>) classType.getSuperclass();
	}

	public Object invoke(Object instance, String methodName, Object... args)
			throws MethodInvokeException {
		return classType.invoke(instance, methodName, args);
	}

	public void setFieldValue(Object instance, String fieldName, Object value)
			throws FieldIllegalAccessException {
		classType.setFieldValue(instance, fieldName, value);

	}

	public void addAnnotation(ClassType<? extends Annotation> type,AnnotationValues ann) {
		//classType.addAnnotation(type,ann);
	}
	public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
		return classType.getAnnotation(annotationClass);
	}

	public Annotation[] getAnnotations() {
		return classType.getAnnotations();
	}

	public Annotation[] getDeclaredAnnotations() {
		return classType.getDeclaredAnnotations();
	}

	public boolean isAnnotationPresent(
			Class<? extends Annotation> annotationClass) {
		return classType.isAnnotationPresent(annotationClass);
	}

	public String getParameterizedQualifiedSourceName() {
		return classType.getParameterizedQualifiedSourceName();
	}

	public String getQualifiedSourceName() {
		return classType.getQualifiedSourceName();
	}

	public String getSimpleSourceName() {
		return classType.getSimpleSourceName();
	}

	public AnnotationType isAnnotation() {
		return classType.isAnnotation();
	}

	public ArrayType isArray() {
		return classType.isArray();
	}

	public ClassType isClass() {
		return classType.isClass();
	}

	public ClassType isClassOrInterface() {
		return classType.isClassOrInterface();
	}

	public EnumType isEnum() {
		return classType.isEnum();
	}

	public ClassType isInterface() {
		return classType.isInterface();
	}

	public ParameterizedType isParameterized() {
		return classType.isParameterized();
	}

	public PrimitiveType isPrimitive() {
		return classType.isPrimitive();
	}

}
