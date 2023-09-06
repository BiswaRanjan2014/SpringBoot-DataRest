package com.dakr.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.dakr.entity.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		// Here we Disabling the method...
		HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.DELETE };

		//could be used to retrieve the configuration settings for how the app should handle exposure risk calculation and notification.
		//These settings could include parameters like the risk threshold, attenuation levels, 
		//and exposure duration that define what constitutes a potential exposure to the virus.
		config.getExposureConfiguration()
		
		      //In This mehod we are trying to create an instance or 
		      //perform an action related to the Book class within a certain framework or context
		      .forDomainType(Book.class)
		      
		      //It will not accept the Single object request (withItemExposure)
			  //This method indicates that you're configuring the exposure of individual items (resources)
		      .withItemExposure((metadata, http) -> http.disable(unsupportedMethods))
		      
		      //This method indicates that you're configuring the exposure of collections of items.
			  //It will not accept the multiple object request in JSON Array(withCollectionExposure)
			  .withCollectionExposure((metadata, http) -> http.disable(unsupportedMethods));
	}

}





/*
 * metadata : This parameter could be a metadata object that provides information about the collection being exposed.
   http     : This parameter could represent an HTTP configuration or authorization object.
  .disable(unsupportedMethods) : This part indicates that you're disabling certain HTTP methods (e.g., DELETE, PUT) for the collection resources. 
          unsupportedMethods might be a variable or a set of HTTP methods that you want to prevent for some reason.
*/
 