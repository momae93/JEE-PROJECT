package com.mti.model;

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

    /**
     * Id.
      */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Username.
     */
    @Column(name = "username")
    @Size(max = 45)
    @NotNull
    private String username;

    /**
     * Password.
     */
    @Column(name = "password")
    @Size(max = 45)
    @NotNull
    private String password;

    /**
     * Account active or not.
     */
    @Column(name = "isActive")
    @NotNull
    private Boolean isActive;

    /**
     * Playlist list.
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlaylistModel> playlists;

}
