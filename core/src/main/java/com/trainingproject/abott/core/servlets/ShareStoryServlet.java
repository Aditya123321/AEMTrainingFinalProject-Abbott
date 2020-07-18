//SERVLET TO MAKE STORY PAGE ON FORM SUBMIT
package com.trainingproject.abott.core.servlets;

import com.trainingproject.abott.core.service.EmailService;
import com.trainingproject.abott.core.service.PageService;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//DECLARING THE SERVLET CONFIGURATION
/**
 * @author sanket.sinha
 *
 */
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Story Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/send" })

public class ShareStoryServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 8565932343267006374L;

	private final transient Logger log = LoggerFactory.getLogger(this.getClass());

	// PAGESERIVCE TO WRITE FILES IN DAM AND CREATE PAGE
	@Reference
	private transient PageService pageService;
	@Reference
    private transient EmailService emailService;

	// POST METHOD ON FORM SUBMIT
	/**
	 * param: request and response 
	 * return: void
	 */
	@Override
	protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		ResourceResolver resourceResolver = req.getResourceResolver();
		

		// TO UPLOAD FILE TO DAM
		try {
			final boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			if (isMultipart) {

				pageService.writeToDam(resourceResolver, req);
			}
			// TO UPLOAD PAGE IN SITE
			// CALLING PAGESERVICE METHOD
			pageService.CreatePage("storypage", req, resourceResolver);
			emailService.SendEmail(req);
		} catch (Exception e) {
			log.error("From Share Story doPost {}",e.getMessage());
		}
		// REDIRECTING TO HOMEPAGE AFTER SUBMIT
		log.info("Page Created ");
		resp.sendRedirect("/content/abott/successpage.html");
	}
}
