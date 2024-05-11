package com.studying.mapper;

import com.studying.dto.DeviceResponseDTO;
import com.studying.entity.DeviceEntity;

public class DeviceMapper {

    public DeviceResponseDTO mapToDeviceResponseDTO(DeviceEntity deviceEntity){

        return new DeviceResponseDTO(
                deviceEntity.getId(),
                deviceEntity.getName(),
                deviceEntity.getBrand(),
                deviceEntity.getCreatedAt()
        );
    }


    public DeviceEntity mapToDeviceEntity(DeviceResponseDTO deviceResponseDTO){

        return new DeviceEntity(
                deviceResponseDTO.getId(),
                deviceResponseDTO.getName(),
                deviceResponseDTO.getBrand(),
                deviceResponseDTO.getCreatedAt()
        );
    }

}
