package org.gwtrpcspring.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EmptyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		return arg0;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		return arg0;
	}

}
