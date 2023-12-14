/*
 * Copyright 2009 Gordon Pike.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtrpcspring;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.SerializationPolicy;
import com.google.gwt.user.server.rpc.impl.ServerSerializationStreamReader;

/**
 * RemoteServiceDispatcher - extends the RemoteServiceServlet to recieve the rpc
 * request, look up the name of the interface being called, and find the unique
 * bean that implements the interface in the Spring context.
 * 
 * @author earmlta
 * 
 */
public class RemoteServiceDispatcher extends RemoteServiceServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7132243934574518263L;

	public RemoteServiceDispatcher() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.user.server.rpc.RemoteServiceServlet#processCall(java.
	 * lang.String)
	 */
	@Override
	public String processCall(String payload) throws SerializationException {
		try {
			String serviceIntfName = getInterfaceClassName(payload);
			RPCRequest rpcRequest = RPC.decodeRequest(payload, null, this);
			//RPCRequest rpcRequest = RPC.decodeRequest(payload, serviceIntfName.getClass(), this);
			onAfterRequestDeserialized(rpcRequest);
			Object service = getService(serviceIntfName);
         
			return invokeAndEncodeResponse(service, rpcRequest.getMethod(),
					rpcRequest.getParameters(), rpcRequest
							.getSerializationPolicy());
		} catch (IncompatibleRemoteServiceException ex) {
			log(
					"processCall 호출을 처리하는 동안 IncompatibleRemoteServiceException가 발생!.",
					ex);
			return RPC.encodeResponseForFailure(null, ex);
		}
	}

	/**
	 * Reads the payload looking for the interface class name.
	 * 
	 * @param payload
	 * @return
	 * @throws SerializationException
	 */
	private String getInterfaceClassName(String payload)
			throws SerializationException {
		ServerSerializationStreamReader streamReader = new ServerSerializationStreamReader(
				Thread.currentThread().getContextClassLoader(), this);
		streamReader.prepareToRead(payload);
		return streamReader.readString();
	}

	protected String invokeAndEncodeResponse(Object target,
			Method serviceMethod, Object[] args,
			SerializationPolicy serializationPolicy)
			throws SerializationException {

		RemoteServiceUtil.setThreadLocals(getThreadLocalRequest(),
				getThreadLocalResponse(), getServletContext(),getServletConfig());

		// Hook in case subclass needs to prepare
		onBeforeServiceCall(target);
		String response = RPC.invokeAndEncodeResponse(target, serviceMethod,
				args, serializationPolicy);
		// Hook in case subclass needs to cleanup
		onAfterServiceCall(target);

		RemoteServiceUtil.clearThreadLocals();

		return response;

	}

	/**
	 * getService will look in context for bean with name of interface. It also
	 * verifies the bean implements the given interface.
	 * 
	 * @param serviceInterfaceName
	 * @return
	 * @throws BeansException
	 * @throws ClassNotFoundException
	 */
	protected Object getService(String itfName) throws BeansException {
		try {
			Object service = BeanFactoryUtils.beanOfTypeIncludingAncestors(
					WebApplicationContextUtils
							.getWebApplicationContext(getServletContext()),
					Class.forName(itfName));
			return service;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Hook for sub classes to be able to prepare for call.
	 * 
	 * @param service
	 */
	protected void onBeforeServiceCall(Object service) {

	}

	/**
	 * Hook in case sub class needs to cleanup.
	 * 
	 * @param service
	 */
	protected void onAfterServiceCall(Object service) {

	}

}
