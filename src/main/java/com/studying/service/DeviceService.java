package com.studying.service;

import com.studying.entity.DeviceEntity;
import com.studying.repository.DeviceRepository;
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


    public DeviceEntity createDevice(final DeviceEntity deviceEntity) {
        return deviceRepository.save(deviceEntity);
    }
}
