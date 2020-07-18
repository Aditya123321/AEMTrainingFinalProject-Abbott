package com.trainingproject.abott.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public interface BannerModel {

	// INJECTING AND SETTING GETTER METHOD FOR IMAGE REFERENCE
	@Inject
	String getFileReference();

	// INJECTING AND SETTING GETTER METHOD FOR BANNER TITLE
	@Inject
	String getTitle();
}