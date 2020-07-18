//EMAIL SERVICE INTERFACE
package com.trainingproject.abott.core.service;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * @author dipon.sengupta
 *
 */
public interface EmailService {
	// METHOD TO SEND EMAIL
	public String SendEmail(SlingHttpServletRequest req);

}
