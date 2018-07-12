package com.mti.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    private Integer id;

    private String name;

    private String token;

    private User owner;
}
