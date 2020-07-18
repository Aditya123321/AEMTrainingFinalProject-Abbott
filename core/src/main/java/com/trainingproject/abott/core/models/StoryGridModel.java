//MODEL FOR STORY GRID COMPONENT
package com.trainingproject.abott.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

/**
 * @author sanket.sinha
 *
 */
@Model(adaptables = Resource.class)
public class StoryGridModel {

	// INJECTING PROPERTIES TO THE COMPONENT
	@Inject
	@Required
	@Default(values = "1x2")
	protected String grid;

	// SETTERS AND GETTERS FOR THE COMPONENT
	/**
	 * @return the grid
	 */
	public String getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(String grid) {
		this.grid = grid;
	}
}
