package com.mti.converter.playlist;

import com.mti.converter.Converter;
import com.mti.entity.Playlist;
import com.mti.presentation.playlistcontroller.AllPlaylistByIdUserResponse;

/**
 * Converter : Playlist entity to Playlist response
 */
public class PlaylistEntityToResponseConverter implements Converter<Playlist, AllPlaylistByIdUserResponse.PlaylistResponse> {
    @Override
    public AllPlaylistByIdUserResponse.PlaylistResponse convert(Playlist from) {
        return new AllPlaylistByIdUserResponse.PlaylistResponse(from.getId(), from.getName(), from.getToken());
    }
}
