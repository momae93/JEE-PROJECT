package com.mti.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    private Integer id;

    private Integer id_user;

    private Integer id_video;
}
