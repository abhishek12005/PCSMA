package com.example.pdfupload;

import retrofit.http.Multipart;
import retrofit.http.POST;

/**
 * Created by abhishek on 4/7/2015.
 */
public interface Serv {

    @Multipart
    @POST("/upload")
    public String handleFileUpload(String title,Multipart file);

}
