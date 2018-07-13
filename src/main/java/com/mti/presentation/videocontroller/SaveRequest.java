package com.mti.presentation.videocontroller;

import lombok.Data;


public class SaveRequest {

    private String name;

    //private List<FileRequest> files;

    @Data
    public static class VideoRequest {
        private String name;
        private String token;
        private String streamLink;
    }
}
