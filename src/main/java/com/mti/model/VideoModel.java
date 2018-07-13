package com.mti.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "video")
public class VideoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "token")
    @NotNull
    private String token;

    @Column(name = "streamLink")
    @NotNull
    private String streamLink;

    @Column(name = "id_user")
    @NotNull
    private Integer id_user;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LikeModel> likes;
}
