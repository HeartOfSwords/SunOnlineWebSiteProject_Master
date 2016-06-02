package com.sunonline.web.webapi.app;

import org.glassfish.jersey.server.ResourceConfig;
/**
 * webapi应用资源配置
 * @author SnoWalker.wwl
 * 2016.6.2
 */
public class Application extends ResourceConfig {
	
	public Application() {
		packages("com.sunonline.web.webapi.resource");
	}
}
