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

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name.
     */
    @Column(name = "name")
    @NotNull
    private String name;

    /**
     * Token.
     */
    @Column(name = "token")
    @NotNull
    private String token;

    /**
     * Video link.
     */
    @Column(name = "streamLink")
    @NotNull
    private String streamLink;

    /**
     * User id.
     */
    @Column(name = "id_user")
    @NotNull
    private Integer id_user;

    /**
     * List of likes.
     */
    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LikeModel> likes;
}
