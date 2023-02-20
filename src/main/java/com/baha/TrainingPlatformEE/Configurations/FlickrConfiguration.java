package com.baha.TrainingPlatformEE.Configurations;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

@Configurable
public class FlickrConfiguration {
    @Value("${flickr.apiKey}")

    private String ApiKey ;
    @Value("${flickr.apiSecret}")

    private String ApiSecret ;

    public Flickr GetFlicker()
    {
        //this configuration will be executed only ONCE !!
        Flickr flickr = new Flickr(ApiKey,ApiSecret,new REST()) ;
        return flickr ;
    }
}
