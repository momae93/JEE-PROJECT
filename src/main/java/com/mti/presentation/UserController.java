package com.mti.presentation;

import com.mti.converter.user.UserEntityToAllResponseConverter;
import com.mti.entity.User;
import com.mti.entity.Video;
import com.mti.presentation.usercontroller.GetAllResponse;
import com.mti.presentation.usercontroller.GetByIdResponse;
import com.mti.presentation.usercontroller.SaveRequest;
import com.mti.presentation.usercontroller.SaveResponse;
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

    @POST
    public SaveResponse save(final SaveRequest request) {
        final User user = new User(null, request.getUsername(), request.getPassword(), request.getIsActive());
        final User res = userService.save(user);
        return new SaveResponse(res.getId(), res.getUsername(), res.getPassword(), res.getIsActive());
    }

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
