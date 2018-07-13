package com.mti.converter.playlist;

import com.mti.converter.Converter;
import com.mti.entity.Playlist;
import com.mti.presentation.playlistcontroller.AllPlaylistByIdUserResponse;

public class PlaylistEntityToResponseConverter implements Converter<Playlist, AllPlaylistByIdUserResponse.PlaylistResponse> {
    @Override
    public AllPlaylistByIdUserResponse.PlaylistResponse convert(Playlist from) {
        return new AllPlaylistByIdUserResponse.PlaylistResponse(from.getId(), from.getName(), from.getToken());
    }


    /*
    @Override
    public AllPlaylistByIdUserResponse convert(List<Playlist> from) {
        /*
        final List<Video> videos = videoService.findByUserId(id);
        final List<AllByIdUserResponse.VideoResponse> responses = videos.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        return new AllByIdUserResponse(responses);
        */
/*
        return new AllPlaylistByIdUserResponse(from.stream()
                .map(it -> new AllPlaylistByIdUserResponse.PlaylistResponse(it.getId(), it.getName(), it.getToken()))
                .collect(Collectors.toList()));
    }
    */
}
