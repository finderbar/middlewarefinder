package com.finder.middleware;

import java.lang.reflect.Method;

import com.finder.middleware.annotation.MethodAnnotation;
import com.finder.middleware.domain.HelloClient;

public class AnnotationDemo {

	public static void main(String[] args) throws Exception {
		
		/* START METHOD ANNOTATION */
		HelloClient hello = new HelloClient();
		Method method = hello.getClass().getMethod("say");
		if (method.isAnnotationPresent(MethodAnnotation.class)) {
			MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
			System.out.println("Value : " + annotation.value());
			method.invoke(hello);
		}
		/* END METHOD ANNOTATION */
		
	
	
	
	
	
	}

}
