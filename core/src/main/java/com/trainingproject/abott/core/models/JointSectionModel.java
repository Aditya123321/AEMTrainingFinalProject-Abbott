package com.trainingproject.abott.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public interface JointSectionModel {
	// INJECTING AND SETTING GETTER METHOD FOR SECTION TITLE
	@Inject
	String getJstitle();

	// INJECTING AND SETTING GETTER METHOD FOR SECTION DESCRIPTION
	@Inject
	String getDesc();

	// INJECTING AND SETTING GETTER METHOD FOR BUTTON TEXT
	@Inject
	String getButtontext();

	// INJECTING AND SETTING GETTER METHOD FOR BUTTON LINK
	@Inject
	String getButtonlink();

	// INJECTING AND SETTING GETTER METHOD FOR TAG TITLE
	@Inject
	String getTagtitle();

	// INJECTING AND SETTING GETTER METHOD FOR LIST OF TAGS
	@Inject
	List<TagNameList> getTag();
}