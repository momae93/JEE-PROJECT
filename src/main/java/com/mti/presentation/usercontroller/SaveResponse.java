package com.mti.presentation.usercontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveResponse {
    private Integer id;
    private String username;
    private String password;
    private Boolean isActive;
}
