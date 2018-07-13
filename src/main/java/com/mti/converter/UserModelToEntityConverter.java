package com.mti.converter;

import com.mti.entity.Playlist;
import com.mti.entity.User;
import com.mti.entity.Video;
import com.mti.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserModelToEntityConverter implements Converter<UserModel, User> {
    @Override
    public User convert(final UserModel from) {
        final List<Playlist> playlists = from.getPlaylists().stream()
                .map(it -> new Playlist(null, it.getName(), it.getToken(), it.getOwner()))
                .collect(Collectors.toList());

        final List<Video> videos = from.getVideos().stream()
                .map(it -> new Video(null, it.getName(), it.getToken(), it.getStreamLink(), it.getOwner()))
                .collect(Collectors.toList());

        // FIXME: not sure
        final List<User> friends = from.getFriends().stream()
        .map(it -> new User(null, it.getUsername(), it.getPassword(), it.getIsActive(), it.getPlaylists(), it.getVideos(), it.getFriends()))
        .collect(Collectors.toList());

        return new User(from.getId(), from.getUsername(),
                from.getPassword(), from.getIsActive(), playlists, videos, friends);
    }
}
