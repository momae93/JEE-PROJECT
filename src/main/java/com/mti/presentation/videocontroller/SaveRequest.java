package com.mti.presentation.videocontroller;

import lombok.Data;


@Data
public class SaveRequest {

    private String name;
    private String token;
    private String streamLink;
    private Integer id_user;

    /*@Data
    public static class VideoRequest {
        private Integer id;
        private String name;
        private String token;
        private String streamLink;
        private Integer id_user;
    }*/
}
