package com.mti.presentation.videocontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class AllByIdUserResponse extends ArrayList<AllByIdUserResponse.VideoResponse> {
    public AllByIdUserResponse(final Collection<? extends VideoResponse> c) {
        super(c);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VideoResponse {
        private Integer id;
        private String name;
        private String token;
        private String streamLink;
    }
}
