package com.baha.TrainingPlatformEE.Services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrInterface {

    String SavePhoto(InputStream MyPhoto , String Title) throws FlickrException;
}
