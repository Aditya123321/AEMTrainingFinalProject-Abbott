package com.trainingproject.abott.core.models;

/**
 * @author aditya.sharma
 *
 */
import java.util.List;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

//MARKING THE INTERFACE AS ADAPTABLE
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public interface FooterModel {
	// INJECTING AND SETTING GETTER METHOD FOR FOOTER LOGO
	@Inject
	String getLogo();

	// INJECTING AND SETTING GETTER METHOD FOR FOOTER LOGO ALTERNATE TEXT
	@Inject
	String getAlttext();

	// INJECTING AND SETTING GETTER METHOD FOR COPYRIGHT INFO
	@Inject
	String getCopyrighttext();

	// INJECTING AND SETTING GETTER METHOD FOR FOOTER LABELS
	@Inject
	List<FooterHeadLabels> getFooterheadlabels();

	// MARKING THE INTERFACE AS ADAPTABLE
	@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	interface FooterHeadLabels {
		// INJECTING AND SETTING GETTER METHOD FOR LINK LABEL
		@Inject
		String getLabelheading();

		// INJECTING AND SETTING GETTER METHOD FOR LABLE LINK
		@Inject
		String getLabellink();
	}

	// INJECTING AND SETTING GETTER METHOD FOR FOOTER MEDIA TEXT
	@Inject
	String getMediatext();

	// INJECTING AND SETTING GETTER METHOD FOR FOOTER SOCIAL MEDIA ITEMS
	@Inject
	List<MediaLabels> getMedialabels();

	// MARKING THE INTERFACE AS ADAPTABLE
	@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	interface MediaLabels {
		// INJECTING AND SETTING GETTER METHOD FOR SOCIAL MEDIA ICON PATH
		@Inject
		String getIcon();

		// INJECTING AND SETTING GETTER METHOD FOR SOCIAL MEDIA ICON ALTERNATE TEXT
		@Inject
		String getAlttext();

		// INJECTING AND SETTING GETTER METHOD FOR SOCIAL MEDIA ICON LINK
		@Inject
		String getLink();
	}

	// INJECTING AND SETTING GETTER METHOD FOR SOCIAL ICON TEXT MESSAGE
	@Inject
	String getText();

}