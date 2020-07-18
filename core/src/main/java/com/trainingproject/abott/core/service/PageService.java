//PAGE SERVICE INTERFACE
package com.trainingproject.abott.core.service;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * @author aditya.sharma
 *
 */
public interface PageService {
	// METHOD TO CREATE PAGE ON THE INSTANCE USING PAGEMANAGER API
	public void CreatePage(String pageName, SlingHttpServletRequest req, ResourceResolver resourceResolver);

	// METHOD TO ADD FILE TO DAM USING ASSETMANAGER API
	public String writeToDam(ResourceResolver resourceResolver, SlingHttpServletRequest req);
}
