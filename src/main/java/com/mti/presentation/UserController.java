package com.mti.presentation;

import com.mti.converter.user.UserEntityToResponseConverter;
import com.mti.entity.User;
import com.mti.presentation.usercontroller.*;
import com.mti.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@ApplicationScoped
@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {
    @Inject
    private UserService userService;

    @Inject
    private UserEntityToResponseConverter converter;

    @POST
    public SaveResponse save(final SaveRequest request) {
        final User user = new User(null, request.getUsername(), request.getPassword(), true, null);
        final User res = userService.save(user);
        return new SaveResponse(res.getId(), res.getUsername(), res.getPassword(), res.getIsActive());
    }

    @GET
    @Path("/{idUser}")
    public GetByIdResponse getByIdUser(@PathParam("idUser") final Integer id) {
        final User user = userService.findById(id);
        return (user != null) ?
                new GetByIdResponse(user.getId(), user.getUsername(), user.getPassword(), user.getIsActive())
                : new GetByIdResponse();
    }

    @GET
    @Path("")
    public GetAllResponse all(){
        final List<User> users = userService.findAll();
        return new GetAllResponse(converter.convert(users));
    }

    @PUT
    @Path("")
    public DisableResponse disable(DisableRequest request){
        final User user = userService.findById(request.getId());
        final User res = userService.disable(user);
        return new DisableResponse(res.getId(), res.getUsername(), res.getPassword(), res.getIsActive());
    }
}
