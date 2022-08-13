package com.tinqin.academy.rest.controller;

import com.tinqin.academy.base.Error;
import com.tinqin.academy.model.RaceMapsRequest;
import com.tinqin.academy.model.RaceMapsResponse;
import com.tinqin.academy.operation.GenerateMapsProcessor;
import io.vavr.control.Either;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
public class HomeController {
    private final GenerateMapsProcessor generateMapsProcessor;

    public HomeController(GenerateMapsProcessor generateMapsProcessor) {
        this.generateMapsProcessor = generateMapsProcessor;
    }

    @PostMapping(value = "/maps",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> generateMaps(@RequestBody RaceMapsRequest raceMapsRequest){
        Either<Error, RaceMapsResponse> response=generateMapsProcessor.process(raceMapsRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get().getImageData());
    }
}
