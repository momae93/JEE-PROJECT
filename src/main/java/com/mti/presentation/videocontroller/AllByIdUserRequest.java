package com.mti.presentation.videocontroller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class AllByIdUserRequest extends ArrayList<AllByIdUserResponse.VideoResponse> {

    public static class Video {
        private Integer id;
        private String name;
        private String token;
        private String streamLink;
    }
}

