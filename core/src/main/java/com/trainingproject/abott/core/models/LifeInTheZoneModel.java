//MODEL FOR LIFE IN THE ZONE COMPONENT
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
public class LifeInTheZoneModel {

	// INJECTING PROPERTIES TO THE COMPONENT
	@Inject
	@Optional
	protected String title;

	@Inject
	@Optional
	protected String subtitle;

	@Inject
	@Optional
	protected String buttonLabel;

	@Inject
	@Optional
	protected String buttonLink;

	@Inject
	@Required
	@Default(values = "#009cde")
	protected String bgColor;

	// SETTERS AND GETTERS FOR THE PROPERTIES
	/**
	 * @return the bgColor
	 */
	public String getBgColor() {
		return bgColor;
	}

	/**
	 * @param bgColor the bgColor to set
	 */
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
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

}
