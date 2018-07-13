package com.mti.presentation.usercontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisableResponse {
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
     * Account active or not.
     */
    private Boolean isActive;
}
