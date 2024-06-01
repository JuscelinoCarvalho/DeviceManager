package com.studying.controller;

import com.studying.dto.DeviceRequestDTO;
import com.studying.dto.DeviceResponseDTO;
import com.studying.mapper.DeviceMapper;
import com.studying.service.DeviceService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<DeviceResponseDTO>> getList() {

        final var lista = this.deviceService.getAllDevices()
                .stream()
                .map(DeviceMapper::mapToDeviceResponseDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<DeviceResponseDTO> create(@RequestBody @Valid final DeviceRequestDTO deviceRequestDTO) {
        final var deviceEntity = deviceService.createDevice(DeviceMapper.mapToDeviceEntity(deviceRequestDTO));
        return ResponseEntity.ok(DeviceMapper.mapToDeviceResponseDTO(deviceEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponseDTO> getDeviceByID(@PathVariable("id") final UUID idDevice){
        final var deviceEntity = deviceService.findDeviceByID(idDevice);
        return deviceEntity.map(entity -> ResponseEntity.ok(DeviceMapper.mapToDeviceResponseDTO(entity)))
                .orElseGet(() -> ResponseEntity.ok().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeviceByID(@PathVariable("id") final UUID idDevice){
        deviceService.deleteDeviceByID(idDevice);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update")
    public ResponseEntity<Boolean> updateDevice(@RequestBody DeviceResponseDTO device){
        return ResponseEntity.ok(deviceService.updateDevice(device));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteDevice(@PathVariable("id") final UUID idDevice){
        return ResponseEntity.ok(deviceService.deleteDeviceById(idDevice));
    }
}



