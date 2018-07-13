package com.mti.converter;

import com.mti.entity.Video;
import com.mti.presentation.videocontroller.AllByIdUserResponse;

import java.util.List;

public class VideoEntityToAllByIdUserResponseConverter implements Converter<Video, AllByIdUserResponse.VideoResponse> {
    @Override
    public AllByIdUserResponse.VideoResponse convert(Video from) {
        return new AllByIdUserResponse.VideoResponse(from.getId(), from.getName(), from.getToken(), from.getStreamLink());
    }

    @Override
    public List<AllByIdUserResponse.VideoResponse> convert(List<Video> fromList) {
        return null;
    }
}
