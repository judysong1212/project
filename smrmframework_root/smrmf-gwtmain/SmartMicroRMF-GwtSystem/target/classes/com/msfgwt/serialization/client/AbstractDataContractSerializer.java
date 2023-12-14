package com.msfgwt.serialization.client;

import com.msfgwt.reflection.client.ClassType;
import com.msfgwt.reflection.client.ReflectionUtils;
import com.msfgwt.reflection.client.TypeOracle;

public abstract class AbstractDataContractSerializer implements DataContractSerializer, DataContractReflectionSerializer{

	public <T extends Object> T deserializeObject(String json, Class<T> clazz) {
	  ReflectionUtils.checkReflection(clazz);
		ClassType type = TypeOracle.Instance.getClassType(clazz);
		return (T) deserializeObject(json, type);
	}
	
	protected abstract Object deserializeObject(String json, ClassType type);
	public abstract String serializeObject(Object object, ClassType type);

	public String serializeObject(Object object) {
	  ReflectionUtils.checkReflection(object.getClass());
	  ClassType type = TypeOracle.Instance.getClassType(object.getClass());
	  return serializeObject(object, type);
	}
}
