package com.studying.mapper;

import com.studying.dto.DeviceRequestDTO;
import com.studying.dto.DeviceResponseDTO;
import com.studying.entity.DeviceEntity;

public class DeviceMapper {

    private DeviceMapper() {
    }

    public static DeviceResponseDTO mapToDeviceResponseDTO(final DeviceEntity deviceEntity) {

        return DeviceResponseDTO.builder()
                .id(deviceEntity.getId())
                .name(deviceEntity.getName())
                .brand(deviceEntity.getBrand())
                .createdAt(deviceEntity.getCreatedAt()).build();
    }

    public static DeviceEntity mapToDeviceEntity(final DeviceRequestDTO deviceRequestDTO) {
        return DeviceEntity.builder()
                .name(deviceRequestDTO.getName())
                .brand(deviceRequestDTO.getBrand())
                .createdAt(deviceRequestDTO.getCreatedAt())
                .build();
    }

    public static DeviceEntity mapToDeviceEntity(final DeviceResponseDTO deviceResponseDTO) {
        return DeviceEntity.builder()
                .id(deviceResponseDTO.getId())
                .name(deviceResponseDTO.getName())
                .brand(deviceResponseDTO.getBrand())
                .createdAt(deviceResponseDTO.getCreatedAt())
                .build();
    }

}
