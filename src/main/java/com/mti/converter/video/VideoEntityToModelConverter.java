package com.mti.converter.video;

import com.mti.converter.Converter;
import com.mti.entity.Video;
import com.mti.model.LikeModel;
import com.mti.model.VideoModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter : Video entity to User model
 */
public class VideoEntityToModelConverter  implements Converter<Video, VideoModel> {
    @Override
    public VideoModel convert(Video from) {
        final List<LikeModel> likes = from.getLikes().stream()
                .map(it -> new LikeModel(null, it.getId_user(), null))
                .collect(Collectors.toList());
        return new VideoModel(from.getId(), from.getName(), from.getToken(), from.getStreamLink(), 1, likes);
    }
}
