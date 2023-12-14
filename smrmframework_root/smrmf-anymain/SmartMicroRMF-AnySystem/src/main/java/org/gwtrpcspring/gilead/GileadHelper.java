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
package org.gwtrpcspring.gilead;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.TransientObjectException;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.core.beanlib.mapper.ProxyClassMapper;
import net.sf.gilead.core.store.stateful.HttpSessionProxyStore;
import net.sf.gilead.exception.NotAssignableException;
import net.sf.gilead.proxy.AdditionalCodeManager;
import net.sf.gilead.proxy.ProxyClassLoader;

/**
 * Static helper class for PersistentRemoteService and
 * HibernateRPCServiceExporter (GWT-SL)
 * 
 * @author bruno.marchesson
 * 
 */
public class GileadHelper {
	// ----
	// Attributes
	// ----
	/**
	 * The log channel
	 */
	private static Log log = LogFactory.getLog(GileadHelper.class);

	// -------------------------------------------------------------------------
	//
	// Public interface
	//
	// -------------------------------------------------------------------------
	/**
	 * Proxy class loader initialisation
	 */
	public static void initClassLoader() {
		// Set Proxy class loader (privileged code needed)
		//
		ClassLoader contextClassLoader = Thread.currentThread()
				.getContextClassLoader();
		if (contextClassLoader instanceof ProxyClassLoader == false) {
			log.info("Setting proxy class loader for thread "
					+ Thread.currentThread());

			// initialize AdditionalCodeManager before changing class loader to
			// prevent stack overflow
			//
			AdditionalCodeManager.getInstance();

			Thread.currentThread().setContextClassLoader(
					new ProxyClassLoader(contextClassLoader));
		}
	}

	/**
	 * Parse RPC input parameters. Must be called before GWT service invocation.
	 * 
	 * @param rpcRequest
	 *            the input GWT RPC request
	 * @param beanManager
	 *            the Hibernate bean manager
	 * @param session
	 *            the HTTP session (for HTTP Pojo store)
	 */
	public static void parseInputParameters(Object[] parameters,
			PersistentBeanManager beanManager, HttpSession session) {
		// Init classloader for proxy mode
		//
		if (beanManager.getClassMapper() instanceof ProxyClassMapper) {
			initClassLoader();
		}

		// Set HTTP session of Pojo store in thread local
		//
		HttpSessionProxyStore.setHttpSession(session);

		// Merge parameters if needed
		//
		if (parameters != null) {
			for (int index = 0; index < parameters.length; index++) {
				if (parameters[index] != null) {
					try {
						parameters[index] = beanManager.merge(
								parameters[index], true);
					} catch (NotAssignableException ex) {
						log.debug(parameters[index] + " not assignable");
					} catch (TransientObjectException ex) {
						log.info(parameters[index]
								+ " is transient : cannot merge...");
					}
				}
			}
		}
	}

	/**
	 * Clone the service result. Must be called after successful service
	 * invocation
	 * 
	 * @param returnValue
	 *            the service return value
	 * @param beanManager
	 *            the Hibernate bean manager
	 * @return the cloned service value
	 */
	public static final Object parseReturnValue(Object returnValue,
			PersistentBeanManager beanManager) {
		// Clone if needed
		//
		if (returnValue != null) {
			try {
				returnValue = beanManager.clone(returnValue, true);
			} catch (NotAssignableException ex) {
				log.debug(returnValue + " not assignable");
			} catch (TransientObjectException ex) {
				log.info(returnValue + " is transient : cannot clone...");
			} finally {
				beanManager.getProxyStore().cleanUp();
			}
		}

		// Remove HTTP session of Pojo store thread local
		//
		HttpSessionProxyStore.setHttpSession(null);

		return returnValue;
	}
}
