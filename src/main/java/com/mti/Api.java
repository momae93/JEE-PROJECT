package com.mti;

import com.mti.presentation.PlaylistController;
import com.mti.presentation.UserController;
import com.mti.presentation.VideoController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("app")
public  class  Api extends Application {
    @Override public Set<Class<?>> getClasses()  {
        return  getRestResourceClasses();
    }
    private  Set<Class<?>>  getRestResourceClasses()  {
        Set<Class<?>>  resources  =  new  java.util.HashSet<Class<?>>();
        resources.add(VideoController.class);
        resources.add(UserController.class);
        resources.add(PlaylistController.class);
        resources.add(ResponseCorsFilter.class);
        return resources;
    }
}
