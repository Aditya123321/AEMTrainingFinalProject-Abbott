package com.trainingproject.abott.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = Resource.class)
public class ModalPage2Model {

	// INJECTING AND SETTING GETTER METHOD FOR MODAL PAGE TITLE
	@Inject
	String getFormtitle;
	// INJECTING AND SETTING GETTER METHOD FOR MODAL PAGE BACK BUTTON LABEL
	@Inject
	String getBacklabel;
	// INJECTING AND SETTING GETTER METHOD FOR MODAL PAGE BACK BUTTON LINK
	@Inject
	String getBacklink;
	// INJECTING AND SETTING GETTER METHOD FOR MODAL PAGE SUBMIT BUTTON LABEL
	@Inject
	String getSubmitlabel;
	// INJECTING AND SETTING GETTER METHOD FOR MODAL PAGE SUBMIT BUTTON LINK
	@Inject
	String getSubmitlink;
	// INJECTING AND SETTING GETTER METHOD FOR MODAL PAGE IMAGE UPLOAD REFERENCE
	@Inject
	String getBrowseupload;

}