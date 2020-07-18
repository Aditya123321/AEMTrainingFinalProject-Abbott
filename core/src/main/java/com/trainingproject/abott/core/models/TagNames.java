package com.trainingproject.abott.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= {Resource.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TagNames {

	@Inject
	@Named("jcr:title")
	private String tagName;
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	

	public String getTagName() {
		return tagName;
	}

	
	
}
