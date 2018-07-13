package com.mti.service;

import com.mti.converter.playlist.PlaylistModelToEntityConverter;
import com.mti.dao.PlaylistDao;
import com.mti.entity.Playlist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PlaylistService {
    @Inject
    private PlaylistDao playlistDao;

    @Inject
    private PlaylistModelToEntityConverter playlistModelToEntityConverter;

    public List<Playlist> findByUserId(final int id) {
        return playlistModelToEntityConverter.convert(playlistDao.findAll().stream()
                .filter(it -> it.getOwner().getId() == id).collect(Collectors.toList()));
    }
}
