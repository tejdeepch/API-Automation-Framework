package com.api.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        //Request is going to be executed
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification filterableRequestSpecification) {
        logger.info("BASE_URI :" + filterableRequestSpecification.getBaseUri());
        logger.info("Request Header :" + filterableRequestSpecification.getHeaders());
        logger.info("Request Payload :" + filterableRequestSpecification.getBody());
    }

    public void logResponse(Response response) {
        logger.info("Status Code :" + response.getStatusCode());
        logger.info("Response Payload :" + response.getBody().prettyPrint());
        logger.info("Response Header :" + response.headers());
    }
}
