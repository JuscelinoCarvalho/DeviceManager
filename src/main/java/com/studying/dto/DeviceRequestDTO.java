package com.studying.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRequestDTO {

    private String name;
    private String brand;
    private ZonedDateTime createdAt;

    public void geraErro(){
        throw new RuntimeException();
    }
}
