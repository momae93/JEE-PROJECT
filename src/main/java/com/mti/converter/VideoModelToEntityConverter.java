package com.mti.converter;

import com.mti.entity.Like;
import com.mti.entity.Video;
import com.mti.model.VideoModel;

import java.util.List;
import java.util.stream.Collectors;

public class VideoModelToEntityConverter implements Converter<VideoModel,Video> {

    @Override
    public Video convert(VideoModel from) {
        final List<Like> likes = from.getLikes().stream()
                .map(it -> new Like(null, it.getId_user(), null))
                .collect(Collectors.toList());
        return new Video(from.getId(), from.getName(),
                from.getToken(), from.getStreamLink(), from.getId_user(), likes);
    }

}
