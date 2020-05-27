package com.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppListeners implements HttpSessionListener {

	public AppListeners() {
		// TODO Auto-generated constructor stub
	}

	public void sessionCreated(HttpSessionEvent se) {

		System.out.println(se.getSession().getCreationTime());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(se.getSession().isNew());
	}

}
