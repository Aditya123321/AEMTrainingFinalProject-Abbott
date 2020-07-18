//MODEL FOR TAG COMPONENT
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
public class Tags {

	// INJECTING PROPERTIES TO THE MULTIFIELD
	@Inject
	@Optional
	protected String tag;

	// SETTERS AND GETTERS FOR PROPERTIES
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

}
