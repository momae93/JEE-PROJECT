package com.mti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private Integer id;

    private String name;

    private String token;

    private String streamLink;

    private Integer id_user;

}
