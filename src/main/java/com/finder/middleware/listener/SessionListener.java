package com.finder.middleware.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("======== sessionCreated ===========");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("======== sessionDestroyed ===========");
	}
}
