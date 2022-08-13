package com.tinqin.academy.error;

import com.tinqin.academy.base.Error;
import org.springframework.http.HttpStatus;

public class GeneralServerError implements Error {
    @Override
    public String getMessage() {
        return "Error generating maps";
    }

    @Override
    public HttpStatus getCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
