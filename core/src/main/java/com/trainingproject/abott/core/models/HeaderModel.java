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
public interface HeaderModel {

	// INJECTING LIST OF HEADER LABELS
	// GETTER METHOD FOR LIST OF HEADER LABELS
	@Inject
	List<HeaderLeft> getHeaderleft();

	// MARKING THE HEADER LEFT LIST INTERFACE AS ADAPTABLE
	@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	interface HeaderLeft {
		// INJECTING AND SETTING GETTER METHOD FOR HEADING IMAGE
		@Inject
		String getHeadimgleft();

		// INJECTING AND SETTING GETTER METHOD FOR HEADER LINK
		@Inject
		String getHeadlinkleft();

		// INJECTING AND SETTING GETTER METHOD FOR HEADING IMAGE ALTERNATE TEXT
		@Inject
		String getAlttextleft();

	}

	// INJECTING LIST OF RIGHT HEADER LABELS
	// GETTER METHOD FOR LIST OF RIGHT HEADER LABELS
	@Inject
	List<HeaderRight> getHeaderright();

	// MARKING THE HEADER RIGHT LIST INTERFACE AS ADAPTABLE
	@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	interface HeaderRight {
		// INJECTING AND SETTING GETTER METHOD FOR HEADING IMAGE
		@Inject
		String getHeadimgright();

		// INJECTING AND SETTING GETTER METHOD FOR HEADER LINK
		@Inject
		String getHeadlinkright();

		// INJECTING AND SETTING GETTER METHOD FOR HEADING IMAGE ALTERNATE TEXT
		@Inject
		String getAlttextright();

	}

}