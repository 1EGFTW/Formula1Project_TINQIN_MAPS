package com.tinqin.academy.model;

import com.tinqin.academy.base.OperationInput;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
public class RaceMapsRequest implements OperationInput {
    private Double lat;
    private Double lon;
}
