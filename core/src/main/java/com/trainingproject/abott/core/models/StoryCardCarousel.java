package com.trainingproject.abott.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public interface StoryCardCarousel {
	// INJECTING AND SETTING GETTER METHOD FOR STORY CARD TITLE
	@Inject
	@Optional
	String getTitle();

	// INJECTING AND SETTING GETTER METHOD FOR CARD PATHS LIST
	@Inject
	@Optional
	List<StoryPaths> getStorypaths();

	// INJECTING AND SETTING GETTER METHOD FOR EXTERNAL STORY PATHS LIST
	@Inject
	@Optional
	List<ExternalPaths> getExternalstorypaths();

	public interface StoryPaths {
		// INJECTING AND SETTING GETTER METHOD FOR STORY PATH
		@Inject
		@Optional
		String getStorypath();

	}

	public interface ExternalPaths {
		// INJECTING AND SETTING GETTER METHOD FOR EXTERNAL STORY PATH SLIDE TITLE
		@Inject
		@Optional
		String getSlidetitle();

		// INJECTING AND SETTING GETTER METHOD FOR EXTERNAL STORY PATH SLIDE DESCRIPTION
		@Inject
		@Optional
		String getDescription();

		// INJECTING AND SETTING GETTER METHOD FOR EXTERNAL STORY PATH SLIDE IMAGE
		// REFERENCE
		@Inject
		@Optional
		String getBannerimg();

		// INJECTING AND SETTING GETTER METHOD FOR EXTERNAL STORY PATH SLIDE LINK
		@Inject
		@Optional
		String getExternallink();

	}

}
