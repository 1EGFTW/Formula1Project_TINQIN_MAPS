package com.tinqin.academy.service;

import com.google.maps.GeoApiContext;
import com.google.maps.ImageResult;
import com.google.maps.StaticMapsApi;
import com.google.maps.StaticMapsRequest;
import com.google.maps.model.LatLng;
import com.google.maps.model.Size;
import com.tinqin.academy.model.RaceMapsRequest;
import com.tinqin.academy.service.interfaces.GenerateMapsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class GenerateMapsServiceImpl implements GenerateMapsService {
    @Value("${googleMapsAPIKey}")
    private String apiKey;
    @Override
    public ImageResult generate(RaceMapsRequest raceMapsRequest) {
        final GeoApiContext geoApiContext=new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        final LatLng raceCoordinates=new LatLng(raceMapsRequest.getLat(), raceMapsRequest.getLon());
        final StaticMapsRequest mapsRequest=new StaticMapsRequest(geoApiContext);
        mapsRequest.zoom(14);
        mapsRequest.center(raceCoordinates);
        mapsRequest.size(new Size(500,500));
        final ImageResult result = mapsRequest.awaitIgnoreError();
        geoApiContext.shutdown();
        return result;

    }

}
