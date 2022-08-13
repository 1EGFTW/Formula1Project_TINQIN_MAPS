package com.tinqin.academy.model;

import com.google.maps.ImageResult;
import com.tinqin.academy.base.OperationResult;
import lombok.*;

import java.awt.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RaceMapsResponse implements OperationResult {
    private byte[] imageData;
}
