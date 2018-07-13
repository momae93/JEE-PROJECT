package com.mti.presentation.usercontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
public class GetAllResponse extends ArrayList<GetAllResponse.UserResponse>{

    public GetAllResponse(Collection<? extends UserResponse> c) {
        super(c);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserResponse {
        public Integer id;

        public String username;

        public String password;

        public Boolean isActive;
    }
}
