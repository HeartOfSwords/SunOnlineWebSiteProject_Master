package com.sunonline.web.webapi.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class WebApiRoot {

	private List<WebApiLinks> links;

	public void setLinks(List<WebApiLinks> links) {
		this.links = links;
	}

	public List<WebApiLinks> getLinks() {
		return this.links;
	}
}
