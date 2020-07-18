//MODEL FOR STORY CAROUSEL COMPONENT
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
public class StoryCarouselModel {

	// INJECTING PROPERTIES AND MULTIFIELDS TO THE COMPONENT
	@Inject
	@Optional
	protected String title;

	@Inject
	@Optional
	protected String subtitle;

	@Optional
	@ChildResource(name = "carouselStory")
	protected List<CarouselStory> carouselStory;

	// SETTERS AND GETTERS FOR PROPERTIES AND MULTIFIELD
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
	 * @return the carouselStory
	 */
	public List<CarouselStory> getCarouselStory() {
		return carouselStory;
	}

	/**
	 * @param carouselStory the carouselStory to set
	 */
	public void setCarouselStory(List<CarouselStory> carouselStory) {
		this.carouselStory = carouselStory;
	}

}
