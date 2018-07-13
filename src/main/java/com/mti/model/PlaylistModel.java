package com.mti.model;


import com.mti.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlist")
public class PlaylistModel {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the playlist.
     */
    @Column(name = "name")
    @NotNull
    @Size(max = 45)
    private String name;

    /**
     * Token of the playlist.
     */
    @Column(name = "token")
    @NotNull
    @Size(max = 45)
    private String token;

    /**
     * Owner of the playlist.
     */
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserModel owner;

}
