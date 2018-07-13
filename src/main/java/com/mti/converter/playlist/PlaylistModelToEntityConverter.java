package com.mti.converter.playlist;

import com.mti.converter.Converter;
import com.mti.entity.Playlist;
import com.mti.model.PlaylistModel;

/**
 * Converter : Playlist model to Playlist entity
 */
public class PlaylistModelToEntityConverter implements Converter<PlaylistModel, Playlist> {
    @Override
    public Playlist convert(PlaylistModel from) {
        return new Playlist(from.getId(), from.getName(), from.getToken(), null);
    }
}
