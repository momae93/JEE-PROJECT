package com.mti.model;


import com.mti.entity.User;
import com.mti.entity.Video;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "id_user")
    @NotNull
    private Integer id_user;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_video", referencedColumnName = "id")
    private VideoModel video;

}
