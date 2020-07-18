//MODEL FOR HOME CAROUSEL COMPONENT
package com.trainingproject.abott.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

/**
 * @author sanket.sinha
 *
 */
@Model(adaptables = Resource.class)
public class HomeCarouselModel {

	// INJECTING PROPERTIES AND MULTIFIELD TO THE COMPONENT
	@Inject
	@Optional
	protected String title;

	@Inject
	@Optional
	protected String subtitle;

	@Optional
	@ChildResource(name = "carouselItem")
	protected List<CarouselItem> carouselItem;

	// SETTERS AND GETTERS FOR THE PROPERTIES
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
	 * @return the carouselItem
	 */
	public List<CarouselItem> getCarouselItem() {
		return carouselItem;
	}

	/**
	 * @param carouselItem the carouselItem to set
	 */
	public void setCarouselItem(List<CarouselItem> carouselItem) {
		this.carouselItem = carouselItem;
	}

}
