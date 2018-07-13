package com.mti.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    /**
     * Id.
     */
    private Integer id;

    /**
     * User id.
     */
    private Integer id_user;


    /**
     * Video id.
     */
    private Integer id_video;
}
