package com.mti.model;

import com.mti.entity.Playlist;
import com.mti.entity.User;
import com.mti.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @Size(max = 45)
    @NotNull
    private String username;


    @Column(name = "password")
    @Size(max = 45)
    @NotNull
    private String password;

    @Column(name = "isActive")
    @NotNull
    private Boolean isActive;

    // FIXME: Annotations.
    
    //private List<Playlist> playlists;
    //private List<Video> videos;
    //private List<User> friends;

}
