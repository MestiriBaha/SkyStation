package com.baha.TrainingPlatformEE.Configurations;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.auth.Auth;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@Configuration
public class FlickrConfiguration {
    @Value("${flickr.apiKey}")

    private String ApiKey ;
    @Value("${flickr.apiSecret}")

    private String ApiSecret ;

    @Bean
    public Flickr GetFlicker() throws IOException, ExecutionException, InterruptedException, FlickrException {
        //this configuration will be executed only ONCE !!
        Flickr flickr = new Flickr(ApiKey,ApiSecret,new REST()) ;
        //we should only be authenticated using the OAuth specification which is the industry standard
        OAuth10aService service = new ServiceBuilder(ApiKey)
                .apiSecret(ApiSecret)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE)) ;
        final Scanner scanner = new Scanner(System.in) ;
        final OAuth1RequestToken request = service.getRequestToken() ;
        final String OAuthUrl = service.getAuthorizationUrl(request) ;
        System.out.println(OAuthUrl);
        System.out.println("Print it here >> ");
        final String OAuthVerified = scanner.nextLine() ;
        OAuth1AccessToken accessToken = service.getAccessToken(request,OAuthVerified) ;
        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());
        Auth auth = flickr.getAuthInterface().checkToken(accessToken) ;
        System.out.println("........");
        System.out.println(auth.getToken());
        System.out.println(auth.getTokenSecret());
        return flickr ;


    }
}
