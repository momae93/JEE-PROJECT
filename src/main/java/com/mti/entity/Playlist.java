package com.mti.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    /**
     * Id.
     */
    private Integer id;

    /**
     * Name;
     */
    private String name;

    /**
     * Token.
     */
    private String token;

    /**
     * Owner of the playlist.
     */
    private User owner;
}
