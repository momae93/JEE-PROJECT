package com.mti.presentation.playlistcontroller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class AllPlaylistByIdUserResponse extends ArrayList<AllPlaylistByIdUserResponse.PlaylistResponse> {

    /**
     * Constructor.
     * @param c Response collections.
     */
    public AllPlaylistByIdUserResponse(final Collection<? extends PlaylistResponse> c) {
        super(c);
    }

    /**
     * Constructor.
     */
    @Data
    @AllArgsConstructor
    public static class PlaylistResponse {
        /**
         * Id.
         */
        private Integer id;

        /**
         * Name.
         */
        private String name;

        /**
         * Token.   
         */
        private String token;
    }
}

