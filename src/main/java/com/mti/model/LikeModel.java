package com.mti.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_like_video")
public class LikeModel {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * User id.
     */
    @Column(name = "id_user")
    @NotNull
    private Integer id_user;

    /**
     * Video that is liked.
     */
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_video", referencedColumnName = "id")
    private VideoModel video;

}
