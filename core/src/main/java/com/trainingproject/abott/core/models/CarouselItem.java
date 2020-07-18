//CLASS FOR CAROUSEL ITEM MULTIFIELD
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
public class CarouselItem {

	// INJECTING PROPERTIES OF THE MULTIFIELD
	@Inject
	@Optional
	protected String image;

	@Inject
	@Optional
	protected String name;

	@Inject
	@Optional
	protected String description;

	@Optional
	@ChildResource(name = "tags")
	protected List<Tags> tags;

	// SETTERS AND GETTERS FOR THE MULTIFIELD
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the tags
	 */
	public List<Tags> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

}
