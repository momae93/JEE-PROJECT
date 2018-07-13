package com.mti.presentation;

import com.mti.converter.user.UserEntityToAllResponseConverter;
import com.mti.entity.User;
import com.mti.entity.Video;
import com.mti.presentation.usercontroller.GetAllResponse;
import com.mti.presentation.usercontroller.GetByIdResponse;
import com.mti.presentation.videocontroller.AllByIdUserResponse;
import com.mti.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {
    @Inject
    private UserService userService;

    @Inject
    private UserEntityToAllResponseConverter converter;
/*
    @POST
    public SaveResponse save(final SaveRequest request){
        final List<MediaFile> files = request.getFiles().stream()
                .map(it -> new MediaFile(null, it.getPath(), it.getFormat(), null))
                .collect(Collectors.toList());
        final Media media = new Media(null, request.getName(), request.getDescription());
        final Media result = userService.save(media);
        return new SaveResponse(result.id);
    }
*/


    @GET
    @Path("/{idUser}")
    public GetByIdResponse getVideoByUserId(@PathParam("idUser") final Integer id) {
        final User user = userService.findById(id);
        return new GetByIdResponse(user.getId(), user.getUsername(), user.getPassword(), user.getIsActive());
    }

    @GET
    @Path("")
    public GetAllResponse all(){
        final List<User> medias = userService.findAll();
        final List<GetAllResponse.UserResponse> responses = medias.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        return new GetAllResponse(responses);
    }
}
