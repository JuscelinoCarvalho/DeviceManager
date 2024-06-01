package com.studying.service;

import com.studying.dto.DeviceResponseDTO;
import com.studying.entity.DeviceEntity;
import com.studying.mapper.DeviceMapper;
import com.studying.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<DeviceEntity> findDeviceByID(final UUID id){
        return deviceRepository.findById(id);
    }

    public void deleteDeviceByID(final UUID id){
        deviceRepository.deleteById(id);
    }


    public boolean updateDevice(DeviceResponseDTO device){

        DeviceEntity deviceEntity = DeviceMapper.mapToDeviceEntity(device);

        try{
            deviceRepository.save(deviceEntity);
            return  true;
        }catch(Exception ex){
            return false;
        }


    }

    public boolean deleteDeviceById(final UUID deviceId){
        try{
            deviceRepository.deleteById(deviceId);
            return true;
        }catch (Exception ex){
            return false;
        }

    }




}
