package com.mti.converter;

import com.mti.entity.Video;
import com.mti.model.VideoModel;

public class VideoModelToEntityConverter implements Converter<VideoModel,Video> {

    @Override
    public Video convert(VideoModel from) {

        return new Video(from.getId(), from.getName(),
                from.getToken(), from.getStreamLink(), from.getId_user()) ;
    }

}
