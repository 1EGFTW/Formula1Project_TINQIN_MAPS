package com.tinqin.academy.rest;

import com.google.maps.ImageResult;
import com.tinqin.academy.model.RaceMapsRequest;
import com.tinqin.academy.model.RaceMapsResponse;
import com.tinqin.academy.rest.controller.HomeController;
import com.tinqin.academy.service.interfaces.GenerateMapsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class RestApplicationTest {
    @Autowired
    private HomeController homeController;

    @MockBean
    private GenerateMapsService generateMapsService;

    @Test
    void testGenerateMaps(){
        RaceMapsRequest raceMapsRequest= RaceMapsRequest.builder()
                .lat(10.0)
                .lon(12.0)
                .build();
        final byte[] imagedata=new byte[10];
        when(generateMapsService.generate(raceMapsRequest))
                .thenReturn(new ImageResult("Image",imagedata));

        RaceMapsResponse raceMapsResponse= RaceMapsResponse.builder()
                .imageData(imagedata)
                .build();
        ResponseEntity<RaceMapsResponse> response=ResponseEntity.ok(raceMapsResponse);
        Assertions.assertEquals(response.getStatusCode(),homeController.generateMaps(raceMapsRequest).getStatusCode());
        Assertions.assertEquals(response,homeController.generateMaps(raceMapsRequest));
    }

}