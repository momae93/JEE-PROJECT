package com.mti.presentation;

import com.mti.entity.Video;
import com.mti.service.VideoService;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.ws.rs.*;

@ApplicationScoped
@WebService
@Path("")
@Produces("application/json; charset=UTF-8")
public class VideoController {
    @Inject
    private VideoService videoService;

    /*
    @GET
    @Path("/video/{}")
    public Response getFile() {
        File file = fileService.findWithPath("test");
        return Response.ok(file).build();
    }
    */

    @GET
    @Path("/video/{token}")
    public Video getVideo(@PathParam("token") final String token) {
        return token == null ? null : new Video(1, "Video Name", "jd9e4f-zy1hr-h5u6i-yz2di",
                "www.stream.fr/video/djzif-ahdiz-dsqjkfs", null);
    }
}