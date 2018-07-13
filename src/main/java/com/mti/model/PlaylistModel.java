package com.mti.model;


import com.mti.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*@ToString
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
    private String name;

    @Column(name = "token")
    @NotNull
    private String token;

    //FIXME: Annotations.
    private User owner;

}*/
