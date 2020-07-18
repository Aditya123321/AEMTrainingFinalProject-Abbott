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

public interface NavbarModel {
	// INJECTING AND SETTING GETTER METHOD FOR NAVBAR ITEMS LIST
	@Inject
	List<NavbarItems> getNavbaritems();

	// MARKING THE ITEMS LIST INTERFACE AS ADAPTABLE
	@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	public interface NavbarItems {
		// INJECTING AND SETTING GETTER METHOD FOR LINK LABEL
		@Inject
		String getNavbarlabelheading();

		// INJECTING AND SETTING GETTER METHOD FOR LABEL LINK
		@Inject
		String getNavbarlabellink();
	}
}