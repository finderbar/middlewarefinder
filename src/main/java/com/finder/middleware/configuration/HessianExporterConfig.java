package com.finder.middleware.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.finder.middleware.annotation.RMIServiceType;

import java.lang.annotation.Annotation;
import java.util.Properties;

public class HessianExporterConfig implements ApplicationContextAware, BeanPostProcessor {
	private static ApplicationContext context;
	private static DefaultBeanNameGenerator nameGenerator = new DefaultBeanNameGenerator();

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		final ConfigurableApplicationContext configContext = (ConfigurableApplicationContext) this.context;
		final BeanDefinitionRegistry registry = (BeanDefinitionRegistry) configContext.getBeanFactory();
		Annotation[] annotations = bean.getClass().getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(HessianExporterConfig.class)) {
				String exportName = registerHessianServiceExporter(registry, (RMIServiceType) annotation, bean);
				registerMapping(registry, (RMIServiceType) annotation, exportName);
			}
		}
		return bean;
	}

	private String registerHessianServiceExporter(BeanDefinitionRegistry registry, RMIServiceType annotation,
			Object bean) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(HessianServiceExporter.class);
		AbstractBeanDefinition abd = builder.getRawBeanDefinition();

		MutablePropertyValues values = new MutablePropertyValues();
		values.add("service", bean);
		Class classType = annotation.serviceInterface();
		values.add("serviceInterface", classType);
		abd.setPropertyValues(values);

		String exporterName = annotation.name();
		if (StringUtils.isEmpty(exporterName)) {
			exporterName = nameGenerator.generateBeanName(abd, registry);
		}
		registry.registerBeanDefinition(exporterName, builder.getRawBeanDefinition());

		return exporterName;
	}

	private void registerMapping(BeanDefinitionRegistry registry, RMIServiceType annotation, String exportName) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(SimpleUrlHandlerMapping.class);
		AbstractBeanDefinition abd = builder.getRawBeanDefinition();

		MutablePropertyValues values = new MutablePropertyValues();
		Properties mappings = new Properties();
		mappings.setProperty(annotation.requestUrl(), exportName);

		values.add("mappings", mappings);
		abd.setPropertyValues(values);

		String mappingName = nameGenerator.generateBeanName(abd, registry);
		registry.registerBeanDefinition(mappingName, builder.getRawBeanDefinition());
	}

}
