package com.studying.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DeviceRequestDTOTest {

    @DisplayName("Testes de success!")
    @Test
    void constructorTest(){

        //GIVEN
        String name = "jussa teste name";
        String brand = "Some brand";
        ZonedDateTime createdAt = ZonedDateTime.now();


        //WHEN
        var actual = new DeviceRequestDTO(name, brand, createdAt);

        //THEN
        assertEquals(name, actual.getName());
        assertEquals(brand, actual.getBrand());
        assertEquals(createdAt, actual.getCreatedAt());
        assertNotEquals("10",actual.getName());

    }

    @DisplayName("Testes de possíveis erros!")
    @Test
    void constructorErrorTest(){

        //GIVEN
        String name = "jussa teste name";
        String brand = "Some brand";
        ZonedDateTime createdAt = ZonedDateTime.now();
        var dto = new DeviceRequestDTO(name, brand, createdAt);

        //WHEN
        //var actual = new DeviceRequestDTO(name, brand, createdAt);
        //dto.geraErro();

        //THEN
        assertThrows(RuntimeException.class, dto::geraErro);

    }


}