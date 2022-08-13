package com.tinqin.academy.service.interfaces;

import com.google.maps.ImageResult;
import com.google.maps.StaticMapsApi;
import com.google.maps.StaticMapsRequest;
import com.tinqin.academy.model.RaceMapsRequest;

public interface GenerateMapsService {
    ImageResult generate(RaceMapsRequest raceMapsRequest);
}
