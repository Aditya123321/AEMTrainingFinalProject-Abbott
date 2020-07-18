package com.trainingproject.abott.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.adobe.xfa.Node;


@Model(adaptables= {Resource.class},
	defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TagListModel {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TagListModel.class);
	
	
	@Inject
    private String tagurl;
	
   
    @SlingObject
    private ResourceResolver resourceResolver;
    private List<TagNames> tagnameList = new ArrayList<TagNames>();
    Map<String, Object> serviceParams = new HashMap<String, Object>();
   
    @Reference
    Resource resource;
   
   
    @PostConstruct
    public void init() {
       
        try {
            Resource resource = resourceResolver.getResource(tagurl);
			LOGGER.info("::::::Resource::::::::" + resource.getPath());
			
			Iterator<Resource> childresources = resource.listChildren();
			
			if(resource!=null) {
				while(childresources.hasNext()) {
					
					TagNames listname = new TagNames();
					Resource childres = childresources.next(); 
					//LOGGER.info("::::::ChildResource::::::::" + childres.getPath());
					
					LOGGER.info("::::::NODE NAME::::::" + childres.getName());
					String keyMap = childres.getName();
					
					listname = childres.adaptTo(TagNames.class);
					
					serviceParams.put(keyMap, listname);
					
					//LOGGER.info("::::::ChildTitle::::::::" + listname.getTagName());			
					tagnameList.add(listname);
				}
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> getTagname() {
		return serviceParams;
	}

	public List<TagNames> getTagnameList() {
		return tagnameList;
	}

	
	
}
