package com.studying.controller;

import com.studying.dto.DeviceResponseDTO;
import com.studying.entity.DeviceEntity;
import com.studying.mapper.DeviceMapper;
import com.studying.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    DeviceMapper deviceMapper = new DeviceMapper();

    @GetMapping(path = "/")
    public ResponseEntity<List<DeviceResponseDTO>> getAll(){
        DeviceResponseDTO dto = DeviceResponseDTO.builder()
                .id(UUID.randomUUID())
                .name("Teste Aula")
                .brand("Marca de Teste")
                .createdAt(ZonedDateTime.now()).build();

        return ResponseEntity.ok(List.of(dto));
    }


    @GetMapping(path = "/all")
    public ResponseEntity<List<DeviceResponseDTO>> getList(){

        List<DeviceResponseDTO> lstDto = new ArrayList<>();
        List<DeviceEntity> lstEntities = this.deviceService.getAllDevices();

        lstEntities.forEach(x -> {
            lstDto.add(deviceMapper.mapToDeviceResponseDTO(x));
        });


        return ResponseEntity.ok(lstDto);
    }

    @PostMapping(path = "/create")
    public DeviceResponseDTO create(@RequestBody DeviceResponseDTO deviceResponseDTO){

        return deviceService.createDevice(deviceResponseDTO);
    }
}
