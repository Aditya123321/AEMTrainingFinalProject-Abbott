package com.trainingproject.abott.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public interface ShareYourStoryBannerModel {
	// INJECTING AND SETTING GETTER METHOD FOR FONT COLOR
	@Inject
	String getFontcolor();

	// INJECTING AND SETTING GETTER METHOD FOR TEXT BACKGROUND COLOR
	@Inject
	String getTextbackgroundcolor();

	// INJECTING AND SETTING GETTER METHOD FOR BUTTON BACKGROUND COLOR
	@Inject
	String getButtonbackgroundcolor();

	// INJECTING AND SETTING GETTER METHOD FOR STORY DESCRIPTION
	@Inject
	String getDesc();
}