package com.roseindia.wicket;
import org.apache.wicket.protocol.http.WebApplication;


public class WebsiteApplication extends WebApplication{
    public WebsiteApplication(){
        
    }
    public Class getHomePage(){
        return Home.class;
    }   

}
