package com.mti.converter;

import com.mti.entity.Video;
import com.mti.model.VideoModel;

import java.util.List;

public class VideoEntityToModelConverter  implements Converter<Video, VideoModel> {
    @Override
    public VideoModel convert(Video from) {
        return new VideoModel(from.getId(), from.getName(), from.getToken(), from.getStreamLink(), 1);
    }

    @Override
    public List<VideoModel> convert(List<Video> fromList) {
        return null;
    }
}
