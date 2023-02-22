package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.Services.FlickrInterface;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class FlickrService implements FlickrInterface {
    @Value("${flickr.apiKey}")

    private String ApiKey ;
    @Value("${flickr.apiSecret}")

    private String ApiSecret ;
    @Value("${flickr.appKey}")
    private String AppKey ;
    @Value("${flickr.appSecret}")
    private String AppSecret ;

    private Flickr flickr ;
    @Override
    public String SavePhoto(InputStream MyPhoto, String Title) throws FlickrException {
        UploadMetaData uploadMetaData = new UploadMetaData() ;
        uploadMetaData.setTitle(Title) ;
        String PhotoId = flickr.getUploader().upload(MyPhoto,uploadMetaData) ;
        return flickr.getPhotosInterface().getPhoto(PhotoId).getMedium640Url() ;
    }
    private void Connect()
    {
        //gott there is so much to look for when using the Auth and flicker configuration !
        flickr = new Flickr(ApiKey,ApiSecret,new REST()) ;
        Auth auth = new Auth() ;
        auth.setPermission(Permission.DELETE);
        auth.setToken(AppKey);
        auth.setTokenSecret(AppSecret);
        RequestContext requestContext = RequestContext.getRequestContext() ;
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }
}
