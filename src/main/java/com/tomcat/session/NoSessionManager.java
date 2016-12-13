package com.tomcat.session;

import java.io.IOException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Session;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.session.ManagerBase;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class NoSessionManager extends ManagerBase {
	
	private final Log log = LogFactory.getLog(NoSessionManager.class);
	
	public NoSessionManager(){
		super();
		log.info(NoSessionManager.class.getName()+" created.");
	}
	
	public String getName() {
		return "NoSessionManager";
	}

	// ------------------
    @Override
    protected synchronized void startInternal() throws LifecycleException {
        super.startInternal();
        setState(LifecycleState.STARTING);
		((StandardContext)this.getContext()).addApplicationEventListener(new NoSessionListener());
    }
    
	// ------------------
	@Override
	public Session createSession(String sessionId) {
		return this.createNoSession(sessionId);
	}
	
	// ------------------
	@Override
	public void load() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
	}
	@Override
	public void unload() throws IOException {
		// TODO Auto-generated method stub		
	}
	
	// ------------------
	private static final String NO_SESSION_ID="NO@"+System.currentTimeMillis();
	private Session createNoSession(String sessionId){
		Session session=null;
				
		if(!sessions.isEmpty()){
			session=sessions.get(NO_SESSION_ID);
		}else{
			synchronized(this){
				if(sessions.isEmpty()){
					session=super.createSession(NO_SESSION_ID);
				}
			}			
		}		
		return session;		
	}
	// ------------------
}
