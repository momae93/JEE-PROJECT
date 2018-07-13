package com.mti.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Id.
     */
    private Integer id;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Account activated or not.
     */
    private Boolean isActive;

    /**
     * List of playlists.
     */
    private List<Playlist> playlists;
}
