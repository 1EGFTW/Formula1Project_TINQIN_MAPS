package com.tinqin.academy.model;

import com.google.maps.ImageResult;
import com.tinqin.academy.base.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class RaceMapsResponse implements OperationResult {
    private byte[] imageData;
}
