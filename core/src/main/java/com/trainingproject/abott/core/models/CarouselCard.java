//MODEL FOR CAROUSEL CARD COMPONENT
package com.trainingproject.abott.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

/**
 * @author sanket.sinha
 *
 */
@Model(adaptables = Resource.class)
public class CarouselCard {

	// INJECTING PROPERTIES TO THE COMPONENT
	@Inject
	@Optional
	protected String imageUrl;

	@Inject
	@Optional
	protected String cardTitle;

	@Inject
	@Optional
	protected String description;

	@Inject
	@Optional
	protected String cardLink;

	// SETTERS AND GETTERS FOR THE PROPERTIES
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the cardTitle
	 */
	public String getCardTitle() {
		return cardTitle;
	}

	/**
	 * @param cardTitle the cardTitle to set
	 */
	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

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
	 * @return the cardLink
	 */
	public String getCardLink() {
		return cardLink;
	}

	/**
	 * @param cardLink the cardLink to set
	 */
	public void setCardLink(String cardLink) {
		this.cardLink = cardLink;
	}
}
