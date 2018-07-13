package com.mti.presentation.usercontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdResponse {
    /**
     * Id.
     */
    public Integer id;
    /**
     * Username.
     */
    public String username;

    /**
     * Password.
     */
    public String password;

    /**
     * Active or not.
     */
    public Boolean isActive;
}
