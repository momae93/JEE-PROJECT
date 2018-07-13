package com.mti.converter;

import com.mti.entity.Video;
import com.mti.model.VideoModel;

import java.util.List;

public class VideoModelToEntityConverter implements Converter<VideoModel,Video> {

    @Override
    public Video convert(VideoModel from) {

        return new Video(from.getId(), from.getName(),
                from.getToken(), from.getStreamLink(), null) ;
    }

}
