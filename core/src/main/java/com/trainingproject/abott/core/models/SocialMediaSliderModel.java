package com.trainingproject.abott.core.models;

/**
 * @author aditya.sharma
 *
 */
import java.util.List;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public interface SocialMediaSliderModel {
	// INJECTING AND SETTING GETTER METHOD FOR SOCIAL ITEMS LIST
	@Inject
	List<IconsList> getSocialmediaslider();

	// MARKING THE SOCIAL ITEMS LIST INTERFACE AS ADAPTABLE
	@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	public interface IconsList {
		// INJECTING AND SETTING GETTER METHOD FOR SOCIAL ICON LINK
		@Inject
		String getSocialmedialink();

		// INJECTING AND SETTING GETTER METHOD FOR SOCIAL ICON COLOR
		@Inject
		String getIconcolor();

		// INJECTING AND SETTING GETTER METHOD FOR SOCIAL ICON CLASS
		@Inject
		String getIconclass();
	}

}
