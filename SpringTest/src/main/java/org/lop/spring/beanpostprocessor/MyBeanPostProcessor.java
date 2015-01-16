package org.lop.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization( Object bean, String beanName ) throws BeansException {
		String content = String.format( "%s\n%s", bean.getClass().getName(), beanName );
		System.out.println( content );
		return bean;
	}

	public Object postProcessAfterInitialization( Object bean, String beanName ) throws BeansException {
		String content = String.format( "%s\n%s", bean.getClass().getName(), beanName );
		System.out.println( content );
		return bean;
	}

}