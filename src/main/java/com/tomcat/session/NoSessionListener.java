package com.tomcat.session;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class NoSessionListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		throw new UnsupportedOperationException("NoSessionManager Managed Session Unsupport [attributeAdded].");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		throw new UnsupportedOperationException("NoSessionManager Managed Session Unsupport [attributeRemoved].");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		throw new UnsupportedOperationException("NoSessionManager Managed Session Unsupport [attributeReplaced].");
	}

}
