package com.mti.presentation.videocontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByTokenResponse {
    public String name;

    public String streamLink;

    public Integer likeNb;
}
