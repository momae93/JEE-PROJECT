package com.mti.converter.video;

import com.mti.converter.Converter;
import com.mti.entity.Video;
import com.mti.presentation.videocontroller.AllByIdUserResponse;

/**
 * Converter : Video entity to User response
 */
public class VideoEntityToAllByIdUserResponseConverter implements Converter<Video, AllByIdUserResponse.VideoResponse> {
    @Override
    public AllByIdUserResponse.VideoResponse convert(Video from) {
        return new AllByIdUserResponse.VideoResponse(from.getId(), from.getName(), from.getToken(), from.getStreamLink());
    }
}
