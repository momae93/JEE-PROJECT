package com.mti.presentation.usercontroller;

import lombok.Data;

@Data
public class SaveRequest {
    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;
}