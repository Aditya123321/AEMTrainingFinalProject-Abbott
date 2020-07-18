//MODEL FOR STORY CARD COMPONENT
package com.trainingproject.abott.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.trainingproject.abott.core.service.ExtractDataService;

/**
 * @author sanket.sinha
 *
 */
@Model(
        adaptables = {Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class StoryCardModel {

	// INJECTING PROPERTIES TO THE COMPONENT
	@Inject	
	protected String storyUrl;
	@SlingObject
	private ResourceResolver request;

	// INJECTING EXTRACT DATA SERVICE TO THE COMPONENT
	@Inject
	private ExtractDataService extract;

	// ADDING DATA NEEDED FOR THE COMPONENT
	private String title;

	private String name;

	private String image;

	private String description;

	private String likes;

	private String views;

	private List<String> tags = new ArrayList<>();

	// CALLING SETTER METHODS AT INITIALISATION
	@PostConstruct
	protected void init() {
		setTags();
	}

	// SETTERS AND GETTERS FOR THE PROPERTIES AND DATA
	/**
	 * @return the storyUrl
	 */
	public String getStoryUrl() {
		return storyUrl;
	}

	/**
	 * @param storyUrl the storyUrl to set
	 */
	public void setStoryUrl(String storyUrl) {
		this.storyUrl = storyUrl;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		title = extract.extractTitle(storyUrl,request);
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		name = extract.extractData(storyUrl, "name",request);
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		image = extract.extractImage(storyUrl,request);
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		description = extract.extractData(storyUrl,"description",request);
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the likes
	 */
	public String getLikes() {
		likes = extract.extractData(storyUrl,"likes",request);
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(String likes) {
		this.likes = likes;
	}

	/**
	 * @return the views
	 */
	public String getViews() {
		views = extract.extractData(storyUrl,"views",request);
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void setViews(String views) {
		this.views = views;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags() {
		String tagData = extract.extractData(storyUrl, "tags",request);
		String[] totalTags = tagData.split(",");
		for (int i = 0; i < totalTags.length; i++)
			tags.add(totalTags[i]);
	}
}
