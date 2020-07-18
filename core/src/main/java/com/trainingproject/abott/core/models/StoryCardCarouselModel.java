//MODEL FOR STORY CARD CAROUSEL COMPONENT
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
public class StoryCardCarouselModel {

	// INJECTING PROPERTIES TO THE COMPONENT
	@Inject
	@Optional
	protected String title;

	@Optional
	@ChildResource(name = "cardStory")
	protected List<CarouselStory> cardStory;

	@Optional
	@ChildResource(name = "carouselCard")
	protected List<CarouselCard> carouselCard;

	// SETTERS AND GETTERS FOR THE PROPERTIES
	/**
	 * @return the carouselCard
	 */
	public List<CarouselCard> getCarouselCard() {
		return carouselCard;
	}

	/**
	 * @param carouselCard the carouselCard to set
	 */
	public void setCarouselCard(List<CarouselCard> carouselCard) {
		this.carouselCard = carouselCard;
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
	 * @return the cardStory
	 */
	public List<CarouselStory> getCardStory() {
		return cardStory;
	}

	/**
	 * @param cardStory the cardStory to set
	 */
	public void setCardStory(List<CarouselStory> cardStory) {
		this.cardStory = cardStory;
	}

}
