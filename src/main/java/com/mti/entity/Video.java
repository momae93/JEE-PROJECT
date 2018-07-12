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

    private String token;

    private String streamLink;

    private List<User> owners;
}
