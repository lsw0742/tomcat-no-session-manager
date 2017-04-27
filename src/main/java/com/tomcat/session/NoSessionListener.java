package com.tomcat.session;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class NoSessionListener implements HttpSessionAttributeListener{

	private ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		threadLocal.set(se.getName());
		se.getSession().removeAttribute(se.getName());		
		throw new UnsupportedOperationException("NoSessionManager Managed Session Unsupport [attributeAdded].");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		if(se.getName().equals(threadLocal.get())){
			threadLocal.remove();
			return;
		}
		throw new UnsupportedOperationException("NoSessionManager Managed Session Unsupport [attributeRemoved].");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		throw new UnsupportedOperationException("NoSessionManager Managed Session Unsupport [attributeReplaced].");
	}

}
