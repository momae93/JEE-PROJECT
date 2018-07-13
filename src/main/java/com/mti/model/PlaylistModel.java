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

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(max = 45)
    private String name;

    @Column(name = "token")
    @NotNull
    @Size(max = 45)
    private String token;

    @Column(name = "id_user")
    @NotNull
    private Integer id_user;
    //FIXME: Annotations.
    //private User owner;

}
