package com.trainingproject.abott.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.trainingproject.abott.core.service.ExtractDataService;

/**
 * @author sanket.sinha
 *
 */
@Model(adaptables = Resource.class)
public class CarouselStory {
	
	@Inject
	@Optional
	protected String storyUrl;
	
	@SlingObject
	private ResourceResolver request;

	
	@Inject
	ExtractDataService extract;
	
	private String pageTitle;

	private String name;
	
	private String description;
	
	private String image;
	
	private String likes;
	
	private String views;
	
	/**
	 * @return the likes
	 */
	public String getLikes() {
		this.likes=extract.extractData(this.storyUrl, "likes" ,request);
		return likes;
	}

	/**
	 * @return the views
	 */
	public String getViews() {
		this.views=extract.extractData(this.storyUrl, "views",request);
		return views;
	}

	private List<String> tags= new ArrayList<>();
	
    @PostConstruct
    protected void init() {
		String tagData=extract.extractData(storyUrl, "tags",request);
		String[] totalTags=tagData.split(",");
		for(int i=0;i<totalTags.length;i++)
		tags.add(totalTags[i]);
    }

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
	 * @return the name
	 */
	public String getName() {
		this.name=extract.extractData(this.storyUrl, "name",request);
		return name;
	}
	/**
	 * @return the pageTitle
	 */
	public String getPageTitle() {
		this.pageTitle=extract.extractTitle(this.storyUrl,request);
		return pageTitle;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		this.description=extract.extractData(this.storyUrl, "description",request);
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription() {
		this.description = extract.extractData(this.storyUrl, "description",request);
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		this.image=extract.extractImage(storyUrl,request);
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = extract.extractImage(storyUrl,request);
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
	public void setTags(List<String> tags) {
		String tagData=extract.extractData(storyUrl, "tags",request);
		String[] totalTags=tagData.split(",");
		for(int i=0;i<totalTags.length;i++)
		this.tags.add(totalTags[i]);
	}
	
	

}
