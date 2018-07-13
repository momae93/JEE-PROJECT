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

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserModel owner;

    //FIXME: Annotations.
    //private User owner;

}
