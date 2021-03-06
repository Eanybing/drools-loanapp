package com.zyngl.drools.junit;

import org.junit.After;
import org.junit.Before;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public abstract class BaseDroolsTestCase {
	private static KieContainer kContainer;
	protected KieSession knowledgeSession;
	private String sessionName;
	
	public BaseDroolsTestCase(String sessionName) { 
		this.sessionName = sessionName;
        KieServices ks = KieServices.Factory.get();
        kContainer = ks.getKieClasspathContainer(); 
	}
	
	@Before
	public void setUp() throws Exception {
		knowledgeSession = kContainer.newKieSession(sessionName);
	}
	
	@After
	public void tearDown() throws Exception {
		knowledgeSession.dispose();
	}
}
