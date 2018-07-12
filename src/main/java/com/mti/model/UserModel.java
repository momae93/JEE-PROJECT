package com.mti.model;

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
@Table(name = "user")
public class UserModel {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @Size(max=45)
    @NotNull
    private String username;


    @Column(name = "password")
    @Size(max=45)
    @NotNull
    private String password;

    @Column(name = "isActive")
    @NotNull
    private Integer isActive;
}
