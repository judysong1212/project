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

import javax.annotation.PostConstruct;

import net.sf.gilead.core.PersistentBeanManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Gordon Pike
 * 
 */
@Aspect
public class GileadAdapterAdvice {
	private static Log log = LogFactory.getLog(GileadAdapterAdvice.class);

	@Autowired
	PersistentBeanManager beanManager;

	@Around("target(com.google.gwt.user.client.rpc.RemoteService) && execution(public * *(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		if (log.isDebugEnabled()) {
			String className = pjp.getSignature().getDeclaringTypeName();
			String methodName = className
					.substring(className.lastIndexOf(".") + 1)
					+ "." + pjp.getSignature().getName();
			log.debug("Wrapping call to " + methodName
					+ " for PersistentBeanManager");
		}
		GileadHelper.parseInputParameters(pjp.getArgs(), beanManager,
				RemoteServiceUtil.getThreadLocalSession());
		Object retVal = pjp.proceed(pjp.getArgs());
		retVal = GileadHelper.parseReturnValue(retVal, beanManager);

		return retVal;
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		if (beanManager == null)
			throw new Exception("PersistentBeanManager not set");
	}

}
