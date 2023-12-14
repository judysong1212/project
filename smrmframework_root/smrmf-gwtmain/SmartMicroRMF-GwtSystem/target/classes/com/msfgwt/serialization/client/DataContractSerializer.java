package com.msfgwt.serialization.client;



public interface DataContractSerializer {
	public <T extends Object> T deserializeObject(String json, Class<T> clazz);
	public String serializeObject(Object object);
	
}
