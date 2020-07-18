//EMAILSERVICE IMPLEMENTATION CLASS
package com.trainingproject.abott.core.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.HtmlEmail;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;

//EMAILSERVICE CONFIGURATIONS
/**
 * @author dipon.sengupta
 *
 */
@Component(name = "EmailService", immediate = true, service = EmailService.class)

public class EmailServiceImp implements EmailService {


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// Inject a Sling ResourceResolverFactory
	@Reference
	private ResourceResolverFactory resolverFactory;

	 @Reference
	 private MessageGatewayService messageGatewayService;

	 @Reference
	 private MessageGateway<HtmlEmail> messageGateway;

	// METHOD TO CREATE PAGE USING PAGEMANAGER API
	public String SendEmail(SlingHttpServletRequest req) {
		
		
		//EXTRACTING EMAIL FROM FORM
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		try {
			
			  ArrayList<InternetAddress> emailRecipients = new ArrayList<>();
	            HtmlEmail email1 = new HtmlEmail();

	            emailRecipients.add(new InternetAddress(email));

	            // sending mail
	            email1.setTo(emailRecipients);

	            // setting subject of email
	            email1.setSubject("Abbott Story Sharing Successful");

	            // setting body of email
	            email1.setContent("<pre>Hi " + name + " "  + "<br><b>" + "Thank you for you submission!"+"<br>"+" We have received your story, and our FreeStyle team will review it. If it is in accordance with our Terms and Conditions we will email you when it is ready to be published. "
	            		+ "Thanks again for sharing your experience. If you have any questions, contact us." + "</b></pre>",
	                    "text/html");

	            // Inject a MessageGateway Service and send the message
	            messageGateway = messageGatewayService.getGateway(HtmlEmail.class);
	            // Check the logs to see that messageGateway is not null
	            messageGateway.send(email1);

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

		return "";

	}

	
}
