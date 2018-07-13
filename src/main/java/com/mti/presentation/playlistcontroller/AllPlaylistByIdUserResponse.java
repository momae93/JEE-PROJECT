package com.mti.presentation.playlistcontroller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class AllPlaylistByIdUserResponse extends ArrayList<AllPlaylistByIdUserResponse.PlaylistResponse> {

    public AllPlaylistByIdUserResponse(final Collection<? extends PlaylistResponse> c) {
        super(c);
    }

    @Data
    @AllArgsConstructor
    public static class PlaylistResponse {
        private Integer id;
        private String name;
        private String token;
    }
}

