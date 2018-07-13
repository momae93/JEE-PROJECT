package com.mti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    /**
     * Id.
     */
    private Integer id;

    /**
     * Name.
     */
    private String name;

    /**
     * Token.
     */
    private String token;

    /**
     * Link of the video.
     */
    private String streamLink;

    /**
     * Owner id.
     */
    private Integer id_user;

    /**
     * Likes list of the video.
     */
    private List<Like> likes;
}
