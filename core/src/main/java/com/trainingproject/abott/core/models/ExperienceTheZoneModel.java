//MODEL FOR EXPERIENCE THE ZONE COMPONENT
package com.trainingproject.abott.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;

/**
 * @author sanket.sinha
 *
 */
@Model(adaptables = Resource.class)
public class ExperienceTheZoneModel {

	// INJECTING PROPERTIES TO THE COMPONENT
	@Inject
	@Optional
	protected String description;

	@Inject
	@Optional
	protected String buttonLabel;

	@Inject
	@Optional
	protected String buttonLink;

	@Inject
	@Required
	@Default(values = "/content/abott/dam")
	protected String fileReference;

	@Inject
	@Required
	@Default(values = "heroImage")
	protected String alt;

	// SETTERS AND GETTERS FOR THE PROPERTIES
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the buttonLabel
	 */
	public String getButtonLabel() {
		return buttonLabel;
	}

	/**
	 * @param buttonLabel the buttonLabel to set
	 */
	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	/**
	 * @return the buttonLink
	 */
	public String getButtonLink() {
		return buttonLink;
	}

	/**
	 * @param buttonLink the buttonLink to set
	 */
	public void setButtonLink(String buttonLink) {
		this.buttonLink = buttonLink;
	}

	/**
	 * @return the fileReference
	 */
	public String getFileReference() {
		return fileReference;
	}

	/**
	 * @param fileReference the fileReference to set
	 */
	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}

	/**
	 * @return the alt
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * @param alt the alt to set
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}
}
