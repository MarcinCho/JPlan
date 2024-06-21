// package com.jplan.jplan.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
// import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;

// import com.jplan.jplan.entity.Company;

// @Configuration
// public class RestConfiguration implements RepositoryRestConfigurer {

// private String allowedOrigin = "http://localhost:3000";

// public void configureRepositoryRestConfiguration(RepositoryRestConfiguration
// config, CorsRegistry cors) {

// config.exposeIdsFor(Company.class);

// cors.addMapping(config.getBasePath() +
// "/**").allowedOrigins(allowedOrigin);

// }

// }

// public void configureRepositoryRestConfiguration(RepositoryRestConfiguration
// config, CorsRegistry cors) {

// HttpMethod[] theUnsupportedActions = {
// HttpMethod.POST,
// HttpMethod.PATCH,
// HttpMethod.DELETE,
// HttpMethod.PUT };

// config.exposeIdsFor(Book.class);
// config.exposeIdsFor(Review.class);

// disableHttpMethods(Book.class, config, theUnsupportedActions);
// disableHttpMethods(Review.class, config, theUnsupportedActions);

// cors.addMapping(config.getBasePath() +
// "/**").allowedOrigins(theAllowedOrgin);

// }

// private void disableHttpMethods(Class theClass,
// RepositoryRestConfiguration config,
// HttpMethod[] theUnsuportedActions) {

// config.getExposureConfiguration()
// .forDomainType(theClass)
// .withItemExposure((metadata, httpMethods) ->
// httpMethods.disable(theUnsuportedActions))
// .withCollectionExposure((metadata, httpMethods) ->
// httpMethods.disable(theUnsuportedActions));

// }

// }