//PAGESERVICE IMPLEMENTATION CLASS
package com.trainingproject.abott.core.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.jcr.Node;
import javax.jcr.Session;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.trainingproject.abott.core.constants.AbbottConstants;
import com.day.cq.dam.api.AssetManager;

/**
 * @author aditya.sharma
 *
 */
//PAGESERVICE CONFIGURATIONS
@Component(name = "PageService", immediate = true, service = PageService.class)

public class PageServiceImp implements PageService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// Inject a Sling ResourceResolverFactory
	@Reference
	private ResourceResolverFactory resolverFactory;

	private String newFile;

	// METHOD TO CREATE PAGE USING PAGEMANAGER API
	/**
	 * param: page name, request and response return: void
	 */
	public void CreatePage(String pageName, SlingHttpServletRequest req, ResourceResolver resourceResolver) {
		Session session;
		// String pagePath = "/content/abott/HomePage/stories";
		String pagePath = AbbottConstants.pagePath;
		String templatePath = AbbottConstants.templatePath;
		String pageTitle = AbbottConstants.pageTitle;
		String count = AbbottConstants.count;
		Page newPage;
		PageManager pageManager;
		// EXTRACTING DATA FROM FORM
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String experience = req.getParameter("experience");
		String country = req.getParameter("country");
		String postcode = req.getParameter("postcode");
		String description = req.getParameter("description");
		String tags = req.getParameter("tags");
		try {
			session = resourceResolver.adaptTo(Session.class);

			// CREATING PAGE TITLE USING COUNTER
			Resource homeResource = resourceResolver.getResource(pagePath);

			Page homePage = homeResource.adaptTo(Page.class);
			Resource storyjcrResource = resourceResolver
					.getResource("/content/abott/HomePage/stories/jcr:content/count");
			// EXTRACTING CURRENT COUNT VALUE
			long storyCount = Long.parseLong(storyjcrResource.getValueMap().get(count).toString());
			// INCREASING THE COUNT VALUE
			storyCount = storyCount + 1;
			pageTitle = pageTitle + storyCount;
			Iterator<Page> childPages = homePage.listChildren();
			pageManager = resourceResolver.adaptTo(PageManager.class);
			// CREATING A NEW PAGE
			newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
			if (newPage != null) {
				Node newNode = newPage.adaptTo(Node.class);
				Node cont = newNode.getNode("jcr:content");
				if (cont != null) {
					// ADDING TEXT AND IMAGE NODES
					Node parNode = JcrUtils.getNodeIfExists(cont, AbbottConstants.par);
					Node imageNode = JcrUtils.getOrCreateByPath(parNode.getPath() + "/image",
							JcrConstants.NT_UNSTRUCTURED, session);
					Node textNode = JcrUtils.getNodeIfExists(parNode, AbbottConstants.text);
					// SETTING PROPERTY FOR IMAGE NODE
					imageNode.setProperty("sling:resourceType", "foundation/components/image");
					imageNode.setProperty("fileReference", newFile);
					// SETTING PROPERTY FOR TEXT NODE
					textNode.setProperty(AbbottConstants.text,
							"<h2>" + tags + "</h2>" + "<p>" + name + "</p>" + "<p>" + email + "</p>" + "<p>"
									+ experience + "</p>" + "<p>" + country + "</p>" + "<p>" + postcode + "</p>" + "<p>"
									+ description + "</p>");
					textNode.setProperty("name", name);
					textNode.setProperty("email", email);
					textNode.setProperty("experience", experience);
					textNode.setProperty("country", country);
					textNode.setProperty("postcode", postcode);
					textNode.setProperty("description", description);
					textNode.setProperty("tags", tags);
					textNode.setProperty("likes", "0");
					textNode.setProperty("views", "0");
					// SAVING THE SESSION TO MAKE CHANGES TO CRX DE
					session.save();
					Node storyjcrNode = storyjcrResource.adaptTo(Node.class);
					storyjcrNode.setProperty(AbbottConstants.count, "" + storyCount);
					storyjcrNode.getSession().save();
				}
			}
		} catch (Exception e) {
			log.error("PageServiceImp createpage {}", e.getMessage());
		}
	}

	// SAVING THE UPLOADED FILE TO DAM BY ASSETMANAGER API
	/**
	 * param: request and resolver return: file path
	 */
	public String writeToDam(ResourceResolver resourceResolver, SlingHttpServletRequest req) {
		String fileName = null;
		try {

			Map<String, RequestParameter[]> params = req.getRequestParameterMap();

			for (Entry<String, RequestParameter[]> pairs : params.entrySet()) {

				RequestParameter[] pArr = pairs.getValue();
				RequestParameter param = pArr[0];

				// Save the uploaded file into the Adobe CQ DAM
				if (param.getName().contains("myFile")) {
					InputStream is = param.getInputStream();
					fileName = param.getFileName();
					// ASSESTMANAGER API UPLOADING FILE TO DAM
					AssetManager assetMgr = resourceResolver.adaptTo(AssetManager.class);
					newFile = AbbottConstants.damPath + fileName;
					assetMgr.createAsset(newFile, is, "image/jpeg/png", true);
					// LOCATION OF THE UPLOADED FILE

				}
			}

		} catch (Exception e) {
			log.error("Write to DAM Error {}", e.getMessage());
		}
		return newFile;
	}

}
