package com.trainingproject.abott.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public interface LikeComponentModel {
	// INJECTING AND SETTING GETTER METHOD FOR LIKE LOGO
	@Inject
	String getLikelogo();

	// INJECTING AND SETTING GETTER METHOD FOR LIKE COUNT
	@Inject
	String getLikecount();

	// INJECTING AND SETTING GETTER METHOD FOR LIKE DESCRIPTION
	@Inject
	String getLikedesc();

	// INJECTING AND SETTING GETTER METHOD FOR LIKE TEXT
	@Inject
	String getLikedesc1();

	// INJECTING AND SETTING GETTER METHOD FOR IN THE ZONE LOGO
	@Inject
	String getInlogo();

	// INJECTING AND SETTING GETTER METHOD FOR IN THE ZONE COUNT
	@Inject
	String getIncount();

	// INJECTING AND SETTING GETTER METHOD FOR IN THE ZONE TEXT
	@Inject
	String getIndesc1();

	// INJECTING AND SETTING GETTER METHOD FOR IN THE ZONE DESCRIPTION
	@Inject
	String getIndesc2();

	// INJECTING AND SETTING GETTER METHOD FOR LIKE LOGO
	@Inject
	String getViewlogo();

	// INJECTING AND SETTING GETTER METHOD FOR VIEWS COUNT
	@Inject
	String getViewcount();

	// INJECTING AND SETTING GETTER METHOD FOR VIEWS DESCRIPTION
	@Inject
	String getViewdesc();

	// INJECTING AND SETTING GETTER METHOD FOR VIEWS TEXT
	@Inject
	String getViewdesc1();

}