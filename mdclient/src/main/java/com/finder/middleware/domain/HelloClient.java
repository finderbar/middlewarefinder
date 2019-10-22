package com.finder.middleware.domain;

import com.finder.middleware.annotation.MethodAnnotation;

public class HelloClient {
	@MethodAnnotation(value="Simple custom  Annotation example")
	public void say() {
		System.out.println("hello world!");
	}
}
