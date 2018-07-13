package com.mti.presentation.videocontroller;

import lombok.Data;

@Data
public class SaveResponse {
    private int id;

    public SaveResponse(int id) {
        this.id = id;
    }
}
