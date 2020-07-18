//SERVICE TO EXTRACT DATA FROM PAGE
package com.trainingproject.abott.core.service;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * @author aditya.sharma
 *
 */
public interface ExtractDataService {

	// METHOD TO EXTRACT TEXT FROM PAGE
	String extractText(String sourceUrl, ResourceResolver resolver);

	// METHOD TO EXTRACT IMAGE FROM PAGE
	String extractImage(String sourceUrl, ResourceResolver resolver);

	// METHOD TO EXTRACT SPECIFIC DATA FROM PAGE
	String extractData(String sourceUrl, String data, ResourceResolver resolver);

	// METHOD TO EXTRACT TITLE OF THE PAGE
	String extractTitle(String sourceUrl, ResourceResolver resolver);

}
