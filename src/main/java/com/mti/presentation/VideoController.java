package com.mti.presentation;
import com.mti.converter.video.VideoEntityToAllByIdUserResponseConverter;
import com.mti.entity.Video;
import com.mti.presentation.videocontroller.AllByIdUserResponse;
import com.mti.presentation.videocontroller.GetByTokenResponse;
import com.mti.presentation.videocontroller.SaveRequest;
import com.mti.presentation.videocontroller.SaveResponse;
import com.mti.service.VideoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/video")
@Consumes("application/json")
@Produces("application/json")
public class VideoController {
    @Inject
    private VideoService videoService;

    @Inject
    private VideoEntityToAllByIdUserResponseConverter converter;

    @GET
    @Path("/user/{idUser}")
    public AllByIdUserResponse getVideoByUserId(@PathParam("idUser") final Integer id) {
        final List<Video> videos = videoService.findByUserId(id);
        final List<AllByIdUserResponse.VideoResponse> responses = videos.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        return new AllByIdUserResponse(responses);

    }

    @GET
    @Path("/token/{token}")
    public GetByTokenResponse getVideo(@PathParam("token") final String token) {
        final Video video = videoService.findByToken(token);
        return new GetByTokenResponse(video.getName(), video.getStreamLink(), video.getLikes().size());
    }

    @GET
    @Path("/id/{id}")
    public Video getVideoId(@PathParam("id") final Integer id) {
        final Video video = videoService.findById(id);
        return video;
    }

    @POST
    public SaveResponse save(final SaveRequest request) {
        final Video video = new Video(null, request.getName(), request.getToken(), request.getStreamLink(), 1, null);
        final Video res = videoService.save(video);
        return new SaveResponse(res.getId());
    }
}
