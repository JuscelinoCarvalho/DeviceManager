package com.studying.controller;

import com.studying.dto.DeviceRequestDTO;
import com.studying.dto.DeviceResponseDTO;
import com.studying.entity.DeviceEntity;
import com.studying.mapper.DeviceMapper;
import com.studying.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @GetMapping(path = "/all")
    public ResponseEntity<List<DeviceResponseDTO>> getList() {

        final var lista = this.deviceService.getAllDevices()
                .stream()
                .map(DeviceMapper::mapToDeviceResponseDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<DeviceResponseDTO> create(@RequestBody @Valid final DeviceRequestDTO deviceRequestDTO) {
        final var deviceEntity = deviceService.createDevice(DeviceMapper.mapToDeviceEntity(deviceRequestDTO));
        return ResponseEntity.ok(DeviceMapper.mapToDeviceResponseDTO(deviceEntity));
    }
}
