package com.mti.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private Boolean isActive;

    //private List<Playlist> playlists;

    //private List<Video> videos;

    //private List<User> friends;
}
