package com.tinqin.academy.processor;

import com.tinqin.academy.base.Error;
import com.tinqin.academy.error.GeneralServerError;
import com.tinqin.academy.model.RaceMapsRequest;
import com.tinqin.academy.model.RaceMapsResponse;
import com.tinqin.academy.operation.GenerateMapsProcessor;
import com.tinqin.academy.service.interfaces.GenerateMapsService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Arrays;

@Service
public class GenerateMapsProcessorCore implements GenerateMapsProcessor {
    private final GenerateMapsService generateMapsService;

    public GenerateMapsProcessorCore(GenerateMapsService generateMapsService) {
        this.generateMapsService = generateMapsService;
    }

    @Override
    public Either<Error, RaceMapsResponse> process(RaceMapsRequest input) {
        return Try.of(()->{
            return  RaceMapsResponse.builder()
                    .imageData(generateMapsService.generate(input).imageData)
                    .build();
        }).toEither()
                .mapLeft(throwable -> {
                    return new GeneralServerError();
                });
    }
}
