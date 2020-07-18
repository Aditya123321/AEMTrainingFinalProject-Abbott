//CLASS TO IMPLEMENT EXTRACT DATA SERVICE
package com.trainingproject.abott.core.service;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;

/**
 * @author sanket.sinha
 *
 */
//EXTRACTPAGEDATA SERVICE CONFIGURATIONS
@Component(name = "ExtractPageDataService", immediate = true, service = ExtractDataService.class)
public class ExtractDataServiceImpl implements ExtractDataService {

	protected String textUrl;

	protected String imageUrl;

	private final transient Logger log = LoggerFactory.getLogger(this.getClass());

	@Reference
	private ResourceResolverFactory resolverFactory;

	// METHOD TO EXTRACT TEXT FROM PAGE
	/** param: source url and resolver
	 *	return: text
	 */
	@Override
	public String extractText(String sourceUrl, ResourceResolver resolver) {
		textUrl = sourceUrl + "/jcr:content/par/text";
		String textData = null;
		// GETTING NODE AS RESOURCE AND EXTRTACTING DATA
		try {
			Resource textNode = resolver.getResource(textUrl);
			textData = textNode.getValueMap().get("text").toString();
		} catch (Exception e) {
			
			log.error("From Extract Text Method {}",e.getMessage());
		}
		return textData;
	}

	// METHOD TO EXTRACT SPECIFIC DATA FROM PAGE
	/** param: source url and resolver
	 *	return: data value
	 */
	@Override
	public String extractData(String sourceUrl, String data, ResourceResolver resolver) {
		textUrl = sourceUrl + "/jcr:content/par/text";
		String dataValue = null;
		// GETTING NODE AS RESOURCE AND EXTRTACTING DATA
		try {
			Resource textNode = resolver.getResource(textUrl);
			dataValue = textNode.getValueMap().get(data).toString();
		} catch (Exception e) {
			
			log.error("From Extract Data Method {}",e.getMessage());
		}
		return dataValue;
	}

	// METHOD TO EXTRACT IMAGE FROM PAGE
	/** param: source url and resolver
	 *	return: image
	 */
	@Override
	public String extractImage(String sourceUrl, ResourceResolver resolver) {
		imageUrl = sourceUrl + "/jcr:content/par/image";
		String imageData = null;
		// GETTING NODE AS RESOURCE AND EXTRTACTING IMAGE
		try {
			Resource textNode = resolver.getResource(imageUrl);
			imageData = textNode.getValueMap().get("fileReference").toString();
		} catch (Exception e) {
			
			log.error("From Extract Image Method {}",e.getMessage());
		}
		return imageData;
	}

	// METHOD TO EXTRACT TITLE FROM PAGE
	/** param: source url and resolver
	 *	return: pagetitle
	 */
	@Override
	public String extractTitle(String sourceUrl, ResourceResolver resolver) {
		String pageTitle = null;
		// GETTING NODE AS PAGE AND EXTRTACTING TITLE
		try {
			Resource pageResource = resolver.getResource(sourceUrl);
			Page storyPage = pageResource.adaptTo(Page.class);
			pageTitle = storyPage.getTitle();
		} catch (Exception e) {
			
			log.error("From Extract Title Method {}",e.getMessage());
		}
		return pageTitle;
	}
}
	