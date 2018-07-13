package com.mti.presentation.usercontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveResponse {

    /**
     * Id.
     */
    private Integer id;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Active or not.
     */
    private Boolean isActive;
}
