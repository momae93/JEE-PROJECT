package com.mti.presentation;

import com.mti.converter.playlist.PlaylistEntityToResponseConverter;
import com.mti.entity.Playlist;
import com.mti.presentation.playlistcontroller.AllPlaylistByIdUserResponse;
import com.mti.service.PlaylistService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.util.List;

@Named("playlistController")
@ApplicationScoped
@Path("/playlist")
@Consumes("application/json")
@Produces("application/json")
public class PlaylistController {
    @Inject
    private PlaylistService playlistService;

    @Inject
    private PlaylistEntityToResponseConverter converter;

    @GET
    @Path("/user/{idUser}")
    public AllPlaylistByIdUserResponse getPlaylistByUserId(@PathParam("idUser") final Integer id) {
        final List<Playlist> playlists = playlistService.findByUserId(id);
        return new AllPlaylistByIdUserResponse(converter.convert(playlists));
    }
}