package com.studying.service;

import com.studying.dto.DeviceResponseDTO;
import com.studying.entity.DeviceEntity;
import com.studying.mapper.DeviceMapper;
import com.studying.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService  {

    private final DeviceRepository deviceRepository;

    public List<DeviceEntity> getAllDevices(){
        return deviceRepository.findAll();
    }


    public DeviceResponseDTO createDevice(DeviceResponseDTO deviceResponseDTO) {
        DeviceEntity device = new DeviceMapper().mapToDeviceEntity(deviceResponseDTO);
        DeviceEntity savedDevice = deviceRepository.save(device);
        return new DeviceMapper().mapToDeviceResponseDTO(savedDevice);
    }
}
