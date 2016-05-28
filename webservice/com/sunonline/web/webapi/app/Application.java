package com.sunonline.web.webapi.app;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
	
	public Application() {
		packages("com.sunonline.web.webapi.resource");
	}
}
