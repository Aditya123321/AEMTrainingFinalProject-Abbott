//MODEL FOR LIFE IN THE ZONE CAROUSEL COMPONENT
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
public class LifeInTheZoneCaroruselModel {

	// INJECTING MULTIFIELD PROPERTIES TO THE COMPONENT
	@Inject
	@Optional
	protected Resource carouselItem;

	// SETTERS AND GETTERS FOR THE PROPERTIES
	/**
	 * @return the carouselItem
	 */
	public Resource getCarouselItem() {
		return carouselItem;
	}

	/**
	 * @param carouselItem the carouselItem to set
	 */
	public void setCarouselItem(Resource carouselItem) {
		this.carouselItem = carouselItem;
	}
}
