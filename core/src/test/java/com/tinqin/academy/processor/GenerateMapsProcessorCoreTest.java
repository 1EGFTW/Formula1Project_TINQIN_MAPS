package com.tinqin.academy.processor;

import com.google.maps.ImageResult;
import com.tinqin.academy.model.RaceMapsRequest;
import com.tinqin.academy.model.RaceMapsResponse;
import com.tinqin.academy.service.GenerateMapsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GenerateMapsProcessorCoreTest {
    @Mock
    private GenerateMapsServiceImpl generateMapsService;

    @InjectMocks
    private GenerateMapsProcessorCore generateMapsProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void process() {

        final RaceMapsRequest raceMapsRequest= RaceMapsRequest.builder()
                .lat(10.0)
                .lon(10.0)
                .build();

        final byte[] imagedata=new byte[10];
        when(generateMapsService.generate(raceMapsRequest)).thenReturn(new ImageResult("content",imagedata));
        RaceMapsResponse raceMapsResponse= RaceMapsResponse.builder()
                .imageData(imagedata)
                .build();

        assertNotNull(generateMapsProcessorCore.process(raceMapsRequest).get());

        assertEquals(raceMapsResponse,generateMapsProcessorCore.process(raceMapsRequest).get());

    }
}