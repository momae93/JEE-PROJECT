package com.mti.presentation.usercontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
public class GetAllResponse extends ArrayList<GetAllResponse.UserResponse>{

    /**
     *
     * @param c User Response collection.
     */
    public GetAllResponse(Collection<? extends UserResponse> c) {
        super(c);
    }

    /**
     * Constructor.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserResponse {
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
}
