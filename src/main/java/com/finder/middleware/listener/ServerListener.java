package com.finder.middleware.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public class ServerListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("======== ServletContextListener DESTROYED ===========");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("======== ServletContextListener Inital ===========");
	}
}
